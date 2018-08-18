package juno.springboot.junopetclinic.Services.springDataJPA;

import juno.springboot.junopetclinic.Model.Visit;
import juno.springboot.junopetclinic.Repository.VisitRepo;
import juno.springboot.junopetclinic.Services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile("SDJPA")
public class VisitSDJpaServiceImpl implements VisitService {


    private final VisitRepo visitRepo;

    public VisitSDJpaServiceImpl(VisitRepo visitRepo) {
        this.visitRepo = visitRepo;
    }

    @Override
    public Visit save(Visit object) {
        return visitRepo.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visitSet = new HashSet<>();
        visitRepo.findAll().forEach(visitSet::add);
        return visitSet;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepo.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Visit object) {
        visitRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepo.deleteById(aLong);
    }
}
