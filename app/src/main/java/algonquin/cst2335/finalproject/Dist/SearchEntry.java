package algonquin.cst2335.finalproject.Dist;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "search_entries")
public class SearchEntry {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "search_term")
    public String searchTerm;

    @ColumnInfo(name = "definitions")
    public String definitions; // JSON String of definitions

    private boolean isDescriptionVisible = false;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getDefinitions() {
        return definitions;
    }

    public void setDefinitions(String definitions) {
        this.definitions = definitions;
    }

    public boolean isDescriptionVisible() {
        return isDescriptionVisible;
    }

    public void setDescriptionVisible(boolean descriptionVisible) {
        isDescriptionVisible = descriptionVisible;
    }
}


