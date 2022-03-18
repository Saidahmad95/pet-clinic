package com.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;


@EqualsAndHashCode(callSuper = false)
@Data
public class Owner extends Person {
    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets;
}
