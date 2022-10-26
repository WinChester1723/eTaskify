package com.example.eTaskify_ver1.controller;

import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddOrganizationDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.UpdateOrganizationDto;
import com.example.eTaskify_ver1.service.serviceInterface.OrganizationServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//before using web pages this file for testing work it or not
@Controller
@RequiredArgsConstructor
@RequestMapping("org-reg")
public class OrgRegistrationController {

    private final OrganizationServiceInt organizationServiceInt;

    @GetMapping("/show")
    public String showRegPage() {
        return "org-registration";
    }

    @PostMapping("/add-org-user")
    public String orgRegister(@ModelAttribute("organization") AddOrganizationDto addOrganizationDto) {
        organizationServiceInt.addOrg(addOrganizationDto);
        return "redirect:org-registration?success";
    }

    @PostMapping("/edit-org-user")
    public String updOrg(@ModelAttribute("editOrg") UpdateOrganizationDto updateOrganizationDto) {
        organizationServiceInt.updOrg(updateOrganizationDto);
        return "redirect:/";
    }
}
