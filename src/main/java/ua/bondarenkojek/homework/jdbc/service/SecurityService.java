package ua.bondarenkojek.homework.jdbc.service;

import ua.bondarenkojek.homework.jdbc.model.User;
import ua.bondarenkojek.homework.jdbc.web.Request;

public interface SecurityService {
    User doLogin(Request request);
}
