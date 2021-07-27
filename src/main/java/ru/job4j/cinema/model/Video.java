package ru.job4j.cinema.model;

import java.util.Date;
import java.util.Objects;

public class Video {

    private long id;
    private String name;
    private String producer;
    private Date created;

    public Video(String name, String producer, Date created) {
        this.name = name;
        this.producer = producer;
        this.created = created;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Video video = (Video) o;
        return id == video.id
                && Objects.equals(name, video.name)
                && Objects.equals(producer, video.producer)
                && Objects.equals(created, video.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, producer, created);
    }

    @Override
    public String toString() {
        return "Video { "
                + "id = " + id
                + ", name = '" + name + '\''
                + ", producer = '" + producer + '\''
                + ", created = " + created
                + '}';
    }
}
