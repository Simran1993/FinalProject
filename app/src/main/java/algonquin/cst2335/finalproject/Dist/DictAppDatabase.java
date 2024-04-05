package algonquin.cst2335.finalproject.Dist;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SearchEntry.class}, version = 1, exportSchema = false)
public abstract class DictAppDatabase extends RoomDatabase {
    public abstract SearchEntryDao searchEntryDao();

    private static volatile DictAppDatabase INSTANCE;

    static DictAppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DictAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DictAppDatabase.class, "search_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}


