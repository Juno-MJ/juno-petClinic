package juno.springboot.junopetclinic.Services.Map;

import juno.springboot.junopetclinic.Model.Owner;
import juno.springboot.junopetclinic.Model.Pet;
import juno.springboot.junopetclinic.Services.OwnerService;
import juno.springboot.junopetclinic.Services.PetService;
import juno.springboot.junopetclinic.Services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService,PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner save(Owner object){

        System.out.println("Retrieved the Owner object");
        System.out.println("Checking if he has pets");
        if(object!=null) {
            if (object.getPets() != null) {
                System.out.println("Checking if each of his pets is present in the overall pet list");
                object.getPets().forEach(pet -> {

                    if(pet.getPetType() !=null){
                        //Checking if current petType is present in Overall list
                        if(pet.getPetType().getId()==null) {
                            System.out.println("PetType" + pet.getPetType().getName() + " Not present");
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type Required for Pets");
                    }

                    if (pet.getId() == null) {
                        System.out.println("Pet Id->" + pet.getId() + " is not present");
                        System.out.println("Adding it to overall list");
                        Pet savedPet = petService.save(pet);
                        // So that it will  be retrieved when traversing the hashmap
                        pet.setId(savedPet.getId());
                    }
                });

                return super.save(object);

            } else {
                throw new RuntimeException("Pets Required for Pet Clinic Visit");
            }
        }else{
            System.out.println("Null Object Given");
            return null;
        }


    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
