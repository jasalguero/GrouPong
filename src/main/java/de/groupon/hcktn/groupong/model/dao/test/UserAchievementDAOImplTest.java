package de.groupon.hcktn.groupong.model.dao.test;

import de.groupon.hcktn.groupong.model.dao.UserAchievementDAO;
import de.groupon.hcktn.groupong.model.dao.impl.UserAchievementDAOImpl;
import de.groupon.hcktn.groupong.model.entity.UserAchievement;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;

public class UserAchievementDAOImplTest {

    @Test
    public void testRetrieveAll() throws Exception {
        UserAchievementDAO userAchivDao = new UserAchievementDAOImpl();

        UserAchievement ua1 = new UserAchievement();
        ua1.setUserId(1);
        ua1.setAchievementId(1);
        userAchivDao.create(ua1);

        UserAchievement ua2 = new UserAchievement();
        ua2.setUserId(1);
        ua2.setAchievementId(1);
        userAchivDao.create(ua2);

        final List<UserAchievement> retrievedAllUserAchiv = userAchivDao.retrieveAll();

        assertTrue(retrievedAllUserAchiv.size()>=2);
        assertTrue(retrievedAllUserAchiv.get(0) instanceof UserAchievement);
        assertTrue(retrievedAllUserAchiv.contains(ua1));
        assertTrue(retrievedAllUserAchiv.contains(ua2));
    }

    @Test
    public void testRetrieveByUserId() {
        UserAchievementDAO userAchivDao = new UserAchievementDAOImpl();
        for (int userId=0; userId<=6; userId++) {
            final List<UserAchievement> retrievedUserAchiv = userAchivDao.retrieveByUserId(userId);
            for(UserAchievement ua : retrievedUserAchiv) {
                assertTrue(userId==ua.getUserId());
            }
        }
    }

}
