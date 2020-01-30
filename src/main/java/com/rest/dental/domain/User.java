package com.rest.dental.domain;

import com.rest.dental.util.Role;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private Address address;

    @Column(name = "roles")
    private Role role;

    public User() {
    }

    public User(String name,
                String lastName,
                LocalDate birthday,
                String email,
                String phone,
                Address address,
                Role role) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }
}
