package com.rest.dental.controller;

import com.rest.dental.domain.User;
import com.rest.dental.exception.UserNotFoundException;
import com.rest.dental.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
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
                      String birthday,
                      String address,
                      String phone,
                      Integer role) {
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

    @GetMapping("/all")
    List<User> all() {
        return userService.getAll();
    }


    @GetMapping(value = "/find/{id:[\\d]+}")
    User find(@PathVariable Integer id) {
        return userService.get(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/delete/{id:[\\d]+}")
    void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
