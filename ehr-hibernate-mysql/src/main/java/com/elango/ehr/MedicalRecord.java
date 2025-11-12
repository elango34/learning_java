package com.elango.ehr;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="medicalRecords")
public class MedicalRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bloodType;
    private String allergies;
    private String chronicConditions;
    private String medications;
    private String immunizationStatus;
    private String emergencyContact;


    @OneToOne
    private Patient patient; 

    public MedicalRecord(String bloodType, String allergies, String chronicConditions, String medications,
            String immunizationStatus, String emergencyContact) {
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.chronicConditions = chronicConditions;
        this.medications = medications;
        this.immunizationStatus = immunizationStatus;
        this.emergencyContact = emergencyContact;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getBloodType() {
        return bloodType;
    }


    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }


    public String getAllergies() {
        return allergies;
    }


    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }


    public String getChronicConditions() {
        return chronicConditions;
    }


    public void setChronicConditions(String chronicConditions) {
        this.chronicConditions = chronicConditions;
    }


    public String getMedications() {
        return medications;
    }


    public void setMedications(String medications) {
        this.medications = medications;
    }


    public String getImmunizationStatus() {
        return immunizationStatus;
    }


    public void setImmunizationStatus(String immunizationStatus) {
        this.immunizationStatus = immunizationStatus;
    }


    public String getEmergencyContact() {
        return emergencyContact;
    }


    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }


    public Patient getPatient() {
        return patient;
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    

}
