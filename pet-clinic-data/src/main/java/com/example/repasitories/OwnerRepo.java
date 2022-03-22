package com.example.repasitories;

import com.example.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface OwnerRepo extends CrudRepository<Owner, Long> {
}
