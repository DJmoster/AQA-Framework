package sviat.dev.task5;

import java.io.Serializable;
import java.util.Date;

public class Meeting implements Serializable {
    private String title;
    private Date date;
    private String description;

    public Meeting() {}

    public Meeting(String title, Date date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
