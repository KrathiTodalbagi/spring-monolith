package com.example.organisationservice.controller;

import com.example.organisationservice.dto.OrganisationDto;
import com.example.organisationservice.service.OrganisationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/organisations")
public class OrganisationController {

    private final OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @PostMapping
    public ResponseEntity<OrganisationDto> createOrganisation(
            @RequestBody OrganisationDto organisationDto) {
        return new ResponseEntity<>(organisationService.createOrganisation(organisationDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "{code}")
    public ResponseEntity<OrganisationDto> getOrganisation(@PathVariable(value = "code") String organisationCode) {
        return ResponseEntity.ok(organisationService.getOrganisation(organisationCode));
    }
}
