package juno.springboot.junopetclinic.Services.springDataJPA;

import juno.springboot.junopetclinic.Model.Pet;
import juno.springboot.junopetclinic.Repository.PetRepo;
import juno.springboot.junopetclinic.Services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJPA")
public class petSDJpaServiceImpl implements PetService {

    private final PetRepo petRepo;

    public petSDJpaServiceImpl(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public Pet save(Pet object) {
        petRepo.save(object);
        return object;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> petSets = new HashSet<>();
        petRepo.findAll().forEach(petSets::add);
        return petSets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepo.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Pet object) {
        petRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepo.deleteById(aLong);
    }

}
