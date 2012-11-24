package de.groupon.hcktn.groupong.domain.response;

import de.groupon.config.web.annotation.JsonImplicit;

@JsonImplicit(AchievementDTO.class)
public class AchievementDTO extends BaseDTO {

    private String title;

    private String description;

    public AchievementDTO() {
    }

    public AchievementDTO(Integer id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
