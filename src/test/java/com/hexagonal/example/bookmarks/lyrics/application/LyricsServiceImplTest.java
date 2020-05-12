package com.hexagonal.example.bookmarks.lyrics.application;

import com.hexagonal.example.bookmarks.lyrics.domain.Lyrics;
import com.hexagonal.example.bookmarks.lyrics.domain.LyricsPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LyricsServiceImplTest {

    @InjectMocks
    private LyricsServiceImpl lyricsServicePort;

    @Mock
    private LyricsPersistencePort lyricsPersistencePort;

    @Mock
    private List<Lyrics> mockLyricsList;

    @Test
    public void givenLyrics_whenAdd_thenAddPortCalled() {
        final Lyrics mockLyrics = mock(Lyrics.class);

        lyricsServicePort.addLyrics(mockLyrics);

        verify(lyricsPersistencePort, only()).addLyrics(mockLyrics);
    }

    @Test
    public void givenLyrics_whenRemove_thenRemovePortCalled() {
        final Lyrics mockLyrics = mock(Lyrics.class);

        lyricsServicePort.removeLyrics(mockLyrics);

        verify(lyricsPersistencePort, only()).removeLyrics(mockLyrics);
    }


    @Test
    public void givenLyrics_whenUpdate_thenUpdateLyricsPortCalled() {
        final Lyrics mockLyrics = mock(Lyrics.class);

        lyricsServicePort.updateLyrics(mockLyrics);

        verify(lyricsPersistencePort, only()).updateLyrics(mockLyrics);
    }

    @Test
    public void givenCallToAllLyrics_whenNothingSpecified_thenGetAllLyricssPortCalled() {
        when(lyricsPersistencePort.getAllLyrics()).thenReturn(mockLyricsList);

        final List<Lyrics> allLyricss = lyricsServicePort.getAllLyrics();

        assertThat(allLyricss).isSameAs(mockLyricsList);
        verify(lyricsPersistencePort, only()).getAllLyrics();
    }

    @Test
    public void givenLyricsId_whenGetLyricssById_thenGetLyricsByIdPortCalled() {
        final Long testLyricsId = 1L;
        final Lyrics mockLyrics = mock(Lyrics.class);
        when(lyricsPersistencePort.getLyricsById(testLyricsId)).thenReturn(mockLyrics);

        final Lyrics lyrics = lyricsServicePort.getLyricsById(testLyricsId);

        assertThat(lyrics).isSameAs(mockLyrics);
        verify(lyricsPersistencePort, only()).getLyricsById(testLyricsId);
    }

}
