package com.example.eTaskify_ver1.service.serviceInterface;

import com.example.eTaskify_ver1.model.dto.OrganizationDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddOrganizationDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.UpdateOrganizationDto;

import java.util.List;

public interface OrganizationServiceInt {
    OrganizationDto findOrgId(long id);
    List<OrganizationDto> allOrg();
    OrganizationDto addOrg(AddOrganizationDto addOrganizationDto);
    OrganizationDto updOrg(UpdateOrganizationDto updateOrganizationDto);
    OrganizationDto findByOrgName(String name);
}
