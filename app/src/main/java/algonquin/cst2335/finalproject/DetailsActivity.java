/**
 * Name: Nirmal Patel
 * Final Project: Song Search
 * Due Date: 5th April
 */

/**
 * DetailsActivity is an activity class responsible for displaying the details of a song and handling its storage in a local database.
 * It uses the Room persistence library to interact with a SQLite database and the Picasso library for image loading.
 */
package algonquin.cst2335.finalproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.squareup.picasso.Picasso;

import algonquin.cst2335.finalproject.Database.Database;
import algonquin.cst2335.finalproject.Database.Database.*;
import algonquin.cst2335.finalproject.Database.SongDataBeans;

/**
 * The DetailsActivity class displays the details of a song and allows users to save the song to their favorites.
 */
public class DetailsActivity extends AppCompatActivity {
    private ImageView albumCoverImageView;
    private TextView titleTextView, artistTextView, albumTextView, durationTextView;
    private Database db;

    /**
     * Called when the activity is starting. This is where most initialization should go.
     * It initializes the database and UI components and sets the content view to the activity's layout.
     * It also retrieves the SongBeans object passed from the previous Activity and displays its details.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle). Otherwise it is null.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Initialize Room database
        db = Room.databaseBuilder(getApplicationContext(), Database.class, "songs_database")
                .fallbackToDestructiveMigration()
                .build();

        // Initialize views
        albumCoverImageView = findViewById(R.id.album_cover_image);
        titleTextView = findViewById(R.id.song_title);
        artistTextView = findViewById(R.id.artist_name);
        albumTextView = findViewById(R.id.album_name);
        durationTextView = findViewById(R.id.song_duration);

        // Get the selected song from the intent
        final SongBeans songBeans = (SongBeans) getIntent().getSerializableExtra("selectedSong");
        if (songBeans != null) {
            displaySongDetails(songBeans);
        }

        // Set up the listener for the save button
        findViewById(R.id.save_button).setOnClickListener(v -> {
            if (songBeans != null) {
                saveSongToDatabase(songBeans);
            }
        });
    }

    /**
     * Displays the details of the provided SongBeans object in the UI.
     *
     * @param songBeans The SongBeans object whose details are to be displayed.
     */
    private void displaySongDetails(SongBeans songBeans) {
        titleTextView.setText(songBeans.getTitle());
        artistTextView.setText(songBeans.getArtistName());
        albumTextView.setText(songBeans.getAlbumName());
        durationTextView.setText(songBeans.getFormattedDuration());
        Picasso.get().load(songBeans.getCoverUrl()).into(albumCoverImageView);
    }

    /**
     * Saves the provided SongBeans object to the local Room database.
     * It performs the database operation in a separate thread and shows a toast upon completion.
     *
     * @param songBeans The SongBeans object to save to the database.
     */
    private void saveSongToDatabase(SongBeans songBeans) {
        SongDataBeans songDataBeans = new SongDataBeans(songBeans.getTitle(), songBeans.getArtistName(), songBeans.getAlbumName(), songBeans.getDuration(), songBeans.getCoverUrl());
        new Thread(() -> {
            db.songDao().insert(songDataBeans);
            runOnUiThread(() -> Toast.makeText(DetailsActivity.this, "Song saved to favorites", Toast.LENGTH_SHORT).show());
        }).start();
    }
}
