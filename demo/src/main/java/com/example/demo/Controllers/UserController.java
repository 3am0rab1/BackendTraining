package com.example.demo.Controllers;

import com.example.demo.Entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userServices;


    @GetMapping("/users")
    List<User> getUsers() {
        return userServices.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return userServices.save(newUser);
    }


    @GetMapping("/users/{username}")
    User getUser(@PathVariable String username) {

        return userServices.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    @PutMapping("/users/{username}")
    User replaceUser(@RequestBody User newUser, @PathVariable String username) {

        return userServices.findByUsername(username)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return userServices.save(user);
                })
                .orElseGet(() -> {
                    newUser.setUsername(username);
                    return userServices.save(newUser);
                });
    }

    @DeleteMapping("/users/{username}")
    void deleteUser(@PathVariable String username) {
        userServices.deleteByUsername(username);
    }





}
