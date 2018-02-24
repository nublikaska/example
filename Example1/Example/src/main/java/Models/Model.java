package Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public abstract class Model implements Serializable {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("archived")
    @Expose
    private boolean archived;

    public Model() {

    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
