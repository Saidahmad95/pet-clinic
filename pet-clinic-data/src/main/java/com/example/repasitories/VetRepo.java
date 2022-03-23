package com.example.repasitories;

import com.example.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepo extends CrudRepository<Vet, Long> {
}
