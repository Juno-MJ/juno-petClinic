package juno.springboot.junopetclinic.Repository;

import juno.springboot.junopetclinic.Model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<Pet,Long> {
}
