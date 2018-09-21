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
                childColumns = "subject_id"
        )
}, indices = @Index("subject_id"))
public class Answer {

        @PrimaryKey
        private long question_id;

        private long subject_id;

        private String answer;

        public Answer(long question_id, long subject_id, String answer) {
                this.question_id = question_id;
                this.subject_id = subject_id;
                this.answer = answer;
        }

        public long getQuestion_id() {
                return question_id;
        }

        public long getSubject_id() {
                return subject_id;
        }

        public String getAnswer() {
                return answer;
        }
}
