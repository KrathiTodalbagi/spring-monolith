package com.example.organisationservice.service.impl;

import com.example.organisationservice.dto.OrganisationDto;
import com.example.organisationservice.entity.Organisation;
import com.example.organisationservice.repository.OrganisationRepository;
import com.example.organisationservice.service.OrganisationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrganisationServiceImpl implements OrganisationService {
    private final ModelMapper modelMapper;
    private final OrganisationRepository organisationRepository;

    public OrganisationServiceImpl(ModelMapper modelMapper, OrganisationRepository organisationRepository) {
        this.modelMapper = modelMapper;
        this.organisationRepository = organisationRepository;
    }

    @Override
    public OrganisationDto createOrganisation(OrganisationDto organisationDto) {
        Organisation organisation = modelMapper.map(organisationDto, Organisation.class);
        return modelMapper.map(organisationRepository.save(organisation), OrganisationDto.class);
    }

    @Override
    public OrganisationDto getOrganisation(String organisationCode) {
        return modelMapper.map(organisationRepository.findByOrganisationCode(organisationCode), OrganisationDto.class);
    }
}
