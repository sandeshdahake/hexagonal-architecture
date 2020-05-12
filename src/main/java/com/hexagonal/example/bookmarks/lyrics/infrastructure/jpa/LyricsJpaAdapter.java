package com.hexagonal.example.bookmarks.lyrics.infrastructure.jpa;

import com.hexagonal.example.bookmarks.lyrics.domain.Lyrics;
import com.hexagonal.example.bookmarks.lyrics.domain.LyricsNotFoundException;
import com.hexagonal.example.bookmarks.lyrics.domain.LyricsPersistencePort;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class LyricsJpaAdapter implements LyricsPersistencePort {

    private LyricsRepository lyricsRepository;

    public LyricsJpaAdapter(LyricsRepository lyricsRepository) {
        this.lyricsRepository = lyricsRepository;
    }

    @Override
    public void addLyrics(Lyrics lyrics) {
        final LyricsEntity lyricsEntity = getLyricsEntity(lyrics);
        lyricsRepository.save(lyricsEntity);
    }

    @Override
    public void removeLyrics(Lyrics lyrics) {
        lyricsRepository.deleteAllByParticipatingArtist(lyrics.getParticipatingArtist());
    }

    @Override
    public void updateLyrics(Lyrics lyrics) {
        final LyricsEntity byParticipatingArtist = lyricsRepository.findByParticipatingArtist(lyrics.getParticipatingArtist());
        if (Objects.nonNull(byParticipatingArtist)) {
            byParticipatingArtist.setLyrics(lyrics.getLyrics());
            lyricsRepository.save(byParticipatingArtist);
        } else {
            final LyricsEntity byLyrics = lyricsRepository.findByLyrics(lyrics.getLyrics());
            if (Objects.nonNull(byLyrics)) {
                byLyrics.setParticipatingArtist(lyrics.getParticipatingArtist());
                lyricsRepository.save(byLyrics);
            }
        }
    }

    @Override
    public List<Lyrics> getAllLyrics() {
        return lyricsRepository.findAll()
                .stream()
                .map(this::getLyrics)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public Lyrics getLyricsById(Long lyricsId) {
        return getLyrics(lyricsRepository.findById(lyricsId)
                .orElseThrow((Supplier<Throwable>) () -> new LyricsNotFoundException(lyricsId)));
    }

    private LyricsEntity getLyricsEntity(Lyrics lyrics) {
        return LyricsEntity.builder()
                .participatingArtist(lyrics.getParticipatingArtist())
                .lyrics(lyrics.getLyrics())
                .build();
    }

    private Lyrics getLyrics(LyricsEntity lyricsEntity) {
        return Lyrics.builder()
                .participatingArtist(lyricsEntity.getParticipatingArtist())
                .lyrics(lyricsEntity.getLyrics())
                .build();
    }

}