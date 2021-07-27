package ru.job4j.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Video;
import ru.job4j.cinema.repository.inMemory.VideoRepository;

import java.util.Collection;

@Service
public class VideoService {

    private final VideoRepository repository;

    @Autowired
    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public Video save(Video video) {
        return repository.save(video);
    }

    public Collection<Video> findAll() {
        return repository.findAll();
    }

    public Video findById(long id) {
        return repository.findById(id);
    }
}
