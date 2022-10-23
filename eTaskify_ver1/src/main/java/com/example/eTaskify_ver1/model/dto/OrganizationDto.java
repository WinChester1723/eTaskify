package com.example.eTaskify_ver1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

    private Long id;
    private String name;
    private Integer phoneNumber;
    private String address;
    private String userName;
    private String email;
    private String password;

}
