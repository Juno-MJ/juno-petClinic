package juno.springboot.junopetclinic.Services.springDataJPA;


import juno.springboot.junopetclinic.Model.PetType;
import juno.springboot.junopetclinic.Repository.PetTypeRepo;
import juno.springboot.junopetclinic.Services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJPA")
public class petTypeSDJpaServiceImpl implements PetTypeService {

    private final PetTypeRepo petTypeRepo;

    public petTypeSDJpaServiceImpl(PetTypeRepo petTypeRepo) {
        this.petTypeRepo = petTypeRepo;
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepo.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypeSets = new HashSet<>();
        petTypeRepo.findAll().forEach(petTypeSets::add);
        return petTypeSets;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepo.findById(aLong).orElse(null);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepo.deleteById(aLong);
    }
}
