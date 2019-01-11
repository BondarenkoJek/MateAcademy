package ua.bondarenkojek.lessons.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PatientService ps = new PatientServiceImpl(
//                new PatientDaoImpl(HibernateUtil.getEntityManager()));
//        Patient patient = ps.readPatient(1L);
//
//        req.setAttribute("patient", patient);
        req.getRequestDispatcher("/view/patient.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
