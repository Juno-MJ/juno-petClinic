package juno.springboot.junopetclinic.Repository;

import juno.springboot.junopetclinic.Model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepo extends CrudRepository<Vet,Long> {


}
