package ua.bondarenkojek.homework.jdbc.service.impl;

import ua.bondarenkojek.homework.jdbc.Encoder;
import ua.bondarenkojek.homework.jdbc.model.User;
import ua.bondarenkojek.homework.jdbc.service.SecurityService;
import ua.bondarenkojek.homework.jdbc.service.UserService;
import ua.bondarenkojek.homework.jdbc.web.Request;

public class SecurityServiceImpl implements SecurityService {
    private final UserService userService;

    public SecurityServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User doLogin(Request request) {
        String login = request.getParamByName("login");
        String password = Encoder.encode(request.getParamByName("password"));
        User user = userService.getByLogin(login);

        if(user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}
