package org.learning.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.learning.demo.dao.StudentDAO;
import org.learning.demo.model.Student;

import java.io.IOException;

@WebServlet("/edit")
public class EditStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentById(id);

        request.setAttribute("student", student);
        request.getRequestDispatcher("edit_student.jsp").forward(request, response);
    }
}
