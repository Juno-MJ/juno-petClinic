package juno.springboot.junopetclinic.Model;

import java.time.LocalDate;

public class Pet extends BaseEntity{

    private LocalDate dateOfBirth;
    private Owner owner;
    private PetType petType;

}
