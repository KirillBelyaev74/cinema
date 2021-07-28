package ru.job4j.cinema.repository.inMemory;

import org.springframework.stereotype.Repository;
import ru.job4j.cinema.model.Role;
import ru.job4j.cinema.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    private final Map<Long, User> users = new ConcurrentHashMap<>();
    private final AtomicLong idIncrement = new AtomicLong(0);

    {
        User user = new User("user", "user", Role.USER);
        user.setId(idIncrement.incrementAndGet());
        User admin = new User("admin", "admin", Role.ADMIN);
        admin.setId(idIncrement.incrementAndGet());
        users.put(user.getId(), user);
        users.put(admin.getId(), admin);
    }

    public User save(User user) {
        Optional<User> result =
                users.values().stream().filter(u -> u.getName().equalsIgnoreCase(user.getName())).findAny();
        if (result.isEmpty()) {
            user.setId(idIncrement.incrementAndGet());
            users.put(user.getId(), user);
        }
        return user;
    }

    public Collection<User> findAll() {
        return users.values();
    }

    public User findById(long id) {
        return users.get(id);
    }

    public User findByName(String name) {
        return users.values().stream().filter(u -> u.getName().equals(name)).findAny().get();
    }
}
