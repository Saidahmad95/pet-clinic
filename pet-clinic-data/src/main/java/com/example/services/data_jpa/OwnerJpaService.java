package com.example.services.data_jpa;

import com.example.model.Owner;
import com.example.repasitories.OwnerRepo;
import com.example.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OwnerJpaService implements OwnerService {

    private final OwnerRepo ownerRepo;

    public OwnerJpaService(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepo.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Owner with " + id + " id not found "));
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepo.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepo.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepo.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepo.findByLastName(lastName).orElseThrow(
                () -> new RuntimeException("Owner with '" +lastName + "' lastname not found !"));
    }
}
