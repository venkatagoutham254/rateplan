package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.DivisionDTO;
import com.example.rateplanmicroservice.model.Division;
import com.example.rateplanmicroservice.model.Organization;
import com.example.rateplanmicroservice.service.DivisionService;
import com.example.rateplanmicroservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/divisions")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public ResponseEntity<List<DivisionDTO>> getAllDivisions() {
        List<DivisionDTO> divisions = divisionService.getAllDivisions().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(divisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DivisionDTO> getDivisionById(@PathVariable int id) {
        Division division = divisionService.getDivisionById(id);
        return ResponseEntity.ok(convertToDTO(division));
    }
    @PostMapping
    public ResponseEntity<DivisionDTO> createDivision(@RequestBody DivisionDTO divisionDTO) {
        // Fetch the actual Organization entity by organizationId
        Organization organization = organizationService.getOrganizationEntityById(divisionDTO.getOrganizationId());

        // Check if organization exists
        if (organization == null) {
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request if organization doesn't exist
        }

        Division division = convertToEntity(divisionDTO);
        division.setOrganization(organization); // Set the organization in the Division entity
        division = divisionService.saveDivision(division);

        return ResponseEntity.ok(convertToDTO(division));
    }

  
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDivision(@PathVariable int id) {
        divisionService.deleteDivision(id);
        return ResponseEntity.noContent().build();
    }

    private DivisionDTO convertToDTO(Division division) {
        DivisionDTO dto = new DivisionDTO();
        dto.setDivisionId(division.getDivisionId());
        dto.setOrganizationId(division.getOrganization().getOrganizationId());
        dto.setDivisionName(division.getDivisionName());
        return dto;
    }

    private Division convertToEntity(DivisionDTO dto) {
        Division division = new Division();
        division.setDivisionId(dto.getDivisionId());
        division.setDivisionName(dto.getDivisionName());
        return division;
    }
}
