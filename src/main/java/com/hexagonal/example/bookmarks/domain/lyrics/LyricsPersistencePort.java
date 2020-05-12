package com.hexagonal.example.bookmarks.domain.lyrics;

import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;

import java.util.List;

public interface LyricsPersistencePort {

    void addLyrics(Lyrics lyrics);

    void removeLyrics(Lyrics lyrics);

    void updateLyrics(Lyrics lyrics);

    List<Lyrics> getAllLyrics();

    Lyrics getLyricsById(Long lyricsId);
}

