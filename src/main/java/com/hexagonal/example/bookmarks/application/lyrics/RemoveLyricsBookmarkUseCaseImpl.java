package com.hexagonal.example.bookmarks.application.lyrics;

import com.hexagonal.example.bookmarks.domain.lyrics.LyricsPersistencePort;
import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class RemoveLyricsBookmarkUseCaseImpl implements RemoveLyricsBookmarkUseCase{

    private final LyricsPersistencePort lyricsPersistencePort;

    public RemoveLyricsBookmarkUseCaseImpl(LyricsPersistencePort lyricsPersistencePort) {
        this.lyricsPersistencePort = lyricsPersistencePort;
    }

    @Override
    @Transactional
    public void removeLyrics(Lyrics lyrics) {
        lyricsPersistencePort.removeLyrics(lyrics);
    }

}
