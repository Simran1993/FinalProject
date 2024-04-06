package algonquin.cst2335.finalproject.Dist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SearchEntryDao {
    @Query("SELECT * FROM search_entries")
    LiveData<List<SearchEntry>> getAll();

    @Insert
    void insert(SearchEntry searchEntry);

    @Delete
    void delete(SearchEntry searchEntry);
    @Query("SELECT * FROM search_entries")
    List<SearchEntry> getAllSync();

    @Query("DELETE  FROM search_entries")
    void deleteAll();
}

