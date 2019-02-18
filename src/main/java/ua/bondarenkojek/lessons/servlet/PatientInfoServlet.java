package ua.bondarenkojek.lessons.servlet;

import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.service.PatientService;
import ua.bondarenkojek.homework.jpa.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PatientService ps = ServiceFactory.getPatientService();

        Patient patient = ps.getPatient(Long.parseLong(req.getParameter("id")));

        req.setAttribute("patient", patient);
        req.getRequestDispatcher("/view/patient.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

//    private void getPatient()
}
