package algonquin.cst2335.finalproject.Dist;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import algonquin.cst2335.finalproject.R;

public class DefinitionsAdapter extends RecyclerView.Adapter<DefinitionsAdapter.DefinitionViewHolder> {
    private List<Definition> definitions;

    public DefinitionsAdapter(List<Definition> definitions) {
        this.definitions = definitions;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.definition_item, parent, false);
        return new DefinitionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        holder.tvDefinition.setText(definitions.get(position).definition);
    }

    @Override
    public int getItemCount() {
        return definitions.size();
    }

    public void setDefinitions(List<Definition> definitions) {
    }

    static class DefinitionViewHolder extends RecyclerView.ViewHolder {
        TextView tvDefinition;

        DefinitionViewHolder(View itemView) {
            super(itemView);
            tvDefinition = itemView.findViewById(R.id.tvDefinition);
        }
    }
}


