package com.example.services.data_jpa;

import com.example.model.PetType;
import com.example.repasitories.PetTypeRepo;
import com.example.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PetTypeJpaService implements PetTypeService {
    private final PetTypeRepo petTypeRepo;

    public PetTypeJpaService(PetTypeRepo petTypeRepo) {
        this.petTypeRepo = petTypeRepo;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepo.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Pet type with: " + id + " id not found!"));
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepo.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepo.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepo.deleteById(id);
    }
}
