package com.example.src.Modelos;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data @AllArgsConstructor @NoArgsConstructor
@Entity

public class Cerveza {
    @Id
    private long id;

    private Integer brewery_id;

    private Integer cat_id;

    private String name;

    private String descript;

    private Integer style_id;

    private Float abv;

    private Float ibu;

    private Float srm;

    private Integer upc;

    private String filepath;

    private Integer adduser;

    private Date datetime;

}
