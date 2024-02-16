package com.robot.apocalypsesurvivors.service;

import com.robot.apocalypsesurvivors.entity.Survivor;
import com.robot.apocalypsesurvivors.repository.SurvivorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurvivorService {

    //Auto wiring for dependency injection
    @Autowired
    private SurvivorRepository survivorRepository;

    //Business Logic for reporting Contamination
    public void reportContamination(Long survivorId) {
        Survivor survivor = survivorRepository.findById(survivorId)
                .orElseThrow(() -> new EntityNotFoundException("Survivor not found"));

        // Increment the contamination reports
        survivor.setContaminationReports(survivor.getContaminationReports() + 1);

        // Check if the survivor should be marked as infected
        if (survivor.getContaminationReports() >= 3) {
            survivor.setInfected(true);
        }

        survivorRepository.save(survivor);
    }

    //Business Logic for Updating last location(longitude & latitude) survivor
    public Survivor updateLastLocation(Long survivorId, Double latitude, Double longitude) {
        Optional<Survivor> optionalSurvivor = survivorRepository.findById(survivorId);
        if (optionalSurvivor.isPresent()) {
            Survivor survivor = optionalSurvivor.get();
            survivor.setLatitude(latitude);
            survivor.setLongitude(longitude);
            return survivorRepository.save(survivor);
        } else {
            throw new EntityNotFoundException("Survivor not found with id: " + survivorId);
        }
    }

    //Business Logic for Updating survivor
    public Survivor updateSurvivor(Long id, Survivor survivorDetails) {
        Optional<Survivor> survivor = survivorRepository.findById(id);
        if(survivor.isPresent()) {
            Survivor existingSurvivor = survivor.get();
            existingSurvivor.setName(survivorDetails.getName());
            existingSurvivor.setGender(survivorDetails.getGender());
            existingSurvivor.setAge(survivorDetails.getAge());
            existingSurvivor.setInventory(survivorDetails.getInventory());
            existingSurvivor.setContaminationReports(survivorDetails.getContaminationReports());

        }
        return null;
    }

    //Business Logic to Get all infected survivors
    public List<Survivor> getInfectedSurvivors() {
        return survivorRepository.findByInfectedTrue();
    }

    //Business Logic to Get all non-infected survivors
    public List<Survivor> getNonInfectedSurvivors() {
        return survivorRepository.findByInfectedFalse();
    }

    //Business Logic to Delete all survivors
    public void deleteAllSurvivors() {
        survivorRepository.deleteAll();
    }

    //Business Logic to Delete survivor by ID
    public void deleteSurvivor(Long id) {
        survivorRepository.deleteById(id);
    }

    //Business Logic to Create new survivor
    public Survivor createSurvivor(Survivor survivor) {
        return survivorRepository.save(survivor);
    }

    //Business Logic to Get all survivors
    public List<Survivor> getAllSurvivors() {
        return survivorRepository.findAll();
    }

    //Business Logic to Get survivor by ID
    public Optional<Survivor> getSurvivorById(Long id) {
        return survivorRepository.findById(id);
    }

}
