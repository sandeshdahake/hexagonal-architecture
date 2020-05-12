package com.hexagonal.example.bookmarks.application.lyrics;

import com.hexagonal.example.bookmarks.domain.lyrics.LyricsPersistencePort;
import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ModifyLyricsBookmarkUseCaseImpl implements ModifyLyricsBookmarkUseCase {

    private final LyricsPersistencePort lyricsPersistencePort;

    public ModifyLyricsBookmarkUseCaseImpl(LyricsPersistencePort lyricsPersistencePort) {
        this.lyricsPersistencePort = lyricsPersistencePort;
    }

    @Override
    public void updateLyrics(Lyrics lyrics) {
        lyricsPersistencePort.updateLyrics(lyrics);
    }

}
