/**
 * Name: Nirmal Patel
 * Final Project: Song Search
 * Due Date: 5th April
 */
package algonquin.cst2335.finalproject.Database;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDAO {
    @Insert
    void insert(HistoryBeans historyBeans);

    @Query("SELECT * FROM History ORDER BY id DESC")
    List<HistoryBeans> getAllSearchTerms();

    @Query("DELETE FROM History")
    void deleteAll();
}