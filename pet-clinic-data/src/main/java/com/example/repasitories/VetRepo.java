package com.example.repasitories;

import com.example.model.Vet;
import org.springframework.data.repository.CrudRepository;


public interface VetRepo extends CrudRepository<Vet, Long> {
}
