/**
 * Name: Nirmal Patel
 * Final Project: Song Search
 * Due Date: 5th April
 */
package algonquin.cst2335.finalproject;

import java.io.Serializable;

/**
 * SongBeans represents a song with details such as title, artist name, album name, cover URL, and duration.
 * It provides functionality to get these details and to format the song duration from seconds to a readable format.
 */
public class SongBeans implements Serializable {

    private String title;
    private String artistName;
    private String albumName;
    private String coverUrl;
    private int duration; // Duration in seconds

    /**
     * Constructs a new SongBeans object with specified details.
     *
     * @param title      The title of the song.
     * @param artistName The name of the artist.
     * @param albumName  The name of the album.
     * @param coverUrl   The URL for the album cover image.
     * @param duration   The duration of the song in seconds.
     */
    public SongBeans(String title, String artistName, String albumName, String coverUrl, int duration) {
        this.title = title;
        this.artistName = artistName;
        this.albumName = albumName;
        this.coverUrl = coverUrl;
        this.duration = duration;
    }

    // Getters

    /**
     * Returns the title of the song.
     *
     * @return The title of the song.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the name of the artist.
     *
     * @return The name of the artist.
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Returns the name of the album.
     *
     * @return The name of the album.
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * Returns the URL for the album cover image.
     *
     * @return The URL for the album cover image.
     */
    public String getCoverUrl() {
        return coverUrl;
    }

    /**
     * Returns the duration of the song in seconds.
     *
     * @return The duration of the song in seconds.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Returns the duration of the song formatted as a string in the format "mm:ss".
     *
     * @return The formatted duration of the song.
     */
    public String getFormattedDuration() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
