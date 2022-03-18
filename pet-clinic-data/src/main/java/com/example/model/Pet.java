package com.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class Pet extends BaseEntity{
    private String name;
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

}
