package ru.job4j.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.job4j.cinema.model.User;
import ru.job4j.cinema.service.UserService;

import java.util.Collection;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ResponseBody
    @GetMapping("/")
    public Collection<User> findAll() {
        return service.findAll();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public User getById(@PathVariable long id) {
        return service.findById(id);
    }
}
