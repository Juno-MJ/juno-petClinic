package juno.springboot.junopetclinic.Services;

import juno.springboot.junopetclinic.Model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
    Owner findByLastName(String lastName);

}
