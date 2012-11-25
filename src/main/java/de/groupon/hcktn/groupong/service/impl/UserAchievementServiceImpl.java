package de.groupon.hcktn.groupong.service.impl;

import de.groupon.hcktn.groupong.achievements.Achievement;
import de.groupon.hcktn.groupong.achievements.FirstBloodAchievement;
import de.groupon.hcktn.groupong.domain.response.MatchDTO;
import de.groupon.hcktn.groupong.model.dao.UserAchievementDAO;
import de.groupon.hcktn.groupong.model.dao.UserDAO;
import de.groupon.hcktn.groupong.model.entity.Match;
import de.groupon.hcktn.groupong.model.entity.User;
import de.groupon.hcktn.groupong.model.entity.UserAchievement;
import de.groupon.hcktn.groupong.service.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAchievementServiceImpl implements UserAchievementService {

    @Autowired
    private UserAchievementDAO userAchievementDAO;

    @Autowired
    @Qualifier(value = "firstBloodAchievement")
    private Achievement firstBloodAchievement;





    @Autowired
    @Qualifier(value = "twoInARowAchievement")
    private Achievement twoInARowAchievement;



    @Override
    public void processUserAchievements(Match match, MatchDTO matchDTO) {
        // if we change from Confirmed user1 / Confirmed user 2 => Finished
        if ( (match.getStatusId() == 4 || match.getStatusId() == 5) && matchDTO.getStatusId() == 6 ) {
            final List<Achievement> achievements = getAllAchievements();
            if (match.getUser1Id() != null && match.getUser2Id() != null) {
                User user1 = userDAO.retrieve(match.getUser1Id());
                User user2 = userDAO.retrieve(match.getUser2Id());

                for (Achievement achievement : achievements) {

                    if (achievement.isAchieved(user1, match)) {
                        // add achievement to user 1 if he doesn't have it yet
                        updateUserAchievements(user1, achievement);
                    }

                    if (achievement.isAchieved(user2, match)) {
                        // add achievement to user 2 if he doesn't have it yet
                        updateUserAchievements(user2, achievement);
                    }
                }
            }
        }
    }

    private void updateUserAchievements(User user, Achievement achievement) {
        // add achievement to user  if he doesn't have it yet
        List<UserAchievement> currentUserAchievements = userAchievementDAO.retrieveByUserId(user.getId());
        boolean hasAlreadyThisAchivement = false;
        for (UserAchievement currentAchievement : currentUserAchievements) {
            if (currentAchievement.getAchievementId().equals(achievement.getId())) {
                hasAlreadyThisAchivement = true;
                break;
            }
        }
        if(!hasAlreadyThisAchivement) {
            UserAchievement userAchievement = new UserAchievement();
            userAchievement.setAchievementId(achievement.getId());
            userAchievement.setUserId(user.getId());
            userAchievementDAO.create(userAchievement);
        }
    }

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<Integer> fetchUserAchievementsByUserId(final Integer userId) {
        final List<Integer> achievementsIds = new ArrayList<Integer>();
        final List<UserAchievement> userAchievements = userAchievementDAO.retrieveByUserId(userId);
        if (userAchievements != null) {
            for (UserAchievement userAchievement : userAchievements) {
                achievementsIds.add(userAchievement.getAchievementId());
            }
        }
        return achievementsIds;
    }

    private List<Achievement> getAllAchievements() {
        final List<Achievement> achievements = new ArrayList<Achievement>();
        achievements.add(firstBloodAchievement);

        achievements.add(twoInARowAchievement);
        return achievements;
    }


}
