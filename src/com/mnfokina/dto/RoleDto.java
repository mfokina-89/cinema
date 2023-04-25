package com.mnfokina.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class RoleDto {
    Integer id;
    String role;
}
