package com.hexagonal.example.bookmarks.domain.lyrics.exception;

import java.text.MessageFormat;

public class LyricsNotFoundException extends RuntimeException {

    public LyricsNotFoundException(Long id) {
        super(MessageFormat.format("Lyrics with \"{0}\" not found!" ,id));
    }
}
