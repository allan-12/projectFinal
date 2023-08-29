package com.example.progexamnfinal.repository;

import com.example.progexamnfinal.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private Connection connection;

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO Student (First_name, Last_name, Date_of_birth, Email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setDate(3, Date.valueOf(student.getDateOfBirth()));
            statement.setString(4, student.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Student student) {
            String sql = "UPDATE Student SET First_name = ?, Last_name = ?, Date_of_birth = ?, Email = ? WHERE Student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setDate(3, java.sql.Date.valueOf(student.getDateOfBirth()));
            statement.setString(4, student.getEmail());
            statement.setInt(5, student.getStudentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Student WHERE Student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        String sql = "SELECT * FROM Student WHERE Student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = new Student(
                        resultSet.getInt("Student_id"),
                        resultSet.getString("First_name"),
                        resultSet.getString("Last_name"),
                        resultSet.getDate("Date_of_birth").toLocalDate(),
                        resultSet.getString("Email")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("Student_id"),
                        resultSet.getString("First_name"),
                        resultSet.getString("Last_name"),
                        resultSet.getDate("Date_of_birth").toLocalDate(),
                        resultSet.getString("Email")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}