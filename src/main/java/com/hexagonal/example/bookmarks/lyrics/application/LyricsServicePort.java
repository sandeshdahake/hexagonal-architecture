package com.hexagonal.example.bookmarks.lyrics.application;

import com.hexagonal.example.bookmarks.lyrics.domain.Lyrics;

import java.util.List;

public interface LyricsServicePort {
    void addLyrics(Lyrics lyrics);

    void removeLyrics(Lyrics lyrics);

    void updateLyrics(Lyrics lyrics);

    List<Lyrics> getAllLyrics();

    Lyrics getLyricsById(Long lyricsId);
}
