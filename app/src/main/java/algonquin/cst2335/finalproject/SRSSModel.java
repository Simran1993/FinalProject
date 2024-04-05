package algonquin.cst2335.finalproject;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
/**
 * ViewModel for managing UI-related data in a lifecycle-conscious way. This class abstracts
 * the data source from the UI and allows data to survive configuration changes such as screen rotations.
 * <p>
 * Specifically, this ViewModel handles database operations related to {@link Lookup} entities,
 * leveraging the {@link LookupDAO} for data access and manipulation.
 */
public class SRSSModel extends AndroidViewModel {
    /**
     * Data Access Object (DAO) for {@link Lookup} entities.
     */
    private final LookupDAO LookupDAO;
    /**
     * Live data list of all {@link Lookup} entries in the database.
     */
    private final LiveData<List<Lookup>> allLookups;
    /**
     * Constructs the ViewModel with a reference to the application and initializes
     * the {@link LookupDAO} and LiveData list of all lookups.
     *
     * @param application The application context, used to initialize the database instance.
     */

    public SRSSModel(@NonNull Application application) {
        super(application);
        SRSSDatabase database = SRSSDatabase.getInstance(application);
        LookupDAO = database.lookupDAO();
        allLookups = LookupDAO.getAllLookups();
    }
    /**
     * Inserts a {@link Lookup} entry into the database asynchronously.
     *
     * @param Lookup The {@link Lookup} entity to be inserted.
     */
    public void insert(Lookup Lookup) {
        SRSSDatabase.databaseWriteExecutor.execute(() -> LookupDAO.insert(Lookup));
    }
    /**
     * Retrieves a LiveData list of all {@link Lookup} entries from the database.
     * LiveData observes changes to the data source and notifies the observer when the data changes.
     *
     * @return A LiveData list of all {@link Lookup} entries.
     */
    public LiveData<List<Lookup>> getAllLookups() {
        return allLookups;
    }
    /**
     * Clears all {@link Lookup} entries from the database asynchronously.
     */
    public void clearAllLookups() {
        SRSSDatabase.databaseWriteExecutor.execute(() -> LookupDAO.deleteAll());
    }

}
