package ua.bondarenkojek.homework.jdbc.controller;

import ua.bondarenkojek.homework.jdbc.model.User;
import ua.bondarenkojek.homework.jdbc.service.SecurityService;
import ua.bondarenkojek.homework.jdbc.web.Request;
import ua.bondarenkojek.homework.jdbc.web.ViewModel;

import javax.servlet.http.Cookie;

public class LoginController implements Controller {

    private SecurityService securityService;

    public LoginController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public ViewModel process(Request request) {
        User user = securityService.doLogin(request);
        if (user == null)
            return ViewModel.of("login");
        String userToken = user.getToken();
        Cookie cookie = new Cookie("MATE", userToken);
        ViewModel vm = ViewModel.of("index");
        vm.addCookie(cookie);
        return vm;
    }
}
