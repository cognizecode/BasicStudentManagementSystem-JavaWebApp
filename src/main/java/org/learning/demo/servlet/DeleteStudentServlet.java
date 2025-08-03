package org.learning.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.learning.demo.dao.StudentDAO;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.deleteStudent(id);

        response.sendRedirect("list-students");
    }
}
