/**
 * Adapter for a RecyclerView to display a list of {@link Lookup} objects.
 * This adapter manages the dataset of lookup entries, allowing for dynamic updates and customization
 * of each item's presentation within a RecyclerView.
 */
package algonquin.cst2335.finalproject;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SRSSAdapter extends RecyclerView.Adapter<SRSSView> {
    /**
     * The list of {@link Lookup} objects to be displayed by the RecyclerView.
     */
    private List<Lookup> LookupList = new ArrayList<>();
    /**
     * Called when RecyclerView needs a new {@link LookupViewHolder} of the given type to represent
     * an item.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     * @return A new {@link LookupViewHolder} that holds a View of the given view type.
     */
    @NonNull
    @Override
    public SRSSView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.srss_layout, parent, false);
        return new SRSSView(view);
    }
    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link LookupViewHolder#itemView} to reflect the item at the given
     * position.
     *
     * @param holder The {@link LookupViewHolder} which should be updated to represent the
     *               contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull SRSSView holder, int position) {
        Lookup Lookup = LookupList.get(position);
        holder.bind(Lookup);
    }
    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter's data set.
     */
    @Override
    public int getItemCount() {
        return LookupList.size();
    }
    /**
     * Updates the data set used by the adapter and refreshes the view to display the new data.
     *
     * @param Lookups The new list of {@link Lookup} objects to be displayed.
     */
    public void setLookups(List<Lookup> Lookups) {
        this.LookupList = Lookups;
        notifyDataSetChanged();
    }
}
