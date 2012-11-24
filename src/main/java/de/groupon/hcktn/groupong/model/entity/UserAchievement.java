package de.groupon.hcktn.groupong.model.entity;

public class UserAchievement {
    private Integer id;
    private Integer userId;
    private Integer achievementId;

    public UserAchievement() {

    }

    public UserAchievement(final Integer id, final Integer userId, final Integer achievementId) {
        this.id = id;
        this.userId = userId;
        this.achievementId = achievementId;
    }


    public UserAchievement(final Integer userId, final Integer achievementId) {
        this.userId = userId;
        this.achievementId = achievementId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = id;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(final Integer achievementId) {
        this.achievementId = achievementId;
    }
}
