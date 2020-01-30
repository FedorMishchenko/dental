package com.rest.dental.controller;

import com.rest.dental.domain.Address;
import com.rest.dental.domain.User;
import com.rest.dental.service.impl.UserServiceImpl;
import com.rest.dental.util.Role;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    User save(@RequestParam
                      String name,
                      String lastName,
                      String email,
                      LocalDate birthday,
                      Address address,
                      String phone,
                      Role role) {
        User newUser = new User(
                name,
                lastName,
                birthday,
                email,
                phone,
                address,
                role);
        return userService.save(newUser);
    }

    @GetMapping()
    List<User> all() {
        return userService.getAll();
    }


    @GetMapping(value = "/find/{id:[\\d]+}")
    User find(@PathVariable Integer id) {
        return userService.get(id).get();
    }

    @DeleteMapping("/delete/{id:[\\d]+}")
    void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
