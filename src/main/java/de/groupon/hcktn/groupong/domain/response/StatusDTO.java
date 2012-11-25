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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatusDTO)) return false;

        StatusDTO statusDTO = (StatusDTO) o;

        if (description != null ? !description.equals(statusDTO.description) : statusDTO.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return description != null ? description.hashCode() : 0;
    }
}
