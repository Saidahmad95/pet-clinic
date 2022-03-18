package com.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class Visit extends BaseEntity {
    private LocalDate date;
    private String description;
    private Pet pet;
}
