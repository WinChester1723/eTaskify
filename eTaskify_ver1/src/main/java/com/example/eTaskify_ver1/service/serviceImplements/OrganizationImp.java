package com.example.eTaskify_ver1.service.serviceImplements;

import com.example.eTaskify_ver1.model.dto.OrganizationDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddOrganizationDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.UpdateOrganizationDto;
import com.example.eTaskify_ver1.service.serviceInterface.OrganizationServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrganizationImp implements OrganizationServiceInt {
    @Override
    public OrganizationDto findOrgId(long id) {
        return null;
    }

    @Override
    public List<OrganizationDto> allOrg() {
        return null;
    }

    @Override
    public OrganizationDto addOrg(AddOrganizationDto addOrganizationDto) {
        return null;
    }

    @Override
    public OrganizationDto updOrg(UpdateOrganizationDto updateOrganizationDto) {
        return null;
    }

    @Override
    public OrganizationDto findByOrgName(String name) {
        return null;
    }
}
