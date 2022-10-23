package com.example.eTaskify_ver1.model.dto;

import com.example.eTaskify_ver1.model.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Long id;
    private RoleEnum roleName;

}
