package com.example.services.data_jpa;

import com.example.model.Visit;
import com.example.repasitories.VisitRepo;
import com.example.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class VisitJpaService implements VisitService {

    private final VisitRepo visitRepo;

    public VisitJpaService(VisitRepo visitRepo) {
        this.visitRepo = visitRepo;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepo.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Visit with: " + id + " id not found !"));
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepo.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepo.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepo.deleteById(id);
    }
}
