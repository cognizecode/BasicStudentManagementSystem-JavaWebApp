package org.learning.demo.dao;

import org.learning.demo.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/student";
    private String jdbcUsername = "db_username";
    private String jdbcPassword = "db_password";

    // made connection with db and return obj of con
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // Add students

    public void addStudent(Student student) {
        String query = "insert into students values (?, ?, ?, ?)";
        try(Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(query)){

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getCourse());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Fetch all students

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "select * from students";
        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                students.add(student);
            }

            System.out.println("Student fetched : " + students.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }

    public void deleteStudent(int id) {
        String query = "delete from students where id = ?";
        try(Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateStudent(Student student) {
        String query = "update students set name=?, email=?, course=? where id=?";

        try(Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setInt(4, student.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Student getStudentById(int id) {
        String query = "select * from students where id = ?";

        try(Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                return student;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
