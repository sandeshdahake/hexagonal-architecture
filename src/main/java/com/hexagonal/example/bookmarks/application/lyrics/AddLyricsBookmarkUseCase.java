package com.hexagonal.example.bookmarks.application.lyrics;

import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;

public interface AddLyricsBookmarkUseCase {

    void addLyrics(Lyrics lyrics);
}
