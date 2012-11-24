package de.groupon.hcktn.groupong.domain.response;

import de.groupon.config.web.annotation.JsonImplicit;
import de.groupon.hcktn.groupong.model.entity.Status;

@JsonImplicit(StatusDTO.class)
public class StatusDTO extends BaseDTO {

    private String description;

    public StatusDTO() {
    }

    public StatusDTO(final Status status) {
        super(status.getId());
        this.description = status.getDescription();
    }

    public StatusDTO(Integer id, String description) {
        super(id);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
