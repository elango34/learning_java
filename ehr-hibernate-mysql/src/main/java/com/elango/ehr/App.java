package com.elango.ehr;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {

        // First create a patient, A patient can exist without any appointment or anything.
        // But for the remaining object this is required.
        Address johnAddress = new Address("test", "test", 612001, 789456123, "John");
        Address ramAddress = new Address("test", "test", 612001, 789132123, "Raj");
        Address jimAddress = new Address("132 scranton", "", 123123, 412314123, "JimPamHouse");
        Address pamAddress = new Address("132 scranton", "", 123123, 523413212, "JimPamHouse");

        // create patient object
        Patient john = new Patient("john", 27, "fine", johnAddress);
        Patient ram = new Patient("ram", 27, "not good", ramAddress);
        Patient jim = new Patient("jim", 27, "check in", jimAddress);
        Patient pam = new Patient("pam", 27, "check in", pamAddress);


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
        MedicalRecord jimMedicalRecord = new MedicalRecord("B+", "grapes", "rashes", "none", "none", "4123123123");
        MedicalRecord pamMedicalRecord = new MedicalRecord("O-", "cigerrate", "asthma", "none", "none", "14123123412");

        // attach a patient to that
        johnMedicalRecord.setPatient(john);
        ramMedicalRecord.setPatient(ram);
        jimMedicalRecord.setPatient(jim);
        pamMedicalRecord.setPatient(pam);


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

        // ============================ One to Many / May to One ENDS ===========================

        // ============================ Many to Many (Unidirectional) ===========================

        /*
         * Let's take medication for this
         * A patient can be linked to multiple medication.
         * A medication may be linked to multiple patient based on the business requirement.
         * But now we are consider only one way patient is linked with medications (Unidirectional)
         * So with hibernate we can get medications linked with patient
         * It will create a separate join table, through this we can get the particular medication linked with many patient through manual HQL query. 
         * On patient sides it's linked to many, so it's a many to many (Unidirectional)
         */

         Medication cetrizine = new Medication("cetrizine", "5mg", "pure", "stomach");
         Medication dsr = new Medication("dsr", "100mg", "pure", "stomach");
         Medication digine = new Medication("digine", "5mg", "pure", "stomach");
         Medication methotrexate = new Medication("methotrexate", "5mg", "pure", "stomach");
         Medication folb = new Medication("folate b12", "1mg", "pure", "stomach");
 
        john.setMedications(Arrays.asList(cetrizine, folb));
        ram.setMedications(Arrays.asList(dsr, digine));
        jim.setMedications(Arrays.asList(methotrexate, folb));
        pam.setMedications(Arrays.asList(cetrizine));
        

        // ============================ Many to Many (Bidirectional) ===========================

        /*
         * Let's take medication for this
         * A patient can be linked to multiple provider and a provider can be linked to multiple patient.
         * we want both relations based on the business requirement.
         * It will create a separate join table which links both patient and provider
         * On both sides it's linked to many, so it's a many to many (Bidirectional)
         */

        Provider michael = new Provider("21314hbhh", "Michael", "scott", "Dental", 1231231223);
        Provider schrute = new Provider("42324sd213", "Schrute", "", "Nose", 23423423);

        michael.setPatients(Arrays.asList(pam, john, jim));
        schrute.setPatients(Arrays.asList(pam, jim, ram));

        pam.setProviders(Arrays.asList(michael, schrute));
        jim.setProviders(Arrays.asList(michael, schrute));
        john.setProviders(Arrays.asList(michael));
        ram.setProviders(Arrays.asList(schrute));
        
        
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Patient.class)
                     .addAnnotatedClass(Appointment.class)
                     .addAnnotatedClass(MedicalRecord.class)
                     .addAnnotatedClass(Medication.class)
                     .addAnnotatedClass(Provider.class);

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
        session.persist(jim);
        session.persist(pam);
        session.persist(johnApointment);
        session.persist(johnApointment2);
        session.persist(ramApointment);
        session.persist(johnMedicalRecord);
        session.persist(ramMedicalRecord);
        session.persist(jimMedicalRecord);
        session.persist(pamMedicalRecord);
        session.persist(cetrizine);
        session.persist(dsr);
        session.persist(digine);
        session.persist(methotrexate);
        session.persist(folb);
        session.persist(schrute);
        session.persist(michael);


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





    }
}
