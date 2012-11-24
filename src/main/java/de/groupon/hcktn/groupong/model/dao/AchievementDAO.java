package de.groupon.hcktn.groupong.model.dao;

import de.groupon.hcktn.groupong.model.entity.Achievement;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 11/24/12
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public interface AchievementDAO {
    public void createAchievement(final Achievement achievement);
    public Achievement readAchievement(final Integer achievementId);
    public List<Achievement> readAllAchievements();
    public void deleteAchievement(final Integer achievementId);
    public void updateAchievement(final Achievement achievement);
}
