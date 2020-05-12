package com.hexagonal.example.bookmarks.restAPI.lyrics;

import com.hexagonal.example.bookmarks.application.lyrics.AddLyricsBookmarkUseCase;
import com.hexagonal.example.bookmarks.application.lyrics.ModifyLyricsBookmarkUseCase;
import com.hexagonal.example.bookmarks.application.lyrics.RemoveLyricsBookmarkUseCase;
import com.hexagonal.example.bookmarks.application.lyrics.RetrieveAllLyricsUseCase;
import com.hexagonal.example.bookmarks.application.lyrics.RetrieveSpecificLyricsUseCase;
import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;
import com.hexagonal.example.bookmarks.domain.lyrics.exception.LyricsNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class LyricsResource implements LyricsResourcePort {

    private final AddLyricsBookmarkUseCase addLyricsBookmarkUseCase;
    private final RemoveLyricsBookmarkUseCase removeLyricsBookmarkUseCase;
    private final ModifyLyricsBookmarkUseCase modifyLyricsBookmarkUseCase;
    private final RetrieveAllLyricsUseCase retrieveAllLyricsUseCase;
    private final RetrieveSpecificLyricsUseCase retrieveSpecificLyricsUseCase;

    private final Random random = new Random();

    public LyricsResource(AddLyricsBookmarkUseCase addLyricsBookmarkUseCase,
                          RemoveLyricsBookmarkUseCase removeLyricsBookmarkUseCase,
                          ModifyLyricsBookmarkUseCase modifyLyricsBookmarkUseCase,
                          RetrieveAllLyricsUseCase retrieveAllLyricsUseCase,
                          RetrieveSpecificLyricsUseCase retrieveSpecificLyricsUseCase) {
        this.addLyricsBookmarkUseCase = addLyricsBookmarkUseCase;
        this.removeLyricsBookmarkUseCase = removeLyricsBookmarkUseCase;
        this.modifyLyricsBookmarkUseCase = modifyLyricsBookmarkUseCase;
        this.retrieveAllLyricsUseCase = retrieveAllLyricsUseCase;
        this.retrieveSpecificLyricsUseCase = retrieveSpecificLyricsUseCase;
    }

    @Override
    public ResponseEntity<Void> addLyrics(Lyrics lyrics) {
        addLyricsBookmarkUseCase.addLyrics(lyrics);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> removeLyrics(Lyrics lyrics) {
        removeLyricsBookmarkUseCase.removeLyrics(lyrics);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateLyrics(Lyrics lyrics) {
        modifyLyricsBookmarkUseCase.updateLyrics(lyrics);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Lyrics> getLyricsById(Long lyricsId) {
        try {
            return new ResponseEntity<>(retrieveSpecificLyricsUseCase.getLyricsById(lyricsId), HttpStatus.OK);
        } catch (LyricsNotFoundException ex) {
            log.error("Error!", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Lyrics>> getLyrics() {
        return new ResponseEntity<>(retrieveAllLyricsUseCase.getAllLyrics(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Lyrics> getRandomLyric() {
        final List<Lyrics> allLyrics = retrieveAllLyricsUseCase.getAllLyrics();
        final int size = allLyrics.size();
        return new ResponseEntity<>(allLyrics.get(random.nextInt(size)), HttpStatus.OK);
    }

}
