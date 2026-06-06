package com.example.organisationservice.mapper;

import com.example.organisationservice.dto.OrganisationDto;
import com.example.organisationservice.entity.Organisation;

public class OrganisationMapper {

    public static OrganisationDto mapToDto(Organisation organisation) {
        OrganisationDto organisationDto = new OrganisationDto();
        organisationDto.setOrganisationCode(organisation.getOrganisationCode());
        organisationDto.setOrganisationName(organisation.getOrganisationName());
        return organisationDto;
    }
}
