package com.example.eTaskify_ver1.dao.repository;

import com.example.eTaskify_ver1.dao.entity.UserEntity;
import com.example.eTaskify_ver1.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
    Optional<UserEntity> findUserEntityByEmail(String email);
    UserEntity findByName(String name);
    Boolean existsByEmail(String email);
    Boolean existsByName(String name);

    List<UserEntity> findByRoles(RoleEnum roleEnum);
}
