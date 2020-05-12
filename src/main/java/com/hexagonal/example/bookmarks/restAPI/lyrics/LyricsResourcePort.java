package com.hexagonal.example.bookmarks.restAPI.lyrics;

import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface LyricsResourcePort {

        @PostMapping("/lyrics")
        ResponseEntity<Void> addLyrics(@RequestBody Lyrics lyricsDto);

        @DeleteMapping("/lyrics")
        ResponseEntity<String> removeLyrics(@RequestBody Lyrics lyricsDto);

        @PutMapping("/lyrics")
        ResponseEntity<String> updateLyrics(@RequestBody Lyrics lyricsDto);

        @GetMapping("/lyrics/{lyricsId}")
        ResponseEntity<Lyrics> getLyricsById(@PathVariable Long lyricsId);

        @GetMapping("/lyrics")
        ResponseEntity<List<Lyrics>> getLyrics();

        @GetMapping("/lyrics/random")
        ResponseEntity<Lyrics> getRandomLyric();
}
