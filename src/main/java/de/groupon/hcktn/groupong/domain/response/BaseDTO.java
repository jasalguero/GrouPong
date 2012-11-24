package de.groupon.hcktn.groupong.domain.response;

import de.groupon.config.web.annotation.JsonImplicit;

@JsonImplicit(BaseDTO.class)
public class BaseDTO {

    private Integer id;

    public BaseDTO() {
    }

    public BaseDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
