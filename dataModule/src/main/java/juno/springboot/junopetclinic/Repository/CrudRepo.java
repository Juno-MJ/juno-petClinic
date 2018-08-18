package juno.springboot.junopetclinic.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CrudRepo<T> {

    @Query("SELECT t FROM T t where t.lastName like %:lastname%")
    Optional<T> findByLastName(@Param("lastname") String lastName);

}
