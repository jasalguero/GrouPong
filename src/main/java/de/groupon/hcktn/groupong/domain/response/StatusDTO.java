package de.groupon.hcktn.groupong.domain.response;

import de.groupon.hcktn.groupong.model.entity.Status;

public class StatusDTO {

    private Integer id;
    private String description;

    public StatusDTO(final Status status) {
        this.id = status.getId();
        this.description = status.getDescription();
    }

    public StatusDTO(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
