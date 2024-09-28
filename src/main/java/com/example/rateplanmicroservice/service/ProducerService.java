package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.Producer;
import com.example.rateplanmicroservice.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    public List<Producer> getAllProducers() {
        return producerRepository.findAll();
    }

    public Producer getProducerById(int id) {
        return producerRepository.findById(id).orElse(null);
    }

    public Producer saveProducer(Producer producer) {
        return producerRepository.save(producer);
    }

    public void deleteProducer(int id) {
        producerRepository.deleteById(id);
    }
}
