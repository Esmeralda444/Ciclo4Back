package com.sergioarboleda.cacharrero.app.controllers;

import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServices service;

    @GetMapping("/all")
    public List<User> getUsers() {
        return service.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return service.save(user);

    }

    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email) {
        return service.verifyEmail(email);

    }

    @GetMapping("/{email}/{pass}")
    public User existUser(@PathVariable("email") String email, @PathVariable("pass") String pass) {
        return service.byEmailPass(email, pass);

    }
}
