package ru.job4j.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.cinema.model.Video;
import ru.job4j.cinema.service.VideoService;

import java.util.Collection;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService service;

    @Autowired
    public VideoController(VideoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public Collection<Video> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Video getById(@PathVariable long id) {
        return service.findById(id);
    }
}
