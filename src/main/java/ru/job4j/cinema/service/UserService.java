package ru.job4j.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.User;
import ru.job4j.cinema.repository.inMemory.UserRepository;

import java.util.Collection;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public Collection<User> findAll() {
        return repository.findAll();
    }

    public User findById(long id) {
        return repository.findById(id);
    }
}
