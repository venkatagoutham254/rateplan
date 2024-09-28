package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.OrganizationDTO;
import com.example.rateplanmicroservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    // Get all organizations
    @GetMapping
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
        List<OrganizationDTO> organizations = organizationService.getAllOrganizations();
        return ResponseEntity.ok(organizations);
    }

    // Get organization by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> getOrganizationById(@PathVariable int id) {
        OrganizationDTO organizationDTO = organizationService.getOrganizationById(id);
        if (organizationDTO == null) {
            return ResponseEntity.notFound().build(); // Handle if organization not found
        }
        return ResponseEntity.ok(organizationDTO);
    }

    // Create or save an organization
    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization(@RequestBody OrganizationDTO organizationDTO) {
        OrganizationDTO savedOrganization = organizationService.saveOrganization(organizationDTO);
        return ResponseEntity.ok(savedOrganization);
    }

    // Delete organization by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable int id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }
}
