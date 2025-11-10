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

        Address elangoAddress = new Address("test", "test", 612001, 789456123, "Elango");
        Address rajAddress = new Address("test", "test", 612001, 789132123, "Raj");


        Appointment elangoApointment = new Appointment("Check In", 120, LocalDateTime.now());
        Appointment elangoApointment2 = new Appointment("Checked Out", 0, LocalDateTime.now());

        Appointment rajApointment = new Appointment("Check In", 120, LocalDateTime.now());

        Patient elango = new Patient("elango", 27, "fine", elangoAddress);
        Patient raj = new Patient("raj", 27, "not good", rajAddress);

        elango.setAppointments(Arrays.asList(elangoApointment, elangoApointment2));
        raj.setAppointments(Arrays.asList(rajApointment));

        elangoApointment.setPatient(elango);
        elangoApointment2.setPatient(elango);
        rajApointment.setPatient(raj);

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Patient.class)
                     .addAnnotatedClass(Appointment.class);

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

        session.persist(elango);
        session.persist(raj);
        session.persist(elangoApointment);
        session.persist(elangoApointment2);
        session.persist(rajApointment);

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
