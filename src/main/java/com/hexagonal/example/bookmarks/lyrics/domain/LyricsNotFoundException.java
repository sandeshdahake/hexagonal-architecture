package com.hexagonal.example.bookmarks.lyrics.domain;

import java.text.MessageFormat;

public class LyricsNotFoundException extends RuntimeException {

    public LyricsNotFoundException(Long id) {
        super(MessageFormat.format("Lyrics with \"{0}\" not found!" ,id));
    }
}
