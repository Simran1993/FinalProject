/**
 * Name: Nirmal Patel
 * Final Project: Song Search
 * Due Date: 5th April
 */
package algonquin.cst2335.finalproject;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferencesManager is a utility class for managing SharedPreferences related to the application.
 */
public class SharedPreferencesManager {
    private static final String SHARED_PREF_NAME = "MySharedPref";
    private static final String KEY_SEARCH_TERM = "searchTerm";

    private SharedPreferences sharedPreferences;
    private static SharedPreferencesManager instance;

    /**
     * Constructor for the SharedPreferencesManager class.
     *
     * @param context The context used to access SharedPreferences.
     */
    public SharedPreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Retrieves the singleton instance of SharedPreferencesManager.
     *
     * @param context The context used to access SharedPreferences.
     * @return The singleton instance of SharedPreferencesManager.
     */
    public static synchronized SharedPreferencesManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesManager(context);
        }
        return instance;
    }

    /**
     * Saves a search term to SharedPreferences.
     *
     * @param searchTerm The search term to be saved.
     */
    public void saveSearchTerm(String searchTerm) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_SEARCH_TERM, searchTerm);
        editor.apply();
    }

    /**
     * Retrieves the saved search term from SharedPreferences.
     *
     * @return The saved search term, or an empty string if not found.
     */
    public String getSearchTerm() {
        return sharedPreferences.getString(KEY_SEARCH_TERM, "");
    }

    /**
     * Clears the saved search term from SharedPreferences.
     */
    public void clearSearchTerm() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_SEARCH_TERM);
        editor.apply();
    }
}
