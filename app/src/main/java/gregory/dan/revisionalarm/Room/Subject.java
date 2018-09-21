package gregory.dan.revisionalarm.Room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Daniel Gregory on 21/09/2018.
 */
@Entity
public class Subject {

    @PrimaryKey
    public long _id;

    private String title;

    public Subject(long _id, String title) {
        this._id = _id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
