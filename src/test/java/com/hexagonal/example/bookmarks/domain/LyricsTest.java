package com.hexagonal.example.bookmarks.domain;

import com.hexagonal.example.bookmarks.domain.lyrics.model.Lyrics;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LyricsTest {

    @Test
    public void givenName_whenLyricsWithName_thenNameIsSet() {
        final Lyrics lyrics = Lyrics.builder()
                .participatingArtist("Lady Gaga")
                .lyrics("You can read my Pokerface")
                .build();

        assertThat(lyrics.getParticipatingArtist()).isEqualTo("Lady Gaga");
        assertThat(lyrics.getLyrics()).isEqualTo("You can read my Pokerface");
    }

    @Test
    public void givenTwoLyrics_whenSameNameAndLyrics_thenEqual() {
        final Lyrics lyrics1 = Lyrics.builder()
                .participatingArtist("Freddy Mercury")
                .lyrics("We are the champions")
                .build();
        final Lyrics lyrics2 = Lyrics.builder()
                .participatingArtist("Freddy Mercury")
                .lyrics("We are the champions")
                .build();

        assertThat(lyrics1).isEqualTo(lyrics2);
    }

    @Test
    public void givenTwoLyrics_whenDifferentParticipatingArtist_thenNotEqual() {
        final Lyrics lyrics1 = Lyrics.builder()
                .participatingArtist("Ariana Grande")
                .lyrics("I've got one less problem")
                .build();
        final Lyrics lyrics2 = Lyrics.builder()
                .participatingArtist("Iggy Azalea")
                .lyrics("I've got one less problem")
                .build();

        assertThat(lyrics1).isNotEqualTo(lyrics2);
    }

    @Test
    public void givenTwoLyrics_whenDifferentLyrics_thenNotEqual() {
        final Lyrics lyrics1 = Lyrics.builder()
                .participatingArtist("Ariana Grande")
                .lyrics("I've got one less problem")
                .build();
        final Lyrics lyrics2 = Lyrics.builder()
                .participatingArtist("Ariana Grande")
                .lyrics("don't call me angerl")
                .build();

        assertThat(lyrics1).isNotEqualTo(lyrics2);
    }

    @Test
    public void givenTwoLyrics_whenSameParticipatingArtistSameLyrics_thenSameHashCode() {
        final Lyrics lyrics1 = Lyrics.builder()
                .participatingArtist("Cardi B")
                .lyrics("Bloody shoes")
                .build();
        final Lyrics lyrics2 = Lyrics.builder()
                .participatingArtist("Cardi B")
                .lyrics("Bloody shoes")
                .build();

        assertThat(lyrics1.hashCode()).isEqualTo(lyrics2.hashCode());
    }

    @Test
    public void givenTwoLyrics_whenDifferentParticipatingArtist_thenNotSameHashCode() {
        final Lyrics lyrics1 = Lyrics.builder()
                .participatingArtist("BTS")
                .lyrics("boy with luv")
                .build();
        final Lyrics lyrics2 = Lyrics.builder()
                .participatingArtist("Halsey")
                .lyrics("boy with luv")
                .build();

        assertThat(lyrics1.hashCode()).isNotEqualTo(lyrics2.hashCode());
    }

    @Test
    public void givenLyrics_whenToString_thenSeeADescriptiveString() {
        final Lyrics lyrics1 = Lyrics.builder()
                .participatingArtist("Ed Sheeran")
                .lyrics("I'm in love with the shape of you")
                .build();

        assertThat(lyrics1.toString()).isEqualTo("Lyrics(lyrics=I'm in love with the shape of you, participatingArtist=Ed Sheeran)");
    }
}
