package juno.springboot.junopetclinic.Services.springDataJPA;

import juno.springboot.junopetclinic.Model.Vet;
import juno.springboot.junopetclinic.Repository.VetRepo;
import juno.springboot.junopetclinic.Services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJPA")
public class VetSDJpaServiceImpl implements VetService {

    private final VetRepo vetRepo;

    public VetSDJpaServiceImpl(VetRepo vetRepo) {
        this.vetRepo = vetRepo;
    }

    @Override
    public Vet save(Vet object) {
        return vetRepo.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vetSet = new HashSet<>();
        vetRepo.findAll().forEach(vet -> {vetSet.add(vet);});
        return vetSet;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepo.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Vet object) {
        vetRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepo.deleteById(aLong);
    }

}
