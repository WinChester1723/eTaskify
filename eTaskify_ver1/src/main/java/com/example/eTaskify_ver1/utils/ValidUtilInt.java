package com.example.eTaskify_ver1.utils;

import com.example.eTaskify_ver1.dao.entity.OrganizationEntity;
import com.example.eTaskify_ver1.dao.entity.TaskEntity;
import com.example.eTaskify_ver1.dao.entity.UserEntity;
import com.example.eTaskify_ver1.exceptions.CompanyException;
import com.example.eTaskify_ver1.exceptions.PasswordException;
import com.example.eTaskify_ver1.exceptions.TaskException;
import com.example.eTaskify_ver1.exceptions.UserException;

import java.util.Optional;

public interface ValidUtilInt {
    void validatePassword(String password) throws PasswordException;

    void validateCompany(Optional<OrganizationEntity> organizationEntity) throws CompanyException;

    void validateEmployee(Optional<UserEntity> user) throws UserException;

    void validateTask(Optional<TaskEntity> task) throws TaskException;
}
