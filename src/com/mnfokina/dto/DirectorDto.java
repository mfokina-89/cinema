package com.mnfokina.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@AllArgsConstructor
@Builder
public class DirectorDto {
    Integer id;
    String fullName;
    LocalDateTime birthDate;
}
