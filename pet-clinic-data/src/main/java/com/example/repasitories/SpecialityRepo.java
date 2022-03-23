package com.example.repasitories;

import com.example.model.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepo extends CrudRepository<Speciality, Long> {
}
