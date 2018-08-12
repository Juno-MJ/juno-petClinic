package juno.springboot.junopetclinic.bootstrap;

import juno.springboot.junopetclinic.Model.Owner;
import juno.springboot.junopetclinic.Model.Pet;
import juno.springboot.junopetclinic.Model.PetType;
import juno.springboot.junopetclinic.Model.Vet;
import juno.springboot.junopetclinic.Services.OwnerService;
import juno.springboot.junopetclinic.Services.PetTypeService;
import juno.springboot.junopetclinic.Services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType dog = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("Goat");
        PetType goat = petTypeService.save(petType2);

        System.out.println("Loaded PetType Data..");

        Owner owner1 = new Owner();
        owner1.setFirstName("First");
        owner1.setLastName("Person");
        owner1.setAddress("SankarNagar");
        owner1.setCity("Tirunelveli");
        owner1.setContactNumber("1231231234");

        Pet owner1spet = new Pet();
        owner1spet.setName("Juno");
        owner1spet.setDateOfBirth(LocalDate.now());
        owner1spet.setPetType(dog);
        owner1spet.setOwner(owner1);

        owner1.getPets().add(owner1spet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Second");
        owner2.setLastName("Person");
        owner2.setAddress("Tenkasi");
        owner2.setCity("Tirunelveli");
        owner2.setContactNumber("1231231234");

        Pet owner2spet = new Pet();
        owner2spet.setName("Juno");
        owner2spet.setDateOfBirth(LocalDate.now());
        owner2spet.setPetType(goat);
        owner2spet.setOwner(owner2);

        owner2.getPets().add(owner2spet);


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


    }
}
