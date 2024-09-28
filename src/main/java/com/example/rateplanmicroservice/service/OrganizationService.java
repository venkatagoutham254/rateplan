package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.dto.OrganizationDTO;
import com.example.rateplanmicroservice.model.Organization;
import com.example.rateplanmicroservice.model.Producer;
import com.example.rateplanmicroservice.repository.OrganizationRepository;
import com.example.rateplanmicroservice.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private ProducerRepository producerRepository;

    // Fetch all organizations and return as DTOs
    public List<OrganizationDTO> getAllOrganizations() {
        return organizationRepository.findAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    // Fetch an organization by ID and return the entity (used for setting in other entities like Product)
    public Organization getOrganizationEntityById(int id) {
        return organizationRepository.findById(id).orElse(null);
    }

    // Fetch an organization by ID and return it as a DTO (for external use)
    public OrganizationDTO getOrganizationById(int id) {
        Organization organization = organizationRepository.findById(id).orElse(null);
        if (organization == null) {
            return null; // Handle null case appropriately
        }
        return convertToDTO(organization);
    }

    // Save a new organization and return it as a DTO
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {
        // Fetch the producer entity using producerId
        Producer producer = producerRepository.findById(organizationDTO.getProducerId())
                .orElseThrow(() -> new RuntimeException("Producer not found with id: " + organizationDTO.getProducerId()));

        Organization organization = new Organization();
        organization.setOrganizationName(organizationDTO.getOrganizationName());
        organization.setProducer(producer);

        Organization savedOrganization = organizationRepository.save(organization);
        return convertToDTO(savedOrganization);
    }

    // Delete an organization by ID
    public void deleteOrganization(int id) {
        organizationRepository.deleteById(id);
    }

    // Helper method to convert Organization entity to DTO
    private OrganizationDTO convertToDTO(Organization organization) {
        OrganizationDTO dto = new OrganizationDTO();
        dto.setOrganizationId(organization.getOrganizationId());
        dto.setProducerId(organization.getProducer().getProducerId());
        dto.setOrganizationName(organization.getOrganizationName());
        return dto;
    }
}
