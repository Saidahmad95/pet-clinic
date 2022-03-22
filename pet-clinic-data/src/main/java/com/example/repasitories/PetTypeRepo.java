package com.example.repasitories;

import com.example.model.PetType;
import org.springframework.data.repository.CrudRepository;


public interface PetTypeRepo extends CrudRepository<PetType, Long> {
}
