package juno.springboot.junopetclinic.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pets")
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "petType_id")
    private PetType petType;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "petBroughtToVisit")
    private Set<Visit> visit_dates = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Set<Visit> getVisit_dates() {
        return visit_dates;
    }

    public void setVisit_dates(Set<Visit> visit_dates) {
        this.visit_dates = visit_dates;
    }

    public void addAVisit(Visit visit){
        visit.setPetBroughtToVisit(this);
        this.visit_dates.add(visit);
    }

}
