package juno.springboot.junopetclinic.Services;

import juno.springboot.junopetclinic.Model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
