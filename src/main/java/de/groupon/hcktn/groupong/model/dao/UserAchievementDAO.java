package de.groupon.hcktn.groupong.model.dao;

import de.groupon.hcktn.groupong.model.entity.UserAchievement;

import java.util.List;

public interface UserAchievementDAO extends DAO<UserAchievement>{

    List<UserAchievement> retrieveByUserId(Integer userId);

}
