package com.hexagonal.example.bookmarks.application;

import com.hexagonal.example.bookmarks.application.lyrics.AddLyricsBookmarkUseCase;
import com.hexagonal.example.bookmarks.application.lyrics.AddLyricsBookmarkUseCaseImpl;
import com.hexagonal.example.bookmarks.application.lyrics.ModifyLyricsBookmarkUseCase;
import com.hexagonal.example.bookmarks.application.lyrics.ModifyLyricsBookmarkUseCaseImpl;
import com.hexagonal.example.bookmarks.application.lyrics.RemoveLyricsBookmarkUseCase;
import com.hexagonal.example.bookmarks.application.lyrics.RemoveLyricsBookmarkUseCaseImpl;
import com.hexagonal.example.bookmarks.application.lyrics.RetrieveAllLyricsUseCase;
import com.hexagonal.example.bookmarks.application.lyrics.RetrieveAllLyricsUseCaseImpl;
import com.hexagonal.example.bookmarks.application.lyrics.RetrieveSpecificLyricsUseCase;
import com.hexagonal.example.bookmarks.application.lyrics.RetrieveSpecificLyricsUseCaseImpl;
import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;
import com.hexagonal.example.bookmarks.domain.lyrics.LyricsPersistencePort;
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
    private AddLyricsBookmarkUseCaseImpl addLyricsBookmarkUseCase;

    @InjectMocks
    private RemoveLyricsBookmarkUseCaseImpl removeLyricsBookmarkUseCase;

    @InjectMocks
    private ModifyLyricsBookmarkUseCaseImpl modifyLyricsBookmarkUseCase;

    @InjectMocks
    private RetrieveAllLyricsUseCaseImpl retrieveAllLyricsUseCase;

    @InjectMocks
    private RetrieveSpecificLyricsUseCaseImpl retrieveSpecificLyricsUseCase;

    @Mock
    private LyricsPersistencePort lyricsPersistencePort;

    @Mock
    private List<Lyrics> mockLyricsList;

    @Test
    public void givenLyrics_whenAdd_thenAddPortCalled() {
        final Lyrics mockLyrics = mock(Lyrics.class);

        addLyricsBookmarkUseCase.addLyrics(mockLyrics);

        verify(lyricsPersistencePort, only()).addLyrics(mockLyrics);
    }

    @Test
    public void givenLyrics_whenRemove_thenRemovePortCalled() {
        final Lyrics mockLyrics = mock(Lyrics.class);

        removeLyricsBookmarkUseCase.removeLyrics(mockLyrics);

        verify(lyricsPersistencePort, only()).removeLyrics(mockLyrics);
    }


    @Test
    public void givenLyrics_whenUpdate_thenUpdateLyricsPortCalled() {
        final Lyrics mockLyrics = mock(Lyrics.class);

        modifyLyricsBookmarkUseCase.updateLyrics(mockLyrics);

        verify(lyricsPersistencePort, only()).updateLyrics(mockLyrics);
    }

    @Test
    public void givenCallToAllLyrics_whenNothingSpecified_thenGetAllLyricssPortCalled() {
        when(lyricsPersistencePort.getAllLyrics()).thenReturn(mockLyricsList);

        final List<Lyrics> allLyricss = retrieveAllLyricsUseCase.getAllLyrics();

        assertThat(allLyricss).isSameAs(mockLyricsList);
        verify(lyricsPersistencePort, only()).getAllLyrics();
    }

    @Test
    public void givenLyricsId_whenGetLyricssById_thenGetLyricsByIdPortCalled() {
        final Long testLyricsId = 1L;
        final Lyrics mockLyrics = mock(Lyrics.class);
        when(lyricsPersistencePort.getLyricsById(testLyricsId)).thenReturn(mockLyrics);

        final Lyrics lyrics = retrieveSpecificLyricsUseCase.getLyricsById(testLyricsId);

        assertThat(lyrics).isSameAs(mockLyrics);
        verify(lyricsPersistencePort, only()).getLyricsById(testLyricsId);
    }

}
