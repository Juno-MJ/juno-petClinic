package juno.springboot.junopetclinic.Repository;

import juno.springboot.junopetclinic.Model.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("ownerRepo")
public interface OwnerRepo extends CrudRepository<Owner,Long> {

    @Query("SELECT o FROM Owner o where o.lastName like %:lastname%")
    Optional<Owner> findByLastName(@Param("lastname") String lastName);

}
