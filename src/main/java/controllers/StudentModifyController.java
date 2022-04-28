package controllers;

import database.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentModifyController", urlPatterns = "/student-modify")
public class StudentModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idn = req.getParameter("hiddenStudModify");
        Student stud = DBManager.getStudentById(idn);
        req.setAttribute("stud", stud);
        req.getRequestDispatcher("WEB-INF/jsp/student-modify.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String lastName = req.getParameter("lastName");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");
        if (lastName.equals("") && name.equals("") && date.equals("")) {
            req.setAttribute("messager","errore");
            Student student = DBManager.getStudentById(id);
            req.setAttribute("stud",student);

            req.getRequestDispatcher("WEB-INF/jsp/student-modify.jsp").forward(req, resp);
            return;

        }
        DBManager.modifyStudent(id, lastName, name, date,group);
        resp.sendRedirect("/students");

    }
}