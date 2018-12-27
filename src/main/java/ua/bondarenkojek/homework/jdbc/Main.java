package ua.bondarenkojek.homework.jdbc;

import ua.bondarenkojek.homework.jdbc.dao.DeveloperDaoImpl;
import ua.bondarenkojek.homework.jdbc.service.DeveloperService;
import ua.bondarenkojek.homework.jdbc.service.DeveloperServiceImpl;
import ua.bondarenkojek.homework.jdbc.util.ConnectionUtil;

public class Main {
    public static void main(String[] args) {
        DeveloperService service = new DeveloperServiceImpl(
                new DeveloperDaoImpl(ConnectionUtil.getConnection()));

        System.out.println(service.getDeveloperById(1));

    }
}
