package de.groupon.hcktn.groupong.model.entity;

/**
 * Created with IntelliJ IDEA.
 * Date: 11/24/12
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class Status {
    private Integer id;
    private String description;

    public Status() {

    }

    public Status(final Integer id, final String description) {
        this.id = id;
        this.description = description;
    }

    public Status(final String description) {
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

    public void setDescriptions(final String description) {
        this.description = description;
    }


}
