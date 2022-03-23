package com.example.services.data_jpa;

import com.example.model.Pet;
import com.example.repasitories.PetRepo;
import com.example.services.PetService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PetJpaService implements PetService {

    private final PetRepo petRepo;

    public PetJpaService(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepo.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepo.findById(id).orElseThrow(() -> new RuntimeException("Pet with : " + id + " id not found !"));
    }

    @Override
    public Pet save(Pet pet) {
        return petRepo.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepo.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepo.deleteById(id);
    }
}
