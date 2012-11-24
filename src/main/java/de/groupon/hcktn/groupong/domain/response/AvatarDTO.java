package de.groupon.hcktn.groupong.domain.response;

public class AvatarDTO {

    private String url;

    public AvatarDTO(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
