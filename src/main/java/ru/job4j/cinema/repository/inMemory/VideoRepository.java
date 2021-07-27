package ru.job4j.cinema.repository.inMemory;

import org.springframework.stereotype.Repository;
import ru.job4j.cinema.model.Video;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class VideoRepository {

    private final Map<Long, Video> videos = new ConcurrentHashMap<>();
    private final AtomicLong idIncrement = new AtomicLong(0);

    public VideoRepository() {
        Video wrathOfMan = new Video
                ("Гнев человеческий", "Гай Ричи", new GregorianCalendar(2021, Calendar.APRIL, 20).getTime());
        wrathOfMan.setId(idIncrement.incrementAndGet());
        videos.put(wrathOfMan.getId(), wrathOfMan);
    }

    public Video save(Video video) {
        Optional<Video> result =
                videos.values().stream().filter(u -> u.getName().equalsIgnoreCase(video.getName())).findAny();
        if (result.isEmpty()) {
            video.setId(idIncrement.incrementAndGet());
            videos.put(video.getId(), video);
        }
        return video;
    }

    public Collection<Video> findAll() {
        return videos.values();
    }

    public Video findById(long id) {
        return videos.get(id);
    }
}
