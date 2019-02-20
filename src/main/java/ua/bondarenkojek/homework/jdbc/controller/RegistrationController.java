package ua.bondarenkojek.homework.jdbc.controller;

import ua.bondarenkojek.homework.jdbc.Encoder;
import ua.bondarenkojek.homework.jdbc.model.User;
import ua.bondarenkojek.homework.jdbc.service.UserService;
import ua.bondarenkojek.homework.jdbc.web.Request;
import ua.bondarenkojek.homework.jdbc.web.ViewModel;

public class RegistrationController implements Controller {
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        String login = request.getParamByName("login");
        String password = request.getParamByName("password");
        String email = request.getParamByName("email");
        User user = User.builder()
                .login(login)
                .password(Encoder.encode(password))
                .email(email)
                .token(Encoder.encode(login + password))
                .build();
        System.out.println(user);
        userService.add(user);
        return ViewModel.of("login");
    }
}
