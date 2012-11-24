package de.groupon.hcktn.groupong.model.dao;

import de.groupon.hcktn.groupong.model.entity.UserAchievement;

import java.util.List;

public interface UserAchievementDAO {
    public void createUserAchievement(final UserAchievement userAchievement);
    public UserAchievement readUserAchievement(final Integer userAchievementId);
    public List<UserAchievement> readAllUserAchievements();
    public void deleteUserAchievement(final Integer userAchievement);
    public void updateUserAchievement(final UserAchievement userAchievement);
}
