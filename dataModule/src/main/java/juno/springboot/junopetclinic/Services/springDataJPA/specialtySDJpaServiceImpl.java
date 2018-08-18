package juno.springboot.junopetclinic.Services.springDataJPA;

import juno.springboot.junopetclinic.Model.Speciality;
import juno.springboot.junopetclinic.Repository.SpecialtyRepo;
import juno.springboot.junopetclinic.Services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJPA")
public class specialtySDJpaServiceImpl implements SpecialityService {

    private final SpecialtyRepo specialtyRepo;

    public specialtySDJpaServiceImpl(SpecialtyRepo specialtyRepo) {
        this.specialtyRepo = specialtyRepo;
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepo.save(object);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialitySet = new HashSet<>();
        specialtyRepo.findAll().forEach(specialitySet::add);
        return specialitySet;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtyRepo.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepo.deleteById(aLong);
    }
}
