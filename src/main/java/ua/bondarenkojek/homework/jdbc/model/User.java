package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String login;
    private String password;
    private String email;
    private String token;
}
