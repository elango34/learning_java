package com.elango.ehr;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private int duration;
    private LocalDateTime scheduledAt;

    @ManyToOne
    private Patient patient;


    public Appointment( String status, int duration, LocalDateTime scheduledAt, Patient patient) {
        this.status = status;
        this.duration = duration;
        this.scheduledAt = scheduledAt;
        this.patient = patient;
    }

    Appointment() {}



    public long getId() {
        return id;
    }



    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }



    public int getDuration() {
        return duration;
    }



    public void setDuration(int duration) {
        this.duration = duration;
    }



    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }



    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }



    public Patient getPatient() {
        return patient;
    }



    public void setPatient(Patient patient) {
        this.patient = patient;
    }



    @Override
    public String toString() {
        return "Appointment [id=" + id + ", status=" + status + ", duration=" + duration + ", scheduledAt="
                + scheduledAt + ", patient=" + patient + "]";
    }



    public void setId(Long id) {
        this.id = id;
    }

    

}
