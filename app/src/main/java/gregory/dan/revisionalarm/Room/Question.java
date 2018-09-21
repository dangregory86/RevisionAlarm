package gregory.dan.revisionalarm.Room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Daniel Gregory on 21/09/2018.
 */
@Entity(foreignKeys = {
        @ForeignKey(onDelete = CASCADE,
                entity = Subject.class,
                parentColumns = "_id",
                childColumns = "subject_id")
}, indices = @Index("subject_id"))
public class Question {

    @PrimaryKey
    public long _id;

    private long subject_id;

    private String question;

    public Question(long _id, long subject_id, String question) {
        this._id = _id;
        this.subject_id = subject_id;
        this.question = question;
    }

    public long getSubject_id() {
        return subject_id;
    }

    public String getQuestion() {
        return question;
    }
}
