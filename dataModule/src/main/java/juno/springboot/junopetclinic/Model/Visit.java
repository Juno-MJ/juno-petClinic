package juno.springboot.junopetclinic.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
