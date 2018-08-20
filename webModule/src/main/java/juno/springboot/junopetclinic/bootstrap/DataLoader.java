package juno.springboot.junopetclinic.bootstrap;

import juno.springboot.junopetclinic.Model.*;
import juno.springboot.junopetclinic.Services.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    //Pet service not included bcz..pet will be cascaded auto by hibernate
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        int count = petTypeService.findAll().size();
        if(count==0){
            loadData();
        }
    }


    private void loadData() {
        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType dog = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("Goat");
        PetType goat = petTypeService.save(petType2);

        System.out.println("Loaded PetType Data..");


        Speciality speciality1 = new Speciality();
        speciality1.setDescription("Surgery");

        Speciality surgery = specialityService.save(speciality1);

        Speciality speciality2 = new Speciality();
        speciality2.setDescription("Radiology");

        Speciality radiology = specialityService.save(speciality2);


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


        Visit visit1 = new Visit();
        visit1.setDateOfVisit(LocalDate.now());
        visit1.setPurposeOfVisit("Health Check");
        visit1.setPetBroughtToVisit(owner1spet);

        owner1.addAPet(owner1spet);

        ownerService.save(owner1);
        visitService.save(visit1);

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

        Visit visit2 = new Visit();
        visit2.setDateOfVisit(LocalDate.now());
        visit2.setPurposeOfVisit("Health Check");
        visit2.setPetBroughtToVisit(owner2spet);

        owner2.addAPet(owner2spet);

        ownerService.save(owner2);
        visitService.save(visit2);

        System.out.println("Loaded Owner Data..");



        Vet vet1 = new Vet();
        vet1.setFirstName("First");
        vet1.setLastName("Vet");
        vet1.addASpecialty(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Second");
        vet2.setLastName("Vet");
        vet2.addASpecialty(surgery);

        vetService.save(vet2);


        System.out.println("Loaded Vet Data..");

    }
}
