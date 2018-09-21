package gregory.dan.revisionalarm.Room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Daniel Gregory on 21/09/2018.
 */
@Dao
public interface SubjectDao {

    @Query("SELECT * FROM Subject")
    LiveData<List<Subject>> loadAllSubjects();

    @Insert(onConflict = REPLACE)
    void insertSubject(Subject subject);

    @Delete
    void deleteSubject(Subject subject);

    @Update(onConflict = REPLACE)
    void updateSubject(Subject subject);

    @Query("DELETE FROM Subject")
    void deleteAllSubjects();
}
