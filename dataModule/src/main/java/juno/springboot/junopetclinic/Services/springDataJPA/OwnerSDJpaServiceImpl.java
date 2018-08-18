package juno.springboot.junopetclinic.Services.springDataJPA;

import juno.springboot.junopetclinic.Model.Owner;
import juno.springboot.junopetclinic.Repository.OwnerRepo;
import juno.springboot.junopetclinic.Services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJPA")
public class OwnerSDJpaServiceImpl implements OwnerService {

    private final OwnerRepo ownerRepo;

    public OwnerSDJpaServiceImpl(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepo.findByLastName(lastName).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepo.save(object);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerRepo.findAll().forEach(ownerSet::add);
        return ownerSet;
    }

    @Override
    public Owner findById(Long aLong) {
       return ownerRepo.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Owner object) {
        ownerRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepo.deleteById(aLong);
    }
}
