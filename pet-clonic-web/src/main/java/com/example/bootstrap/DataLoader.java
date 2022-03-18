package com.example.bootstrap;

import com.example.model.Owner;
import com.example.model.Vet;
import com.example.services.OwnerService;
import com.example.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michel");
        owner1.setLastName("Bisping");

        Owner savedOwner1 = ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Lora");
        owner2.setLastName("Hymn");

        Owner savedOwner2 = ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setLastName("Jora");
        vet1.setFirstName("Sarkisyan");

        Vet savedVet1 = vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setLastName("Farrux");
        vet2.setFirstName("Robbins");

        Vet savedVet2 = vetService.save(vet2);

        System.out.println("-------Loaded Owners: " + savedOwner1 + "; " + savedOwner2 +
                "\n-------Loaded Vets: " + savedVet1 + "; " + savedVet2);

    }
}
