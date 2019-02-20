package ua.bondarenkojek.homework.jdbc.model;

import lombok.Data;

@Data
public class Role {
    private Long id;
    private String role;

    public Role(String role) {
        this.role = role;
    }
}
