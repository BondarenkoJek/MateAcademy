package ua.bondarenkojek.lessons.jdbs.jdbc_demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String login;
    private String password;
    private String sex;
}
