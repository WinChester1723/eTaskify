package com.example.eTaskify_ver1.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "abb_schema", name = "organization")
public class OrganizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "user_name", unique = true)
    private String userName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizationEntity",
            fetch = FetchType.LAZY)
    private List<UserEntity> userEntityList;

//    public void addUsers(UserEntity userEntity) {
//        if (userEntityList == null) {
//            userEntityList = new ArrayList<>();
//        }
//        userEntityList.add(userEntity);
//        userEntity.setOrganizationEntity(this);
//    }

    public OrganizationEntity(Long id, String name, Integer phoneNumber,
                              String address, String userName, String email, List<UserEntity> userEntityList) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userName = userName;
        this.email = email;
        this.userEntityList = userEntityList;
    }

    public OrganizationEntity(String name, Integer phoneNumber, String address, String userName, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userName = userName;
        this.email = email;
    }
}
