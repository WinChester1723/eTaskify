package com.example.eTaskify_ver1.service.serviceImplements;

import com.example.eTaskify_ver1.dao.repository.OrganizationRepository;
import com.example.eTaskify_ver1.exceptions.OrganizationException;
import com.example.eTaskify_ver1.mapper.OrganizationMapper;
import com.example.eTaskify_ver1.model.dto.OrganizationDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddOrganizationDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.UpdateOrganizationDto;
import com.example.eTaskify_ver1.model.enums.ErrorMessageEnum;
import com.example.eTaskify_ver1.service.serviceInterface.OrganizationServiceInt;
import com.example.eTaskify_ver1.utils.ValidUtilInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrganizationServiceImp implements OrganizationServiceInt {
    private final OrganizationRepository organizationRepository;
    private final ValidUtilInt validUtilInt;

    @Override
    public OrganizationDto findOrgId(long id) {
        var orgEntity = organizationRepository.findById(id)
                .orElseThrow(()-> new OrganizationException(ErrorMessageEnum.INVALID_ORGANIZATION.getMessage(id)));
        return OrganizationMapper.INSTANCE.entityToDto(orgEntity);
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
