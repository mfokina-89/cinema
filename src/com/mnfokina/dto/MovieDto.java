package com.mnfokina.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class MovieDto {
    Integer id;
    String name;
    String genre;
    String country;
    Integer year;
    Integer directorId;
    Double rating;
}
