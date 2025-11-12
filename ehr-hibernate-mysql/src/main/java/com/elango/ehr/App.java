package com.elango.ehr;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // First create a patient, A patient can exist without any appointment or anything.
        // But for the remaining object this is required.
        Address johnAddress = new Address("test", "test", 612001, 789456123, "John");
        Address ramAddress = new Address("test", "test", 612001, 789132123, "Raj");

        // create patient object
        Patient john = new Patient("john", 27, "fine", johnAddress);
        Patient ram = new Patient("ram", 27, "not good", ramAddress);


        // ============================ One to One Starts ===========================

        /*
         * Let's take medical record for this
         * A patient can be linked to one medical record of his/her own.
         * A medical record can be linked to one patient.
         * On both sides it's linked to one, so it's a one to one
        */

        // Create medical record object 
        MedicalRecord johnMedicalRecord = new MedicalRecord("A+", "prawn", "allergy", "Cetrizine", "none", "123123123");
        MedicalRecord ramMedicalRecord = new MedicalRecord("O+", "none", "none", "none", "none", "24123123123");

        // attach a patient to that
        johnMedicalRecord.setPatient(john);
        ramMedicalRecord.setPatient(ram);


        // ============================ One to Many / May to One ===========================
        /*
        
            * First create a patient, A patient can exist without any appointment.
            * While creating appointment, it must belong to someone.
            * So pass the patient object to the appointment as per the business flow
        
        */ 

        // create appointment object with patient
        Appointment johnApointment = new Appointment("Check In", 120, LocalDateTime.now(), john);
        Appointment johnApointment2 = new Appointment("Checked Out", 0, LocalDateTime.now(), john);
        Appointment ramApointment = new Appointment("Check In", 120, LocalDateTime.now(), ram);


        // Once both object has been created then set the appointments to the patient object.
        john.setAppointments(Arrays.asList(johnApointment, johnApointment2));
        ram.setAppointments(Arrays.asList(ramApointment));
        
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Patient.class)
                     .addAnnotatedClass(Appointment.class)
                     .addAnnotatedClass(MedicalRecord.class);

        configuration.configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

        // we can write like below in a single line
        // Session session2 = new
        // Configuration().addAnnotatedClass(Patient.class).configure("hibernate.cfg.xml").buildSessionFactory().openSession();

        /*
         * The following is used for inserting new row
         * commenting it for now, as i am learning next things
         */
        Transaction transaction1 = session.beginTransaction();

        session.persist(john);
        session.persist(ram);
        session.persist(johnApointment);
        session.persist(johnApointment2);
        session.persist(ramApointment);
        session.persist(johnMedicalRecord);
        session.persist(ramMedicalRecord);

        transaction1.commit();

        // session.close();
        // sf.close();

        // System.out.println(raj);

        // ========== VIEW/UPDATE/DELETE PATIENT ROW ==========


        /*
         
            ============== Commenting it out as working on relationships ==============

        // Step 1: Load the patient from database
        Patient getPatient = session.find(Patient.class, 3);

        if (getPatient != null) {
            // Display current values
            System.out.println("=== BEFORE UPDATE ===");
            System.out.println("ID: " + getPatient.getId());
            System.out.println("Name: " + getPatient.getName());
            System.out.println("Age: " + getPatient.getAge());
            System.out.println("Status: " + getPatient.getStatus());

            // Step 2: Start a transaction
            Transaction transaction = session.beginTransaction();

            // Step 3: Modify the patient object (change the values you want)
            getPatient.setName("Elango Updated");
            getPatient.setAge(28);
            getPatient.setStatus("excellent");

            // Step 4: Hibernate automatically detects changes (dirty checking)
            // No need to call merge() or update() - just commit the transaction
            // The entity is "managed" by the session, so changes are tracked automatically

            // Step 5: Commit the transaction (this executes the UPDATE SQL)
            transaction.commit();

            System.out.println("\n=== AFTER UPDATE ===");
            System.out.println("ID: " + getPatient.getId());
            System.out.println("Name: " + getPatient.getName());
            System.out.println("Age: " + getPatient.getAge());
            System.out.println("Status: " + getPatient.getStatus());
            System.out.println("\n✅ Patient updated successfully!");

            // ========== DELETE PATIENT ROW ==========

            // Step 1: Start a NEW transaction for delete operation
            Transaction deleteTransaction = session.beginTransaction();

            // Step 2: Delete the patient (remove from database)
            session.remove(getPatient);

            // Step 3: Commit the delete transaction (this executes DELETE SQL)
            deleteTransaction.commit();

            System.out.println("\n✅ Patient deleted successfully!");

        } else {
            System.out.println("❌ Patient with ID 3 not found!");
        }

        */

        // Step 6: Close resources
        session.close();
        sf.close();


        // ============================ One to Many / May to One ENDS ===========================






        // ============================ Many to Many ===========================


        /*
         * Let's take medication for this
         * A patient can be linked to multiple medication.
         * A medication can be linked to multiple patient.
         * On both sides it's linked to many, so it's a many to many
         */





    }
}
