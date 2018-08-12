package juno.springboot.junopetclinic.bootstrap;

import juno.springboot.junopetclinic.Model.Owner;
import juno.springboot.junopetclinic.Model.PetType;
import juno.springboot.junopetclinic.Model.Vet;
import juno.springboot.junopetclinic.Services.OwnerService;
import juno.springboot.junopetclinic.Services.PetTypeService;
import juno.springboot.junopetclinic.Services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("First");
        owner1.setLastName("Person");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Second");
        owner2.setLastName("Person");

        ownerService.save(owner2);

        System.out.println("Loaded Owner Data..");

        Vet vet1 = new Vet();
        vet1.setFirstName("First");
        vet1.setLastName("Vet");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Second");
        vet2.setLastName("Vet");

        vetService.save(vet2);


        System.out.println("Loaded Vet Data..");


        PetType petType1 = new PetType();
        petType1.setName("Dog");

        petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("Goat");

        petTypeService.save(petType2);


        System.out.println("Loaded PetType Data..");


    }
}
