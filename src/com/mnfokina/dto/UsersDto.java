package com.mnfokina.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class UsersDto {
    Integer id;
    String fullName;
    String password;
    String eMail;
    Integer roleId;
}
