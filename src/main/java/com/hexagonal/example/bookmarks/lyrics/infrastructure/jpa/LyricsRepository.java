package com.hexagonal.example.bookmarks.lyrics.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LyricsRepository extends JpaRepository<LyricsEntity, Long> {

    void deleteAllByParticipatingArtist(String name);

    LyricsEntity findByParticipatingArtist(String Name);

    LyricsEntity findByLyrics(String Lyrics);
}
