package com.robot.apocalypsesurvivors.entity;

import jakarta.persistence.*;

// Entity class representing data
@Entity
@Table(name = "robots")
public class Robot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "serialNumber")
    private String serialNumber;

    @Column(name = "manufacturedDate")
    private String manufacturedDate;

    @Column(name = "category")
    private String category;

    // Constructors
    public Robot() {
    }
    public Robot(String model,
                 String serialNumber,
                 String manufacturedDate,
                 String category) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.manufacturedDate = manufacturedDate;
        this.category = category;
    }

    // Setters and Getters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
