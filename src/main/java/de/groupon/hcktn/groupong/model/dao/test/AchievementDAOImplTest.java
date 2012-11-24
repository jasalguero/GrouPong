package de.groupon.hcktn.groupong.model.dao.test;

import de.groupon.hcktn.groupong.model.dao.AchievementDAO;
import de.groupon.hcktn.groupong.model.dao.impl.AchievementDAOImpl;
import de.groupon.hcktn.groupong.model.entity.Achievement;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;

public class AchievementDAOImplTest {

    @Test
    public void testRetrieveAll() throws Exception {
        AchievementDAO achivDao = new AchievementDAOImpl();

        Achievement a1 = new Achievement();
        a1.setTitle("test title");
        a1.setDescription("test descript");
        achivDao.create(a1);

        Achievement a2 = new Achievement();
        a2.setTitle("test title");
        a2.setDescription("test descript");
        achivDao.create(a2);

        final List<Achievement> retrievedAllAchiv = achivDao.retrieveAll();

        assertTrue(retrievedAllAchiv.size()>=2);
        assertTrue(retrievedAllAchiv.get(0) instanceof Achievement);
        assertTrue(retrievedAllAchiv.contains(a1));
        assertTrue(retrievedAllAchiv.contains(a2));
    }
}
