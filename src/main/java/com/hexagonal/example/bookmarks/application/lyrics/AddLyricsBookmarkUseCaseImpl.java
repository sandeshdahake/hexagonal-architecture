package com.hexagonal.example.bookmarks.application.lyrics;

import com.hexagonal.example.bookmarks.domain.lyrics.LyricsPersistencePort;
import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AddLyricsBookmarkUseCaseImpl implements AddLyricsBookmarkUseCase {

    private final LyricsPersistencePort lyricsPersistencePort;

    public AddLyricsBookmarkUseCaseImpl(LyricsPersistencePort lyricsPersistencePort) {
        this.lyricsPersistencePort = lyricsPersistencePort;
    }

    @Override
    public void addLyrics(Lyrics lyrics) {
        lyricsPersistencePort.addLyrics(lyrics);
    }
}
