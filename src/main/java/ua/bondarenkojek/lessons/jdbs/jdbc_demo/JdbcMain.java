package ua.bondarenkojek.lessons.jdbs.jdbc_demo;

import ua.bondarenkojek.lessons.jdbs.jdbc_demo.dao.UserDaoImpl;
import ua.bondarenkojek.lessons.jdbs.jdbc_demo.service.UserService;
import ua.bondarenkojek.lessons.jdbs.jdbc_demo.service.UserServiceImpl;

public class JdbcMain {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl(
                new UserDaoImpl(ConnectionUtil.getConnection()));

//        System.out.println(userService.findByLogin("loginJek"));

        userService.getAllNamesUpperCase().forEach(System.out::println);
    }
}
