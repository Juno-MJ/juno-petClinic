package juno.springboot.junopetclinic.Services;

import juno.springboot.junopetclinic.Model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();

}
