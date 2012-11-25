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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvatarDTO)) return false;

        AvatarDTO avatarDTO = (AvatarDTO) o;

        if (url != null ? !url.equals(avatarDTO.url) : avatarDTO.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }
}
