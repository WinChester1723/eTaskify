package com.example.eTaskify_ver1.service.serviceImplements;

import com.example.eTaskify_ver1.dao.entity.OrganizationEntity;
import com.example.eTaskify_ver1.dao.repository.OrganizationRepository;
import com.example.eTaskify_ver1.exceptions.OrganizationException;
import com.example.eTaskify_ver1.mapper.OrganizationMapper;
import com.example.eTaskify_ver1.model.dto.OrganizationDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddOrganizationDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.UpdateOrganizationDto;
import com.example.eTaskify_ver1.model.enums.ErrorMessageEnum;
import com.example.eTaskify_ver1.service.serviceInterface.OrganizationServiceInt;
import com.example.eTaskify_ver1.utils.DefaultGeneratedPass;
import com.example.eTaskify_ver1.utils.ValidUtilInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImp implements OrganizationServiceInt {
    private final OrganizationRepository organizationRepository;
    private final ValidUtilInt validUtilInt;

    @Override
    public OrganizationDto findOrgId(long id) {
        var orgEntity = organizationRepository.findById(id)
                .orElseThrow(() -> new OrganizationException(ErrorMessageEnum.INVALID_ORGANIZATION.getMessage(id)));
        return OrganizationMapper.INSTANCE.entityToDto(orgEntity);
    }

    @Override
    public List<OrganizationDto> allOrg() {
        return organizationRepository.findAll().stream()
                .map(organizationEntity -> OrganizationMapper.INSTANCE.entityToDto(organizationEntity))
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationDto addOrg(AddOrganizationDto addOrganizationDto) {
        var orgEntity = OrganizationEntity.builder()
                .name(addOrganizationDto.getName())
                .phoneNumber(addOrganizationDto.getPhoneNumber())
                .address(addOrganizationDto.getAddress())
                .userName(addOrganizationDto.getUserName())
                .password(DefaultGeneratedPass.generatePassword(8))
                .email(addOrganizationDto.getEmail())
                .userEntityList(addOrganizationDto.getUserEntityList())
                .build();
        organizationRepository.save(orgEntity);

        return OrganizationMapper.INSTANCE.entityToDto(orgEntity);
    }

    @Override
    public OrganizationDto updOrg(UpdateOrganizationDto updateOrganizationDto) {
        var orgDto = findOrgId(updateOrganizationDto.getId());
        validUtilInt.validatePassword(updateOrganizationDto.getPassword());
        orgDto.setName(updateOrganizationDto.getName());
        orgDto.setPhoneNumber(updateOrganizationDto.getPhoneNumber());
        orgDto.setAddress(updateOrganizationDto.getAddress());
        orgDto.setUserName(updateOrganizationDto.getUserName());
        orgDto.setEmail(updateOrganizationDto.getEmail());
        orgDto.setPassword(updateOrganizationDto.getPassword());
        orgDto.setUserEntityList(updateOrganizationDto.getUserEntityList());

        var orgEntity = OrganizationMapper.INSTANCE.dtoToEntity(orgDto);
        organizationRepository.save(orgEntity);

        return OrganizationMapper.INSTANCE.entityToDto(orgEntity);
    }

    @Override
    public OrganizationDto findByOrgName(String name) {
        var orgEntity = organizationRepository.findByName(name)
                .orElseThrow(()-> new OrganizationException(ErrorMessageEnum.INVALID_ORGANIZATION.getMessage()));
        return OrganizationMapper.INSTANCE.entityToDto(orgEntity);
    }
}
