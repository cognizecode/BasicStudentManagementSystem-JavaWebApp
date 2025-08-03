package org.learning.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.learning.demo.dao.StudentDAO;
import org.learning.demo.model.Student;

import java.io.IOException;

@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        res.setHeader("Pragma", "no-cache"); // HTTP 1.0
        res.setHeader("Expires", "0"); // Proxies

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student);

        res.sendRedirect("add_student.jsp");
    }
}
