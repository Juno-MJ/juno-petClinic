package juno.springboot.junopetclinic.Services.Map;

import juno.springboot.junopetclinic.Model.Vet;
import juno.springboot.junopetclinic.Services.SpecialityService;
import juno.springboot.junopetclinic.Services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        if(object!=null){
            if(object.getSpecialties().size()>0){

                object.getSpecialties().forEach(speciality -> {
                    if(speciality.getId()==null){
                        speciality.setId(specialityService.save(speciality).getId());
                    }
                });


            }else{
                throw new RuntimeException("Vets with Specialities are required");
            }
        }else {
            return null;
        }
        return super.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

