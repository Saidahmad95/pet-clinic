package com.example.services.data_jpa;

import com.example.model.Speciality;
import com.example.repasitories.SpecialityRepo;
import com.example.services.SpecialityService;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SpecialityJpaService implements SpecialityService {

    private final SpecialityRepo specialityRepo;

    public SpecialityJpaService(SpecialityRepo specialityRepo) {
        this.specialityRepo = specialityRepo;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepo.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Speciality with: " + id + " id not found !"));
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepo.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepo.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepo.deleteById(id);
    }
}
