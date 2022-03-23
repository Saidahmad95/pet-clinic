package com.example.repasitories;

import com.example.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetTypeRepo extends CrudRepository<PetType, Long> {
}
