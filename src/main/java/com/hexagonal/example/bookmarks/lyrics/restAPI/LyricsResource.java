package com.hexagonal.example.bookmarks.lyrics.restAPI;

import com.hexagonal.example.bookmarks.lyrics.application.LyricsServicePort;
import com.hexagonal.example.bookmarks.lyrics.domain.Lyrics;
import com.hexagonal.example.bookmarks.lyrics.domain.LyricsNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class LyricsResource {

    private final LyricsServicePort lyricsService;

    private final Random random = new Random();

    public LyricsResource(LyricsServicePort lyricsService) {
        this.lyricsService = lyricsService;
    }

    @PostMapping("/lyrics")
    public ResponseEntity<Void> addLyrics(Lyrics lyrics) {
        lyricsService.addLyrics(lyrics);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/lyrics")
    public ResponseEntity<String> removeLyrics(Lyrics lyrics) {
        lyricsService.removeLyrics(lyrics);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/lyrics")
    public ResponseEntity<String> updateLyrics(Lyrics lyrics) {
        lyricsService.updateLyrics(lyrics);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/lyrics/{lyricsId}")
    public ResponseEntity<Lyrics> getLyricsById(Long lyricsId) {
        try {
            return new ResponseEntity<>(lyricsService.getLyricsById(lyricsId), HttpStatus.OK);
        } catch (LyricsNotFoundException ex) {
            log.error("Error!", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/lyrics")
    public ResponseEntity<List<Lyrics>> getLyrics() {
        return new ResponseEntity<>(lyricsService.getAllLyrics(), HttpStatus.OK);
    }

    @GetMapping("/lyrics/random")
    public ResponseEntity<Lyrics> getRandomLyric() {
        final List<Lyrics> allLyrics = lyricsService.getAllLyrics();
        final int size = allLyrics.size();
        return new ResponseEntity<>(allLyrics.get(random.nextInt(size)), HttpStatus.OK);
    }

}
