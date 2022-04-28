package controllers;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "StudentCreateController", urlPatterns = "/student-create")
public class StudentCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/student-create.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String studName = req.getParameter("newStudName");
        String studFirstName = req.getParameter("newStudFirstName");
        String DateOfEnrollment = req.getParameter("newDateOfEnrollment");
        String studGroup  = req.getParameter("newStudGroup");



        if (studFirstName.equals("") && studName.equals("") && DateOfEnrollment == null ||DateOfEnrollment.equals("")) {
            req.setAttribute("message","error");
            req.getRequestDispatcher("WEB-INF/jsp/student-create.jsp").forward(req,resp);
            return;
        }
        DBManager.createNewStudents(studName,studFirstName,DateOfEnrollment,studGroup);

        resp.sendRedirect("/students");
    }
}