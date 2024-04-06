package algonquin.cst2335.finalproject.Dist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import algonquin.cst2335.finalproject.R;


public class SavedSearchesAdapter extends RecyclerView.Adapter<SavedSearchesAdapter.SearchEntryViewHolder> {
    private List<SearchEntry> searchEntries;
    private LayoutInflater mInflater;

    private OnItemClickListener mListener;

    public SavedSearchesAdapter(Context context, List<SearchEntry> searchEntries, OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.searchEntries = searchEntries;
        this.mListener = listener; // Initialize listener
    }

    @NonNull
    @Override
    public SearchEntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.search_entry_item, parent, false);
        return new SearchEntryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchEntryViewHolder holder, int position) {
        String searchTerm = searchEntries.get(position).searchTerm;
        holder.searchTermTextView.setText(searchTerm);
        holder.itemView.setOnClickListener(v -> mListener.onItemClick(searchTerm)); // Handle item click
    }

    @Override
    public int getItemCount() {
        return searchEntries.size();
    }

    static class SearchEntryViewHolder extends RecyclerView.ViewHolder {
        TextView searchTermTextView;

        public SearchEntryViewHolder(@NonNull View itemView) {
            super(itemView);
            searchTermTextView = itemView.findViewById(R.id.tvSearchTerm);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(String searchTerm);
    }

}
