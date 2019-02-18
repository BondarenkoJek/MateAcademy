package ua.bondarenkojek.homework.jdbc.config;

import ua.bondarenkojek.homework.jdbc.controller.LoginController;
import ua.bondarenkojek.homework.jdbc.dao.UserDao;
import ua.bondarenkojek.homework.jdbc.dao.impl.UserDaoImpl;
import ua.bondarenkojek.homework.jdbc.service.SecurityService;
import ua.bondarenkojek.homework.jdbc.service.UserService;
import ua.bondarenkojek.homework.jdbc.service.impl.SecurityServiceImpl;
import ua.bondarenkojek.homework.jdbc.service.impl.UserServiceImpl;
import ua.bondarenkojek.homework.jdbc.util.ConnectionUtil;
import ua.bondarenkojek.homework.jdbc.controller.RegistrationController;

import java.sql.Connection;

public class Factory {
    private final static Connection CONNECTION;

    private Factory(){}

    static {
        CONNECTION = ConnectionUtil.getConnection();
    }

    public static RegistrationController getRegistrationController() {
        return new RegistrationController(getUserService());
    }

    public static LoginController getLoginController() {
        return new LoginController(getSecurityService());
    }

    public static SecurityService getSecurityService() {
        return new SecurityServiceImpl(getUserService());
    }

    public static UserService getUserService() {
        return new UserServiceImpl(getUserDao());
    }

    public static UserDao getUserDao() {
        return new UserDaoImpl(CONNECTION);
    }
}
