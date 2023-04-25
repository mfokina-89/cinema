package com.mnfokina.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class ReviewDto {
    Integer id;
    Integer movieId;
    Integer usersId;
    String text;
    Integer score;
}
