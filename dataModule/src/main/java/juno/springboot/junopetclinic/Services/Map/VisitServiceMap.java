package juno.springboot.junopetclinic.Services.Map;

import juno.springboot.junopetclinic.Model.Visit;
import juno.springboot.junopetclinic.Services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit object) {
        if(object.getPetBroughtToVisit() == null  || object.getPetBroughtToVisit().getOwner() == null ||
        object.getPetBroughtToVisit().getId() == null || object.getPetBroughtToVisit().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
