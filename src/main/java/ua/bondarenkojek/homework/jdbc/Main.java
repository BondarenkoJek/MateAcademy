package ua.bondarenkojek.homework.jdbc;

import ua.bondarenkojek.homework.jdbc.dao.DeveloperDaoImpl;
import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.service.DeveloperService;
import ua.bondarenkojek.homework.jdbc.service.DeveloperServiceImpl;
import ua.bondarenkojek.homework.jdbc.util.ConnectionUtil;

public class Main {
    public static void main(String[] args) {
        DeveloperService service = new DeveloperServiceImpl(
                new DeveloperDaoImpl(ConnectionUtil.getConnection()));

//        System.out.println(service.getDeveloperById(1));
        Developer developer = Developer.builder()
                .name("Tolya")
                .age(23)
                .salary(600.0)
                .build();
        service.addDeveloper(developer);

    }
}
