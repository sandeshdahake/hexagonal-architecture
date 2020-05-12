package com.hexagonal.example.bookmarks.application.lyrics;

import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;

import java.util.List;

public interface RetrieveAllLyricsUseCase {

    List<Lyrics> getAllLyrics();

}
