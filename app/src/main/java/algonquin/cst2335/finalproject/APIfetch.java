/**
 * Name: Nirmal Patel
 * Final Project: Song Search
 * Due Date: 5th April
 */
/**
 * This class handles the parsing of API responses into a list of {@link SongBeans} objects.
 */
package algonquin.cst2335.finalproject;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * APIfetch class provides static methods to parse JSON objects retrieved from the Deezer API.
 */
public class APIfetch {
    private static final String TAG = APIfetch.class.getSimpleName();

    /**
     * Parses a JSON response object containing an array of song information and creates a list of {@link SongBeans} objects.
     * Each song object is instantiated with the title, artist name, album name, cover URL, and duration.
     * If parsing fails, an error is logged and an empty list is returned.
     *
     * @param jsonResponse The JSON object containing the songs information.
     * @return A list of {@link SongBeans} objects parsed from the JSON response.
     */
    public static List<SongBeans> parseSongsFromJson(JSONObject jsonResponse) {
        List<SongBeans> songsList = new ArrayList<>();

        try {
            JSONArray data = jsonResponse.getJSONArray("data"); // Assuming 'data' is a JSONArray

            for (int i = 0; i < data.length(); i++) {
                JSONObject songJson = data.getJSONObject(i);
                String title = songJson.getString("title");
                String artistName = songJson.getJSONObject("artist").getString("name");
                String albumName = songJson.getJSONObject("album").getString("title");
                String coverUrl = songJson.getJSONObject("album").getString("cover");
                int duration = songJson.getInt("duration");

                SongBeans songBeans = new SongBeans(title, artistName, albumName, coverUrl, duration);
                songsList.add(songBeans);
            }
        } catch (JSONException e) {
            Log.e(TAG, "Error parsing JSON response: " + e.getMessage());
        }

        return songsList;
    }
}
