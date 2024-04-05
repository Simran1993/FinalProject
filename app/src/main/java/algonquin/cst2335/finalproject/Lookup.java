package algonquin.cst2335.finalproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
/**
 * Entity representing a lookup for sunrise and sunset times based on latitude and longitude.
 * This class is used to store and retrieve lookup information from the application's database.
 */
@Entity(tableName = "lookups")
public class Lookup {
    @PrimaryKey(autoGenerate = true)
    /**
     * The unique ID of the lookup. This field is auto-generated by the database.
     */

    private int id;
    /**
     * The latitude of the location for the lookup.
     */
    private String latitude;
    /**
     * The longitude of the location for the lookup.
     */
    private String longitude;
    /**
     * The sunrise time for the location.
     */
    private String sunrise;
    /**
     * The sunset time for the location.
     */
    private String sunset;
    /**
     * Constructs a new Lookup with specified latitude, longitude, sunrise, and sunset times.
     *
     * @param latitude The latitude of the location.
     * @param longitude The longitude of the location.
     * @param sunrise The sunrise time for the location.
     * @param sunset The sunset time for the location.
     */
    public Lookup(String latitude, String longitude, String sunrise, String sunset) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
    /**
     * Returns the ID of the lookup.
     *
     * @return The ID of the lookup.
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the ID of the lookup.
     *
     * @param id The new ID of the lookup.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Returns the latitude of the location.
     *
     * @return The latitude of the location.
     */
    public String getLatitude() {
        return latitude;
    }
    /**
     * Returns the longitude of the location.
     *
     * @return The longitude of the location.
     */
    public String getLongitude() {
        return longitude;
    }
    /**
     * Returns the sunrise time for the location.
     *
     * @return The sunrise time for the location.
     */
    public String getSunrise() {
        return sunrise;
    }
    /**
     * Returns the sunset time for the location.
     *
     * @return The sunset time for the location.
     */
    public String getSunset() {
        return sunset;
    }

}