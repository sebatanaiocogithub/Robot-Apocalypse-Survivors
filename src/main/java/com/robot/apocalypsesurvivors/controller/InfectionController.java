package com.robot.apocalypsesurvivors.controller;

import com.robot.apocalypsesurvivors.repository.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class InfectionController {

    @Autowired
    private SurvivorRepository survivorRepository;

    @GetMapping("/infectedPercentage")
    public ResponseEntity<Map<String, Double>> calculateInfectedPercentage() {
        // Get the total number of survivors
        long totalSurvivors = survivorRepository.count();

        // Get the number of infected survivors
        long infectedSurvivors = survivorRepository.countByInfectedTrue();

        // Calculate the percentage of infected survivors
        double infectedPercentage = (infectedSurvivors / (double) totalSurvivors) * 100;

        // Calculate the percentage of non-infected survivors
        double nonInfectedPercentage = 100 - infectedPercentage;

        // Create a map to hold the percentages
        Map<String, Double> percentages = new HashMap<>();
        percentages.put("infectedPercentage", infectedPercentage);
        percentages.put("nonInfectedPercentage", nonInfectedPercentage);

        return ResponseEntity.ok(percentages);
    }
}


