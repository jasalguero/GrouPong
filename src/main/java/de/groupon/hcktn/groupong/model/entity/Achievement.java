package de.groupon.hcktn.groupong.model.entity;

import java.io.Serializable;

public class Achievement implements Serializable {
    private Integer id;
    private String title;
    private String description;

    public Achievement() {

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

}
