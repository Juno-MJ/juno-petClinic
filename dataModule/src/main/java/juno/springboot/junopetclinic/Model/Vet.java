package juno.springboot.junopetclinic.Model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vets_specialties" , joinColumns = @JoinColumn(name = "vet_id") , inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Speciality> specialties = new HashSet<>();

    public void addASpecialty(Speciality speciality){
        this.specialties.add(speciality);
    }
}
