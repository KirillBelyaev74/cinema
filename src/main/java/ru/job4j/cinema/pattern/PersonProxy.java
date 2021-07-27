package ru.job4j.cinema.pattern;

import java.util.Objects;

public class PersonProxy {

    private Person person;
    private String name;
    private String surname;

    public PersonProxy(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        if (person == null) {
            person = new Person(name, surname);
        }
        return person.getName();
    }

    public String getSurname() {
        if (person == null) {
            person = new Person(name, surname);
        }
        return person.getSurname();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonProxy that = (PersonProxy) o;
        return Objects.equals(name, that.name)
                && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "PersonProxy { "
                + ", name = '" + name + '\''
                + ", surname = '" + surname + '\''
                + '}';
    }
}
