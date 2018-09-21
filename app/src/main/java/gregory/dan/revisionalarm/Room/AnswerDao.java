package gregory.dan.revisionalarm.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Daniel Gregory on 21/09/2018.
 */
@Dao
public interface AnswerDao {

    @Query("SELECT * FROM Answer WHERE question_id=:questionId")
    Answer loadCorrectAnswer(long questionId);

    @Query("SELECT * FROM Answer WHERE subject_id=:subjectId")
    List<Answer> loadRandomAnswers(long subjectId);

    @Insert(onConflict = REPLACE)
    void insertAnswer(Answer answer);

    @Update(onConflict = REPLACE)
    void updateAnswer(Answer answer);

}
