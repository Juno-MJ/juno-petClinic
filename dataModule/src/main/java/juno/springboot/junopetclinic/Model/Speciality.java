package juno.springboot.junopetclinic.Model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Specialties")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

}
