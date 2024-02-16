package com.robot.apocalypsesurvivors.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "survivors")
public class Survivor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    @Column(name =  "infected")
    private Boolean infected;

    @Column(name =  "latitude")
    private Double latitude;

    @Column(name =  "longitude")
    private Double longitude;

    @Column(name =  "inventory")
    private String inventory;

    @Column(name =  "contaminationReports")
    private Integer contaminationReports;

    // Constructors
    public Survivor() {

    }
    public Survivor(Long id,
                    String name,
                    Integer age,
                    String gender,
                    Boolean infected,
                    Double latitude,
                    Double longitude,
                    String inventory,
                    Integer contaminationReports ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.infected = infected;
        this.latitude = latitude;
        this.longitude = longitude;
        this.inventory = inventory;
        this.contaminationReports = contaminationReports;
    }

    // Setters and Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Boolean getInfected() {
        return infected;
    }

    public void setInfected(Boolean infected) {
        this.infected = infected;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public Integer getContaminationReports() {
        return contaminationReports;
    }

    public void setContaminationReports(Integer contaminationReports) {
        this.contaminationReports = contaminationReports;
    }
}
