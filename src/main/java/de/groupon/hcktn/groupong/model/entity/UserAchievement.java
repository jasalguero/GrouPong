package de.groupon.hcktn.groupong.model.entity;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 11/24/12
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserAchievement {
    private Integer id;
    private Integer userId;
    private Integer achievementId;

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
