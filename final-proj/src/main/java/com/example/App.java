package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.Doc;

import org.ietf.jgss.GSSName;
public class App {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root","Password1234");
             Statement stmt = connection.createStatement()) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            ResultSet srs = stmt.executeQuery("SELECT * FROM staff");

            while (srs.next()) {
                if (srs.getString("profession") == null) {
                    Hospital.addNurse(srs.getString("person_name"), srs.getString("phonenumber"), srs.getString("address"), srs.getInt("ID"), srs.getString("email"), srs.getString("password"));
                } else { 
                    Hospital.addDoctor(srs.getString("person_name"), srs.getString("phonenumber"), srs.getString("address"), srs.getInt("ID"), srs.getString("email"), srs.getString("profession"), srs.getString("password"));
                }
            }
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM patients");
                ResultSet srs2 = ps.executeQuery();

                while (srs2.next()) {
                    Patient patient = new Patient(srs2.getString("person_name"), srs2.getString("phonenumber"), srs2.getString("email"), srs2.getString("address"), srs2.getInt("ID"), srs2.getString("patient_description"), srs2.getString("password"));

                    Hospital.registerPatient(patient);

                    PreparedStatement innerPs = connection.prepareStatement("SELECT * FROM prescriptions WHERE patient_ID = ?");
                    innerPs.setInt(1, srs2.getInt("ID"));
                    ResultSet innerSrs = innerPs.executeQuery();

                    while (innerSrs.next()) {
                        patient.addPrescription(new Prescription(innerSrs.getString("info"), innerSrs.getInt("doctor_ID"), innerSrs.getInt("patient_ID"), new java.util.Date(innerSrs.getDate("now_date").getTime()), innerSrs.getInt("ID")));
                    }

                    innerSrs.close();
                    innerPs.close();
                }
                
                ps.close();
                
                // Hospital.getPatients().get(0).print();
            

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL exception occurred: " + e.getMessage());
        }

        //-----------------------------------------------------menue here:



        Hospital.discharge((Doctor)Hospital.getStaffByID(2), (Patient)Hospital.getPatientByID(2));






        //----------------------------------------------------------------

try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root","Password1234");
        Statement stmt = connection.createStatement()) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.executeUpdate("TRUNCATE TABLE patients");
            stmt.executeUpdate("TRUNCATE TABLE staff");
            stmt.executeUpdate("TRUNCATE TABLE prescriptions");

            String insertQuery = "INSERT INTO patients (ID, person_name, phonenumber, email, address, password, patient_description) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);
            PreparedStatement pstmt2 = connection.prepareStatement("insert into prescriptions (ID, info, doctor_ID, patient_ID, now_date) values (?, ?, ?, ?, ?);");
            for (Person person : Hospital.getPatients()) {
                Patient patient = (Patient) person;
                pstmt.setInt(1, patient.getID());
                pstmt.setString(2, patient.getName());
                pstmt.setString(3, patient.getPhoneNumber());
                pstmt.setString(4, patient.getEmail());
                pstmt.setString(5, patient.getAddress());
                pstmt.setString(6, patient.getPassword());
                pstmt.setString(7, patient.getDescription());
                pstmt.executeUpdate();

                
                for (Prescription prescription : patient.getPrescriptions()) {
                    pstmt2.setInt(1, prescription.getID());
                    pstmt2.setString(2, prescription.getInfo());
                    pstmt2.setInt(3, prescription.getDoctoreID());
                    pstmt2.setInt(4, prescription.getPatientID());
                    pstmt2.setDate(5, new java.sql.Date(prescription.getDate().getTime()));
                    pstmt2.executeUpdate();
                }
            }
            pstmt.close();
            pstmt2.close();

            PreparedStatement pstmt3 = connection.prepareStatement("insert into staff (ID, person_name, phonenumber, email, address, password, profession) values (?, ?, ?, ?, ?, ?, ?);");
            for (Person person : Hospital.getStaff()) {
                if(person instanceof Doctor) {
                    Doctor doctor = (Doctor) person;
                    pstmt3.setInt(1, doctor.getID());
                    pstmt3.setString(2, doctor.getName());
                    pstmt3.setString(3, doctor.getPhoneNumber());
                    pstmt3.setString(4, doctor.getEmail());
                    pstmt3.setString(5, doctor.getAddress());
                    pstmt3.setString(6, doctor.getPassword());
                    pstmt3.setString(7, doctor.getProfesion());
                    pstmt3.executeUpdate();
                } else {
                    Nurse nurse = (Nurse) person;
                    pstmt3.setInt(1, nurse.getID());
                    pstmt3.setString(2, nurse.getName());
                    pstmt3.setString(3, nurse.getPhoneNumber());
                    pstmt3.setString(4, nurse.getEmail());
                    pstmt3.setString(5, nurse.getAddress());
                    pstmt3.setString(6, nurse.getPassword());
                    pstmt3.setString(7, null);
                    pstmt3.executeUpdate();


                }
            }
            pstmt3.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }






    }
}
