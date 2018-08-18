package juno.springboot.junopetclinic.Repository;

import juno.springboot.junopetclinic.Model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ownerRepo")
public interface OwnerRepo extends CrudRepository<Owner,Long>,CrudRepo<Owner> {


}
