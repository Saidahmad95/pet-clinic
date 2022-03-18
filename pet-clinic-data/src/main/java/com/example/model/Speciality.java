package com.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Speciality extends BaseEntity{
    private String description;
}
