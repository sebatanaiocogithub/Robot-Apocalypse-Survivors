package com.robot.apocalypsesurvivors.controller;

import com.robot.apocalypsesurvivors.entity.Survivor;
import com.robot.apocalypsesurvivors.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/survivors")
public class SurvivorController {

    //Auto wiring for dependency injection
    @Autowired
    private SurvivorService survivorService;

    //Client request to Update report-contamination
    @PutMapping("/{survivorId}/report-contamination")
    public ResponseEntity<Void> reportContamination(@PathVariable Long survivorId) {
        survivorService.reportContamination(survivorId);
        return ResponseEntity.ok().build();
    }

    //Client request to Update last location(longitude & latitude) survivor
    @PutMapping("/{survivorId}/location")
    public ResponseEntity<Survivor> updateLastLocation(
            @PathVariable Long survivorId,
            @RequestParam Double latitude,
            @RequestParam Double longitude) {
        Survivor updatedSurvivor = survivorService.updateLastLocation(survivorId, latitude, longitude);
        return ResponseEntity.ok(updatedSurvivor);
    }

    //Client request to Get all infected survivors
    @GetMapping("/infected")
    public ResponseEntity<List<Survivor>> getInfectedSurvivors() {
        List<Survivor> infectedSurvivors = survivorService.getInfectedSurvivors();
        return ResponseEntity.ok(infectedSurvivors);
    }

    //Client request to Get all non-infected survivors
    @GetMapping("/nonInfected")
    public ResponseEntity<List<Survivor>> getNonInfectedSurvivors() {
        List<Survivor> nonInfectedSurvivors = survivorService.getNonInfectedSurvivors();
        return ResponseEntity.ok(nonInfectedSurvivors);
    }


    //Client request to Create a new survivor
    @PostMapping
    public Survivor createSurvivor(@RequestBody Survivor survivor) {
        return survivorService.createSurvivor(survivor);
    }

    //Client request to Get all survivors
    @GetMapping
    public List<Survivor> getAllSurvivors() {
        return survivorService.getAllSurvivors();
    }

    //Client request to Get survivor by ID
    @GetMapping("/{id}")
    public Optional<Survivor> getSurvivorById(@PathVariable Long id) {
        return survivorService.getSurvivorById(id);
    }
    

    //Client request to Update survivor by ID
    @PutMapping("/{id}")
    public Survivor updateSurvivor(@PathVariable Long id, @RequestBody Survivor survivorDetails) {
        return survivorService.updateSurvivor(id, survivorDetails);
    }

    //Client request to Delete all members
    @DeleteMapping
    public String deleteAllSurvivors() {
        survivorService.deleteAllSurvivors();
        return "All survivors have been deleted successfully.";
    }

    //Client request to Delete member by ID
    @DeleteMapping("/{id}")
    public void deleteSurvivor(@PathVariable Long id) {
        survivorService.deleteSurvivor(id);
    }

}
