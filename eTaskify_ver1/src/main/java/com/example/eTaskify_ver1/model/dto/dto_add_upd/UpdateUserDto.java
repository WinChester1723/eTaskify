package com.example.eTaskify_ver1.model.dto.dto_add_upd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
}
