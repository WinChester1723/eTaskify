package com.example.eTaskify_ver1.controller;

import com.example.eTaskify_ver1.model.dto.OrganizationDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddOrganizationDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.UpdateOrganizationDto;
import com.example.eTaskify_ver1.service.serviceInterface.OrganizationServiceInt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("org")
public class OrganizationController {
    private final OrganizationServiceInt organizationServiceInt;

    @GetMapping("/get-org/{id}")
    public OrganizationDto findOrgId(@PathVariable("id") long id){
        return organizationServiceInt.findOrgId(id);
    }

    @GetMapping("/get-org/all")
    public List<OrganizationDto> allOrg(){
        return organizationServiceInt.allOrg();
    }

    @PostMapping("/get-org/add")
    public OrganizationDto addOrg(@RequestBody AddOrganizationDto addOrganizationDto){
        return organizationServiceInt.addOrg(addOrganizationDto);
    }

    @PutMapping("/get-org/upd")
    public OrganizationDto updOrg(@RequestBody UpdateOrganizationDto updateOrganizationDto){
        return organizationServiceInt.updOrg(updateOrganizationDto);
    }

    @GetMapping("/get-org/find/{name}")
    public OrganizationDto findByOrgName(@PathVariable("name") String name){
        return organizationServiceInt.findByOrgName(name);
    }
}
