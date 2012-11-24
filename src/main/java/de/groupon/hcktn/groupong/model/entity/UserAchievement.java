package de.groupon.hcktn.groupong.model.entity;

import java.io.Serializable;

public class UserAchievement implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer achievementId;

    public UserAchievement() {

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


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final UserAchievement that = (UserAchievement) o;

        if (achievementId != null ? !achievementId.equals(that.achievementId) : that.achievementId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int myresult = id != null ? id.hashCode() : 0;
        myresult = 31 * myresult + (userId != null ? userId.hashCode() : 0);
        myresult = 31 * myresult + (achievementId != null ? achievementId.hashCode() : 0);
        return myresult;
    }
}
