package juno.springboot.junopetclinic.Services.Map;

import juno.springboot.junopetclinic.Model.Speciality;
import juno.springboot.junopetclinic.Services.SpecialityService;

import java.util.Set;

public class SpecialityServiceMap extends AbstractMapService<Speciality,Long> implements SpecialityService {

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
