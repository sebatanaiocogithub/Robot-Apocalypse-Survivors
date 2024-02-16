package com.robot.apocalypsesurvivors.controller;

import com.robot.apocalypsesurvivors.entity.Robot;
import com.robot.apocalypsesurvivors.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/robots")
public class RobotController {

    //Auto wiring for dependency injection
    @Autowired
    private RobotService robotService;

    //Client request to Get all robots by "land" category
    @GetMapping("/land")
    public ResponseEntity<List<Robot>> getRobotsByLandCategory() {
        List<Robot> landRobots = robotService.getRobotsByLandCategory();
        return ResponseEntity.ok(landRobots);
    }

    //Client request to Get all robots by "flying" category
    @GetMapping("/flying")
    public ResponseEntity<List<Robot>> getRobotsByFlyingCategory() {
        List<Robot> flyingRobots = robotService.getRobotsByFlyingCategory();
        return ResponseEntity.ok(flyingRobots);
    }

    //Client request to Get robot by model
    @GetMapping("/{model}")
    public ResponseEntity<Robot> getRobotByModel(@PathVariable String model) {
        Robot robot = robotService.getRobotByModel(model);
        if (robot != null) {
            return ResponseEntity.ok(robot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Client request to Get robot by serialNumber
    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<Robot> getRobotBySerialNumber(@PathVariable String serialNumber) {
        Robot robot = robotService.getRobotBySerialNumber(serialNumber);
        if (robot != null) {
            return ResponseEntity.ok(robot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Client request to Post a new robot
    @PostMapping
    public Robot createRobot(@RequestBody Robot robot) {
        return robotService.createRobot(robot);
    }

    //Client request to Get all robots
    @GetMapping
    public List<Robot> getAllRobots() {
        return robotService.getAllRobot();
    }

    //Client request to Delete all robots
    @DeleteMapping
    public String deleteAllRobots() {
        robotService.deleteAllRobots();
            return "All survivors have been deleted successfully.";
    }

    //Client request to Delete member by ID
    @DeleteMapping("/{id}")
    public void deleteRobot(@PathVariable Long id) {
        robotService.deleteRobot(id);
    }

}

