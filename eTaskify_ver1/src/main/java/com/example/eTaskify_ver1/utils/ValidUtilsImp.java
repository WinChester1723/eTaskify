package com.example.eTaskify_ver1.utils;

import com.example.eTaskify_ver1.dao.entity.OrganizationEntity;
import com.example.eTaskify_ver1.dao.entity.TaskEntity;
import com.example.eTaskify_ver1.dao.entity.UserEntity;
import com.example.eTaskify_ver1.exceptions.CompanyException;
import com.example.eTaskify_ver1.exceptions.PasswordException;
import com.example.eTaskify_ver1.exceptions.TaskException;
import com.example.eTaskify_ver1.exceptions.UserException;
import com.example.eTaskify_ver1.model.enums.ErrorMessageEnum;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidUtilsImp implements ValidUtilInt{
    @Override
    public void validatePassword(String password){
        if(password == null || password.length() < 6 || !isAlphaNumericFiscalId(password)){
            throw new PasswordException(ErrorMessageEnum.INVALID_PASSWORD.getMessage());
        }
    }

    private boolean isAlphaNumericFiscalId(String fiscalId){
        final String regex = "^[0-9]*[a-zA-Z][a-zA-Z0-9]*$";
        return fiscalId.matches(regex);
    }

    @Override
    public void validateCompany(Optional<OrganizationEntity> organizationEntity){
        if(!organizationEntity.isPresent()){
            throw new CompanyException(ErrorMessageEnum.INVALID_COMPANY.getMessage());
        }
    }

    @Override
    public void validateEmployee(Optional<UserEntity> user){
        if(!user.isPresent()){
            throw new UserException(ErrorMessageEnum.INVALID_USER.getMessage());
        }
    }

    @Override
    public void validateTask(Optional<TaskEntity> task){
        if(!task.isPresent()){
            throw new TaskException(ErrorMessageEnum.INVALID_TASK.getMessage());
        }
    }
}
