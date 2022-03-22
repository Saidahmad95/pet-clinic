package com.example.repasitories;

import com.example.model.Visit;
import org.springframework.data.repository.CrudRepository;


public interface VisitRepo extends CrudRepository<Visit, Long> {
}
