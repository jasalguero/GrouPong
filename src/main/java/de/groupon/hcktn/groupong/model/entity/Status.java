package de.groupon.hcktn.groupong.model.entity;

public class Status {
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


}
