package com.example.repasitories;

import com.example.model.Pet;
import org.springframework.data.repository.CrudRepository;


public interface PetRepo extends CrudRepository<Pet, Long> {
}
