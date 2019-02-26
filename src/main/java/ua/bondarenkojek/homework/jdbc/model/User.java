package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class User {
    private Long id;
    private String login;
    private String password;
    private String email;
    private String token;
    private Set<Role> roles;

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }
}
