package com.hexagonal.example.bookmarks.lyrics.domain;

import java.util.List;

public interface LyricsPersistencePort {

    void addLyrics(Lyrics lyrics);

    void removeLyrics(Lyrics lyrics);

    void updateLyrics(Lyrics lyrics);

    List<Lyrics> getAllLyrics();

    Lyrics getLyricsById(Long lyricsId);
}

