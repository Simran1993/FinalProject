/**
 * Name: Nirmal Patel
 * Final Project: Song Search
 * Due Date: 5th April
 */
package algonquin.cst2335.finalproject.Database;import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SongDao {
    @Insert
    void insert(SongDataBeans song);

    @Query("SELECT * FROM songs")
    List<SongDataBeans> getAllFavoriteSongs();

    @Query("DELETE FROM songs")
    void deleteAll();


}