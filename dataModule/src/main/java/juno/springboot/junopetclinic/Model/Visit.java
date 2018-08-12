package juno.springboot.junopetclinic.Model;

import java.time.LocalDate;

public class Visit extends BaseEntity {

    private LocalDate dateOfVisit;
    private String purposeOfVisit;
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
