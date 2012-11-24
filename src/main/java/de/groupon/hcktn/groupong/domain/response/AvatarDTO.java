package de.groupon.hcktn.groupong.domain.response;

import de.groupon.config.web.annotation.JsonImplicit;

@JsonImplicit(AvatarDTO.class)
public class AvatarDTO extends BaseDTO {

    private String url;

    public AvatarDTO() {

    }

    public AvatarDTO(Integer id) {
        super(id);
    }

    public AvatarDTO(Integer id, String url) {
        this(id);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
