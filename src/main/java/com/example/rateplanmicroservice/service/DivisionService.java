package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.Division;
import com.example.rateplanmicroservice.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    public Division getDivisionById(int id) {
        return divisionRepository.findById(id).orElse(null);
    }

    public Division saveDivision(Division division) {
        return divisionRepository.save(division);
    }

    public void deleteDivision(int id) {
        divisionRepository.deleteById(id);
    }
}
