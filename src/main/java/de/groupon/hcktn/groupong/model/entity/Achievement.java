package de.groupon.hcktn.groupong.model.entity;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 11/24/12
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Achievement {
    private Integer id;
    private String title;
    private String description;

    public Achievement(final Integer id, final String title, final String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }


    public Achievement(final String title, final String description) {
        this.title = title;
        this.description = description;
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
