package com.robot.apocalypsesurvivors.service;

import com.robot.apocalypsesurvivors.entity.Robot;
import com.robot.apocalypsesurvivors.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

// Service class
@Service
public class RobotService {

    //Auto wiring for dependency injection
    @Autowired
    private RobotRepository robotRepository;

    //Business Logic to Get robot by serialNumber
    public Robot getRobotBySerialNumber(String serialNumber) {
        return robotRepository.findBySerialNumber(serialNumber);
    }

    //Business Logic to Get robot by model
    public Robot getRobotByModel(String model) {
        return robotRepository.findByModel(model);
    }

    //Business Logic to Get all robots by Land category
    public List<Robot> getRobotsByLandCategory() {
        return robotRepository.findByCategory("Land");
    }

    //Business Logic to Get all robots by Flying category
    public List<Robot> getRobotsByFlyingCategory() {
        return robotRepository.findByCategory("Flying");
    }

    //Post new robot
    public Robot createRobot(Robot robot) {
        return robotRepository.save(robot);
    }

    //Get all robots
    public List<Robot> getAllRobot() {
        return robotRepository.findAll();
    }

    //Delete all robots
    public void deleteAllRobots() {
        robotRepository.deleteAll();
    }

    //Delete robot by ID
    public void deleteRobot(Long id) {
        robotRepository.deleteById(id);
    }

}
