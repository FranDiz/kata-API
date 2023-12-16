package com.example.src.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Breweries {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String name;

    private String city;

    private String country;

    private String descript;
}
