package com.example.organisationservice.service;

import com.example.organisationservice.dto.OrganisationDto;

public interface OrganisationService {

    OrganisationDto createOrganisation(OrganisationDto organisationDto);
    OrganisationDto getOrganisation(String organisationCode);
}
