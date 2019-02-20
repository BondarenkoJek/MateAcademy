package ua.bondarenkojek.homework.jdbc.web;

import ua.bondarenkojek.homework.jdbc.config.Factory;
import ua.bondarenkojek.homework.jdbc.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ua.bondarenkojek.homework.jdbc.web.Request.RequestMethod.GET;
import static ua.bondarenkojek.homework.jdbc.web.Request.RequestMethod.POST;

public class MainServlet extends HttpServlet {
    private final static Map<Request, Controller> CONTROLLERS = new HashMap<>();

    static {
        CONTROLLERS.put(Request.of("/error", GET), r -> ViewModel.of("error"));
        CONTROLLERS.put(Request.of("/", GET), r -> ViewModel.of("index"));
        CONTROLLERS.put(Request.of("/login", GET), r -> ViewModel.of("login"));
        CONTROLLERS.put(Request.of("/registration", GET), r -> ViewModel.of("registration"));
        CONTROLLERS.put(Request.of("/login", POST), Factory.getLoginController());
        CONTROLLERS.put(Request.of("/registration", POST), Factory.getRegistrationController());
        CONTROLLERS.put(Request.of("/administrator", GET), r -> ViewModel.of("administrator"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getServletPath();
        //TODO: tmp Test
        System.out.println(path);
        Map<String, String[]> parameterMap = req.getParameterMap();
        Request request = Request.of(path, Request.ofRequestMethod(req.getMethod()), parameterMap);

        if (!CONTROLLERS.containsKey(request)) {
            request.setUri("/error");
            Controller controller = CONTROLLERS.get(request);
            ViewModel vm = controller.process(request);
            vm.addAttribute("error", "HTTP Status 404");
            sendResponse(req, resp, vm);
        }

        Controller controller = CONTROLLERS.get(request);
        ViewModel vm = controller.process(request);
        //TODO: should test
        if (!vm.getCookies().isEmpty()) {
            resp.addCookie(vm.getCookies().get(0));
        }
        sendResponse(req, resp, vm);
    }

    private void sendResponse(HttpServletRequest request,
                              HttpServletResponse response,
                              ViewModel viewModel) throws ServletException, IOException {
        String redirectUrl = "/WEB-INF/view/%s.jsp";
        viewModel.getModel().forEach(request::setAttribute);
        request.getRequestDispatcher(String.format(redirectUrl, viewModel.getView())).forward(request, response);
    }
}
