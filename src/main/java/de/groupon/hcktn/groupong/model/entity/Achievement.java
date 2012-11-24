package de.groupon.hcktn.groupong.model.entity;

import java.io.Serializable;

public class Achievement implements Serializable {
    private Integer id;
    private String title;
    private String description;

    public Achievement() {

    }

    public Achievement(Integer id, String title, String description) {
        this.setId(id);
        this.setTitle(title);
        this.setDescription(description);
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Achievement that = (Achievement) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int myresult = id != null ? id.hashCode() : 0;
        myresult = 31 * myresult + (title != null ? title.hashCode() : 0);
        myresult = 31 * myresult + (description != null ? description.hashCode() : 0);
        return myresult;
    }
}
