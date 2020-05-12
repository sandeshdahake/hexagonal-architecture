package com.hexagonal.example.bookmarks.lyrics.application;

import com.hexagonal.example.bookmarks.lyrics.domain.Lyrics;
import com.hexagonal.example.bookmarks.lyrics.domain.LyricsPersistencePort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LyricsServiceImpl implements LyricsServicePort {

    private final LyricsPersistencePort lyricsPersistencePort;

    public LyricsServiceImpl(LyricsPersistencePort lyricsPersistencePort) {
        this.lyricsPersistencePort = lyricsPersistencePort;
    }

    @Override
    public void addLyrics(Lyrics lyrics) {
        lyricsPersistencePort.addLyrics(lyrics);
    }

    @Override
    @Transactional
    public void removeLyrics(Lyrics lyrics) {
        lyricsPersistencePort.removeLyrics(lyrics);
    }

    @Override
    public void updateLyrics(Lyrics lyrics) {
        lyricsPersistencePort.updateLyrics(lyrics);
    }

    @Override
    public List<Lyrics> getAllLyrics() {
        return lyricsPersistencePort.getAllLyrics();
    }

    @Override
    public Lyrics getLyricsById(Long lyricsId) {
        return lyricsPersistencePort.getLyricsById(lyricsId);
    }


}
