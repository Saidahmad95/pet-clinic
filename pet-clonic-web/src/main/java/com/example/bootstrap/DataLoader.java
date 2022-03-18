package com.example.bootstrap;

import com.example.model.*;
import com.example.services.OwnerService;
import com.example.services.PetTypeService;
import com.example.services.SpecialityService;
import com.example.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int size = petTypeService.findAll().size();
        if (size==0) loadData();

    }

    private void loadData() {
        PetType dog = new PetType("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType("Cat");
        PetType savedCat = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michel");
        owner1.setLastName("Lisping");
        owner1.setAddress("St. Jaime Martins 25");
        owner1.setCity("Lisbon");
        owner1.setTelephone("989105122");

        Owner owner2 = new Owner();
        owner2.setFirstName("Lora");
        owner2.setLastName("Hymn");
        owner2.setAddress("St. Doctor Augusto 10");
        owner2.setCity("Porto");
        owner2.setTelephone("178133098");

        Pet owner1sPet = new Pet();
        owner1sPet.setName("Charlie");
        owner1sPet.setOwner(owner1);
        owner1sPet.setBirthDate(LocalDate.now());
        owner1sPet.setPetType(savedCat);

        Pet owner2sPet = new Pet();
        owner2sPet.setName("Rex");
        owner2sPet.setOwner(owner2);
        owner2sPet.setBirthDate(LocalDate.now());
        owner2sPet.setPetType(savedDog);

        owner1.getPets().add(owner2sPet);
        Owner savedOwner1 = ownerService.save(owner1);

        owner2.getPets().add(owner1sPet);
        Owner savedOwner2 = ownerService.save(owner2);


        Vet vet1 = new Vet();
        vet1.setFirstName("Jora");
        vet1.setLastName("Sarkisyan");
        vet1.getSpecialities().add(savedSurgery);
        Vet savedVet1 = vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Farrux");
        vet2.setLastName("Robbins");
        vet2.getSpecialities().add(savedDentistry);
        vet2.getSpecialities().add(savedRadiology);
        Vet savedVet2 = vetService.save(vet2);

        System.out.println("-------Loaded Owners: " + savedOwner1 + "; " + savedOwner2 +
                "\n-------Loaded Vets: " + savedVet1 + "; " + savedVet2);
    }
}
