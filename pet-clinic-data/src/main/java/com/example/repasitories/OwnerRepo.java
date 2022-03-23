package com.example.repasitories;

import com.example.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OwnerRepo extends CrudRepository<Owner, Long> {
  Optional<Owner> findByLastName(String lastName);
}
