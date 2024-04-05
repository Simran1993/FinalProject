/**
 * Name:Nirmal Patel
 * Final Project: Song Search
 * Due Date: 5th April
 */
package algonquin.cst2335.finalproject.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "History")
public class HistoryBeans {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String searchTerm;

    public HistoryBeans(String searchTerm) {
        this.searchTerm = searchTerm;
    }

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
}

