package algonquin.cst2335.finalproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LookupDAO {
    @Insert
    void insert(Lookup Lookup);

    @Query("SELECT * FROM lookups")
    LiveData<List<Lookup>> getAllLookups();

    @Update
    void update(Lookup Lookup);

    @Query("DELETE FROM lookups")
    void deleteAll();

}
