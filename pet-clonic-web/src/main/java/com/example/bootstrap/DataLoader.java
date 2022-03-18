package com.example.bootstrap;

import com.example.model.Owner;
import com.example.model.PetType;
import com.example.model.Vet;
import com.example.services.OwnerService;
import com.example.services.VetService;
import com.example.services.map.PetTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog=new PetType("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType("Cat");
        petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michel");
        owner1.setLastName("Bisping");

        Owner savedOwner1 = ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Lora");
        owner2.setLastName("Hymn");

        Owner savedOwner2 = ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Jora");
        vet1.setLastName("Sarkisyan");

        Vet savedVet1 = vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Farrux");
        vet2.setLastName("Robbins");

        Vet savedVet2 = vetService.save(vet2);

        System.out.println("-------Loaded Owners: " + savedOwner1 + "; " + savedOwner2 +
                "\n-------Loaded Vets: " + savedVet1 + "; " + savedVet2);

    }
}
