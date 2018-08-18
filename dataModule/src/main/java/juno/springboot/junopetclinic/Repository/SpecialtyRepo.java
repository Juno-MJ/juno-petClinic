package juno.springboot.junopetclinic.Repository;

import juno.springboot.junopetclinic.Model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepo extends CrudRepository<Speciality,Long> {
}
