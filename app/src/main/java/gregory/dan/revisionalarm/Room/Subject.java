package gregory.dan.revisionalarm.Room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Daniel Gregory on 21/09/2018.
 */
@Entity
public class Subject {

    @PrimaryKey
    @NonNull
    private long _id;

    private String title;

    public Subject(@NonNull long _id, String title) {
        this._id = _id;
        this.title = title;
    }

    @NonNull
    public long get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }
}
