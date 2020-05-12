package com.hexagonal.example.bookmarks.application.lyrics;

import com.hexagonal.example.bookmarks.domain.lyrics.LyricsPersistencePort;
import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class RetrieveAllLyricsUseCaseImpl implements RetrieveAllLyricsUseCase {

    private final LyricsPersistencePort lyricsPersistencePort;

    public RetrieveAllLyricsUseCaseImpl(LyricsPersistencePort lyricsPersistencePort) {
        this.lyricsPersistencePort = lyricsPersistencePort;
    }

    @Override
    public List<Lyrics> getAllLyrics() {
        return lyricsPersistencePort.getAllLyrics();
    }

}
