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
public interface QuestionDao {

    @Query("SELECT * FROM Question WHERE subject_id=:subjectId")
    LiveData<List<Question>> loadAllQs(long subjectId);

    @Query("SELECT * FROM Question WHERE subject_id=:subjectId")
    List<Question> loadRandomQs(long subjectId);

    @Insert(onConflict = REPLACE)
    void insertQ(Question q);

    @Delete
    void deleteQ(Question q);

    @Update(onConflict = REPLACE)
    void updateQ(Question q);

}
