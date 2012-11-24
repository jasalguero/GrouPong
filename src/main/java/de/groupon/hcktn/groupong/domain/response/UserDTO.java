package de.groupon.hcktn.groupong.domain.response;

import de.groupon.config.web.annotation.JsonImplicit;

import java.util.ArrayList;
import java.util.List;

@JsonImplicit(UserDTO.class)
public class UserDTO {
    private Integer userId;
    private String userName;
    private String password;
    private String email;
    private String avatar;
    private Integer score;

    private List<AchievementDTO> achievements = new ArrayList<AchievementDTO>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<AchievementDTO> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<AchievementDTO> achievements) {
        this.achievements = achievements;
    }
}
