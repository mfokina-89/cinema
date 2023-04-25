package com.mnfokina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    private Integer id;
    private String fullName;
    private LocalDateTime birthDate;
}
