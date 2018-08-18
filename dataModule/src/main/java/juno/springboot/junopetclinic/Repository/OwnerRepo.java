package juno.springboot.junopetclinic.Repository;

import juno.springboot.junopetclinic.Model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepo extends CrudRepository<Owner,Long> {


}
