package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.ProducerDTO;
import com.example.rateplanmicroservice.model.Producer;
import com.example.rateplanmicroservice.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producers")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    // Get all producers
    @GetMapping
    public ResponseEntity<List<ProducerDTO>> getAllProducers() {
        List<ProducerDTO> producers = producerService.getAllProducers()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(producers);
    }

    // Get producer by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProducerDTO> getProducerById(@PathVariable int id) {
        Producer producer = producerService.getProducerById(id);
        return ResponseEntity.ok(convertToDTO(producer));
    }

    // Create new producer
    @PostMapping
    public ResponseEntity<ProducerDTO> createProducer(@RequestBody ProducerDTO producerDTO) {
        Producer producer = convertToEntity(producerDTO);
        producer.setCreatedAt(LocalDateTime.now()); // Set createdAt automatically
        producer = producerService.saveProducer(producer);
        return ResponseEntity.ok(convertToDTO(producer));
    }

    // Delete producer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducer(@PathVariable int id) {
        producerService.deleteProducer(id);
        return ResponseEntity.noContent().build();
    }

    // Helper method to convert entity to DTO
    private ProducerDTO convertToDTO(Producer producer) {
        ProducerDTO dto = new ProducerDTO();
        dto.setProducerId(producer.getProducerId());
        dto.setProducerName(producer.getProducerName());
        dto.setEmail(producer.getEmail());
        dto.setStatus(producer.getStatus().name());
        dto.setCreatedAt(producer.getCreatedAt()); // Include createdAt field in DTO
        return dto;
    }

    // Helper method to convert DTO to entity
    private Producer convertToEntity(ProducerDTO dto) {
        Producer producer = new Producer();
        producer.setProducerId(dto.getProducerId());
        producer.setProducerName(dto.getProducerName());
        producer.setEmail(dto.getEmail());
        producer.setStatus(Producer.Status.valueOf(dto.getStatus()));
        return producer;
    }
}
