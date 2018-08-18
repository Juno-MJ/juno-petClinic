package juno.springboot.junopetclinic.Repository;

import juno.springboot.junopetclinic.Model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepo extends CrudRepository<Visit,Long> {
}
