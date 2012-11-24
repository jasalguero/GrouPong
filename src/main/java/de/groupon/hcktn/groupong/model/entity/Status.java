package de.groupon.hcktn.groupong.model.entity;

import java.io.Serializable;

public class Status implements Serializable {
    private Integer id;
    private String description;

    public Status() {
    }

    public Status(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
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

        final Status myStatus = (Status) o;

        if (description != null ? !description.equals(myStatus.description) : myStatus.description != null)
            return false;
        if (id != null ? !id.equals(myStatus.id) : myStatus.id != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int myresult = id != null ? id.hashCode() : 0;
        myresult = 31 * myresult + (description != null ? description.hashCode() : 0);
        return myresult;
    }
}
