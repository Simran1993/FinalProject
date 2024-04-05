package algonquin.cst2335.finalproject;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/**
 * {@code View} serves as a ViewHolder for the RecyclerView, specifically for items
 * representing lookup details including sunrise and sunset times. It holds references to
 * the TextViews within a RecyclerView item's layout and populates them with the appropriate
 * data from a {@link Lookup} instance.
 */
public class SRSSView extends RecyclerView.ViewHolder {

    private TextView sunriseTextView;
    private TextView sunsetTextView;
    /**
     * Constructs the {@code View} ViewHolder, initializing its TextView components
     * for displaying sunrise and sunset times.
     *
     * @param itemView The view of the RecyclerView item. It is expected to include
     *                 TextView elements identified by {@code R.id.sunrisetextview} and
     *                 {@code R.id.sunsetTextView}.
     */
    public SRSSView(@NonNull android.view.View itemView) {
        super(itemView);
        /**
         * Binds a {@link Lookup} instance to the ViewHolder, setting the sunrise and sunset
         * TextViews to display the sunrise and sunset times.
         *
         * @param lookup The {@link Lookup} instance containing the sunrise and sunset data
         *               to be displayed in this ViewHolder.
         */
        sunriseTextView = itemView.findViewById(R.id.sunrisetextview);
        sunsetTextView = itemView.findViewById(R.id.sunsetTextView);
    }

    public void bind(Lookup Lookup) {
        sunriseTextView.setText("Sunrise: " + Lookup.getSunrise());
        sunsetTextView.setText("Sunset: " + Lookup.getSunset());
    }
}
