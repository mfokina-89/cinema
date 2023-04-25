package com.mnfokina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private Integer id;
    private Integer movieId;
    private Integer usersId;
    private String text;
    private Integer score;
}
