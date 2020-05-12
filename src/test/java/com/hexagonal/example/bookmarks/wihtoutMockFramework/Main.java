package com.hexagonal.example.bookmarks.wihtoutMockFramework;

import com.hexagonal.example.bookmarks.lyrics.application.LyricsServiceImpl;
import com.hexagonal.example.bookmarks.lyrics.application.LyricsServicePort;
import com.hexagonal.example.bookmarks.lyrics.domain.Lyrics;
import com.hexagonal.example.bookmarks.lyrics.domain.LyricsPersistencePort;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final LyricsServicePort lyricsService = new LyricsServiceImpl(createMockLyricsPersistencePort());
        final Lyrics lyrics = Lyrics.builder()
                .participatingArtist("Aretha Franklin")
                .lyrics("find out what it means to me")
                .build();
        lyricsService.addLyrics(lyrics);
        lyricsService.updateLyrics(lyrics);
        lyricsService.removeLyrics(lyrics);
        final List<Lyrics> allLyricss = lyricsService.getAllLyrics();
        final Lyrics LyricsById = lyricsService.getLyricsById(1L);
        assert allLyricss.size() == 1;
        final Lyrics Lyrics1 = allLyricss.get(0);
        assert Lyrics1
                .getParticipatingArtist()
                .equals("Gloria Gaynor");
        assert Lyrics1
                .getLyrics()
                .equals("First I was afraid, I was petrified");
        assert LyricsById.getParticipatingArtist()
                .equals("Alesha Dixon");
        assert LyricsById.getLyrics()
                .equals("Does he wash up? Never wash up");
    }

    private static LyricsPersistencePort createMockLyricsPersistencePort() {
        return new LyricsPersistencePort() {
            @Override
            public void addLyrics(Lyrics Lyrics) {

            }

            @Override
            public void removeLyrics(Lyrics Lyrics) {

            }

            @Override
            public void updateLyrics(Lyrics Lyrics) {

            }

            @Override
            public List<Lyrics> getAllLyrics() {
                final Lyrics lyrics = Lyrics.builder()
                        .participatingArtist("Gloria Gaynor")
                        .lyrics("First I was afraid, I was petrified")
                        .build();
                return Collections.singletonList(lyrics);
            }

            @Override
            public Lyrics getLyricsById(Long lyricsId) {
                return Lyrics.builder()
                        .participatingArtist("Alesha Dixon")
                        .lyrics("Does he wash up? Never wash up")
                        .build();
            }
        };
    }
}
