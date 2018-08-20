package juno.springboot.junopetclinic.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public void addAVisit(Visit visit){
        visit.setPetBroughtToVisit(this);
        this.visit_dates.add(visit);
    }

}
