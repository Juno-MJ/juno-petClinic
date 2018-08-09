package juno.springboot.junopetclinic.bootstrap;

import juno.springboot.junopetclinic.Model.Owner;
import juno.springboot.junopetclinic.Model.Vet;
import juno.springboot.junopetclinic.Services.OwnerService;
import juno.springboot.junopetclinic.Services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("First");
        owner1.setLastName("Person");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Second");
        owner2.setLastName("Person");

        ownerService.save(owner2);

        System.out.println("Loaded Owner Data..");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("First");
        vet1.setLastName("Vet");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Second");
        vet2.setLastName("Vet");

        vetService.save(vet2);


        System.out.println("Loaded Vet Data..");

    }
}
