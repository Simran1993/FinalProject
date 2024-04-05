/**
 * Main activity class that handles the user interface for fetching and displaying sunrise and sunset times.
 * This activity allows users to input latitude and longitude values, retrieve sunrise and sunset times for those coordinates,
 * and save the information for future reference. It also supports navigating to a view of saved lookups.
 * @author; prince vaghasiya
 * @version: 1.0
 * @labsection: cst2335 013
 */
package algonquin.cst2335.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SRSSSunriseMainActivity extends AppCompatActivity {
    /**
     * EditText field for entering latitude longitude..
     */
    private EditText latitudeEditText;
    private EditText longitudeEditText;
    /**
     * TextView to display the sunrise and sunset time .
     */
    private TextView sunriseTextView;
    private TextView sunsetTextView;
    /**
     * ViewModel instance for managing UI-related data in a lifecycle-conscious way.
     */
    private SRSSModel viewSRSSModel;
    /**
     * Name of the SharedPreferences file to store the last used latitude and longitude.
     */
    private static final String NAME = "SunriseSunsetPrefs";
    /**
     * Key for storing/retrieving the latitude value from SharedPreferences.
     */
    private static final String LATITUDE = "latitude";
    /**
     * Key for storing/retrieving the longitude value from SharedPreferences.
     */
    private static final String LONGITUDE = "longitude";
    /**
     * Initializes the activity, its views, and sets up event listeners.
     * Restores the last entered latitude and longitude if available.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     *                           Note: Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.srss_sunmain_activity);

        latitudeEditText = findViewById(R.id.latitude);
        longitudeEditText = findViewById(R.id.longitude);
        sunriseTextView = findViewById(R.id.sunrise);
        sunsetTextView = findViewById(R.id.sunset);

        Button getSunriseSunsetButton = findViewById(R.id.SunriseSunset);
        Button btnShowSavedLookups = findViewById(R.id.Saved);

        viewSRSSModel = new ViewModelProvider(this).get(SRSSModel.class);

        SharedPreferences prefs = getSharedPreferences(NAME, MODE_PRIVATE);
        String lastLatitude = prefs.getString(LATITUDE, "");
        String lastLongitude = prefs.getString(LONGITUDE, "");
        latitudeEditText.setText(lastLatitude);
        longitudeEditText.setText(lastLongitude);

        getSunriseSunsetButton.setOnClickListener(v -> getSunriseSunsetInfo());

        btnShowSavedLookups.setOnClickListener(v -> {
            Log.d("Button Click", "Clicked on Show Saved Lookups Button");
            Intent intent = new Intent(SRSSSunriseMainActivity.this, SRSSSavedView.class);
            startActivity(intent);
        });

        Button save = findViewById(R.id.save);
        save.setOnClickListener(v -> saveToDatabase());
    }

    /**
     * Saves the current latitude, longitude, sunrise, and sunset to the local database.
     * Displays a toast message indicating success or failure.
     */
    private void saveToDatabase() {

        getSunriseSunsetInfo();


        String latitude = latitudeEditText.getText().toString();
        String longitude = longitudeEditText.getText().toString();
        String sunrise = sunriseTextView.getText().toString();
        String sunset = sunsetTextView.getText().toString();


        if (!latitude.isEmpty() && !longitude.isEmpty() && !sunrise.isEmpty() && !sunset.isEmpty()) {

            SharedPreferences.Editor editor = getSharedPreferences(NAME, MODE_PRIVATE).edit();
            editor.putString(LATITUDE, latitude);
            editor.putString(LONGITUDE, longitude);
            editor.apply();


            Lookup Lookup = new Lookup(latitude, longitude, sunrise, sunset);
            viewSRSSModel.insert(Lookup);


            Toast.makeText(SRSSSunriseMainActivity.this, "saved", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(SRSSSunriseMainActivity.this, "Please enter right value", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * Fetches sunrise and sunset times for the currently entered latitude and longitude.
     * Displays the results in the UI and handles any errors encountered.
     */
    private void getSunriseSunsetInfo() {
        String latitude = latitudeEditText.getText().toString();
        String longitude = longitudeEditText.getText().toString();

        String apiUrl = "https://api.sunrisesunset.io/json?lat=" + latitude + "&lng=" + longitude + "&timezone=UTC&date=today";

        StringRequest request = new StringRequest(Request.Method.GET, apiUrl, response -> {
            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONObject resultsObject = jsonObject.getJSONObject("results");

                String sunrise = resultsObject.getString("sunrise");
                String sunset = resultsObject.getString("sunset");

                sunriseTextView.setText("Sunrise: " + sunrise);
                sunsetTextView.setText("Sunset: " + sunset);

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(SRSSSunriseMainActivity.this, "Parsing dawn and sunset data produces an error", Toast.LENGTH_SHORT).show();
            }
        }, error -> {
            Toast.makeText(SRSSSunriseMainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
        });
        Volley.newRequestQueue(this).add(request);
    }

}
