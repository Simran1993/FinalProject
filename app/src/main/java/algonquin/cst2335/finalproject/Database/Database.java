/**
 * Name: Nirmal Patel
 * Final Project:Song Search
 * Due Date: 5th April
 */
package algonquin.cst2335.finalproject.Database;
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;


@androidx.room.Database(entities = {SongDataBeans.class, HistoryBeans.class}, version = 1, exportSchema = false)
    public abstract class Database extends RoomDatabase {
        public abstract SongDao songDao();
        public abstract HistoryDAO searchHistoryDao();


        private static volatile Database INSTANCE;

        public static Database getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (Database.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                        Database.class, "song_database")
                                .fallbackToDestructiveMigration()
                                .build();
                    }
                }
            }
            return INSTANCE;
        }
    }

