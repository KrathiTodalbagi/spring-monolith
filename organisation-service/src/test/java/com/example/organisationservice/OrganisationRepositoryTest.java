package com.example.organisationservice;

import com.example.organisationservice.entity.Organisation;
import com.example.organisationservice.repository.OrganisationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class OrganisationRepositoryTest {

    @Autowired
    private OrganisationRepository repository;

    @Test
    void shouldSaveOrganisation() {
        Organisation organisation = new Organisation();
        organisation.setOrganisationName("test");
        organisation.setGetOrganizationDescription("Organisation for testing");
        organisation.setOrganisationCode("Te001");
        Organisation saved = repository.save(organisation);

        assertNotNull(saved.getId());
    }
}
