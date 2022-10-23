package com.example.eTaskify_ver1.dao.repository;

import com.example.eTaskify_ver1.dao.entity.RoleEntity;
import com.example.eTaskify_ver1.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
//    RoleEntity findByRoleName(RoleEnum roleEnum);
    Optional<RoleEntity> findByRoleName(RoleEnum name);
}
