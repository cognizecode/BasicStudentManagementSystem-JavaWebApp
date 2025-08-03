package org.learning.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.learning.demo.dao.StudentDAO;
import org.learning.demo.model.Student;

import java.io.IOException;

public class UpdateStudentServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.updateStudent(student);

        resp.sendRedirect("list-students");
    }
}
