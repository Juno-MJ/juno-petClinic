package juno.springboot.junopetclinic.Services;

import juno.springboot.junopetclinic.Model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

}
