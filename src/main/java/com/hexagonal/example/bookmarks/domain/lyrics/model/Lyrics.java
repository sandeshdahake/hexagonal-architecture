package com.hexagonal.example.bookmarks.domain.lyrics.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Lyrics {
    private String lyrics;

    private String participatingArtist;
}
