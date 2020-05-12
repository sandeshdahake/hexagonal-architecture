package com.hexagonal.example.bookmarks.application.lyrics;

import com.hexagonal.example.bookmarks.domain.lyrics.LyricsPersistencePort;
import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetrieveSpecificLyricsUseCaseImpl implements RetrieveSpecificLyricsUseCase{

    private final LyricsPersistencePort lyricsPersistencePort;

    public RetrieveSpecificLyricsUseCaseImpl(LyricsPersistencePort lyricsPersistencePort) {
        this.lyricsPersistencePort = lyricsPersistencePort;
    }

    public Lyrics getLyricsById(Long lyricsId) {
        return lyricsPersistencePort.getLyricsById(lyricsId);
    }


}
