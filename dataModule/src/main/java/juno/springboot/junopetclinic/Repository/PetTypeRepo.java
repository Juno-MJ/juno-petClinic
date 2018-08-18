package juno.springboot.junopetclinic.Repository;

import juno.springboot.junopetclinic.Model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepo extends CrudRepository<PetType,Long> {
}
