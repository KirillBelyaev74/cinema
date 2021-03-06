package ru.job4j.cinema.model;

import java.util.Objects;

public class User {

    private long id;
    private String name;
    private String password;
    private Role roles;

    public User() {
    }

    public User(String name, String password, Role roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id
                && Objects.equals(name, user.name)
                && Objects.equals(password, user.password)
                && roles == user.roles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, roles);
    }

    @Override
    public String toString() {
        return "User { "
                + "id = " + id
                + ", name = '" + name + '\''
                + ", password = '" + password + '\''
                + ", roles = " + roles
                + '}';
    }
}
