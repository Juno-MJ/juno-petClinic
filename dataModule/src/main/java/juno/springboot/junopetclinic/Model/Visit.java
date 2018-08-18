package juno.springboot.junopetclinic.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Visits")
public class Visit extends BaseEntity {

    @Column(name = "date_of_visit")
    private LocalDate dateOfVisit;


    @Column(name = "purpose_of_visit")
    private String purposeOfVisit;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet petBroughtToVisit;

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getPurposeOfVisit() {
        return purposeOfVisit;
    }

    public void setPurposeOfVisit(String purposeOfVisit) {
        this.purposeOfVisit = purposeOfVisit;
    }

    public Pet getPetBroughtToVisit() {
        return petBroughtToVisit;
    }

    public void setPetBroughtToVisit(Pet petBroughtToVisit) {
        this.petBroughtToVisit = petBroughtToVisit;
    }
}
