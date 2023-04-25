package com.mnfokina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Integer id;
    private String name;
    private String genre;
    private String country;
    private Integer year;
    private Integer directorId;
    private Double rating;
}
