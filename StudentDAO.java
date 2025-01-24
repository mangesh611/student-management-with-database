package Project1;

import java.sql.*;

public class StudentDAO {
    private Connection connection;

    public StudentDAO() {
        connection = DBConnection.getConnection();
    }

    public void addStudent(String name, int age, String course, String email) {
        String query = "INSERT INTO Students (name, age, course, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, course);
            stmt.setString(4, email);
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteStudentByName(String name) {
        String query = "DELETE FROM Students WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("No student found with the name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getStudentByName(String name) {
        String query = "SELECT * FROM Students WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Email: " + rs.getString("email"));
            } else {
                System.out.println("No student found with the name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
