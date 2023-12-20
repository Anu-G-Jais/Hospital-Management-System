package HospitalManagmentSystem;

import java.sql.*;
import java.util.Scanner;

public class Doctor {
    private Connection connection;
    private Scanner scanner;

    public Doctor(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    public void addDoctor(){
        scanner.nextLine();
        System.out.print("ENTER DOCTOR NAME: ");
        String name = scanner.nextLine();
        System.out.print("ENTER DOCTOR SPECIALIZATION: ");
        String specializaation = scanner.nextLine();
        
        try {
            String query = "INSERT INTO doctors(name, specialization) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, specializaation);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows>0){
                System.out.println("DOCTOR ADDED SUCCESSFULLY..!!");
            }else{
                System.out.println("FAILED TO ADD DOCTOR..!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void viewDoctors(){
        String query = "select * from doctors";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctors: ");
            System.out.println("+------------+--------------------+------------------+");
            System.out.println("| Doctor Id  | Name               | Specialization   |");
            System.out.println("+------------+--------------------+------------------+");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("| %-10s | %-18s | %-16s |\n", id, name, specialization);
                System.out.println("+------------+--------------------+------------------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean getDoctorById(int id){
        String query = "SELECT * FROM doctors WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
