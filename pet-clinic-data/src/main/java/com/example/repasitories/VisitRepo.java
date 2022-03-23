package com.example.repasitories;

import com.example.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VisitRepo extends CrudRepository<Visit, Long> {
}
