package com.mnfokina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private Integer id;
    private String fullName;
    private String password;
    private String eMail;
    private Integer roleId;
}
