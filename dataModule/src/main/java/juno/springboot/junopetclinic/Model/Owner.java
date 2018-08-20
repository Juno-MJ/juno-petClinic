package juno.springboot.junopetclinic.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Owners")
public class Owner extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "contact_number")
    private String contactNumber;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public void addAPet(Pet pet){
        pet.setOwner(this);
        this.getPets().add(pet);
    }

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String contactNumber, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.contactNumber = contactNumber;
        this.pets = pets;
    }
}
