package com.example.services.data_jpa;

import com.example.model.Vet;
import com.example.repasitories.VetRepo;
import com.example.services.VetService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class VetJpaService implements VetService {

    private final VetRepo vetRepo;

    public VetJpaService(VetRepo vetRepo) {
        this.vetRepo = vetRepo;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepo.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepo.findById(id).orElseThrow(() -> new RuntimeException("Vet with: " + id + " id not found!"));
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepo.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepo.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepo.deleteById(id);
    }
}
