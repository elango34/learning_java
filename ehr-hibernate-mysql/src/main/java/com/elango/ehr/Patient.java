package com.elango.ehr;

import java.util.List;

import jakarta.persistence.*;

// If we give like this @Table(name="patients") then the table name is considered as this instead of the class name 
@Entity
@Table(name = "patients")
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // If we give like this @Table(name="full_name") then the column name is considered as this instead of the property name 
    @Column(name = "full_name", nullable = false, length = 120)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, length = 20)
    private String status;

    // will be avoided in the table
    @Transient
    private String temp;

    private Address address;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @ManyToMany
    private List<Medication> medications;

    @ManyToMany(mappedBy = "patients")
    private List<Provider> providers;

    public Patient() {}

    public Patient( String name, int age, String status, Address address) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.address = address;
    }


    public String getTemp() {
        return temp;
    }


    public void setTemp(String temp) {
        this.temp = temp;
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }


    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    
    
    
}
