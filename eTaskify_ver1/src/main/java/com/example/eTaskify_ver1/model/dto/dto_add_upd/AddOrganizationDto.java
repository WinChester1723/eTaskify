package com.example.eTaskify_ver1.model.dto.dto_add_upd;

import com.example.eTaskify_ver1.dao.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrganizationDto {
    private String name;
    private Integer phoneNumber;
    private String address;
    private String userName;
    private String email;
    private List<UserEntity> userEntityList;
}
