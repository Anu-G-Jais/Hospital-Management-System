package HospitalManagmentSystem;

import java.sql.*;
import java.util.Scanner;

public class Patient {
    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    
    public void addPatient()
    {
        scanner.nextLine();
        System.out.println("ENTER PATIENT NAME: ");
        String name = scanner.nextLine();
        System.out.println("ENTER PATIENT AGE: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("ENTER PATIENT GENDER: ");
        String gender = scanner.nextLine();
        
        try {
            String query = "INSERT INTO patients(name, age, gender) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);
            
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows>0){
                System.out.println("PATIENT ADDED SUCCESSFULLY..!!!"); 
            }
            else{
                System.out.println("FAILED TO ADD DOCTOR..!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    public void viewPatients(){
        String query = "select * from patients";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Patients: ");
            System.out.println("+------------+--------------------+----------+------------+");
            System.out.println("| Patient Id | Name               | Age      | Gender     |");
            System.out.println("+------------+--------------------+----------+------------+");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                System.out.printf("| %-10s | %-18s | %-8s | %-10s |\n", id, name, age, gender);
                System.out.println("+------------+--------------------+----------+------------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean getPatientById(int id){
        String query = "SELECT * FROM patients WHERE id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
