package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TesrController",urlPatterns = "/terms")
public class TesrController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Term> terms = DBManager.getAllActiveTerms();
        Term selectedTerm = terms.get(0);
        ArrayList<Discipline> disciplines = DBManager.getAllActiveDisciplinesByTerm(selectedTerm.getId());

        req.setAttribute("terms",terms);
        req.setAttribute("selectedTerm", selectedTerm);
        req.setAttribute("disciplines",disciplines);
        req.getRequestDispatcher("WEB-INF/JSP/term.jsp").forward(req, resp);


    }


}