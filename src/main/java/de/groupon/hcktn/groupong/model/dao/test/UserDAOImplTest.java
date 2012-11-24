package de.groupon.hcktn.groupong.model.dao.test;

import de.groupon.hcktn.groupong.model.dao.UserDAO;
import de.groupon.hcktn.groupong.model.dao.impl.UserDAOImpl;
import de.groupon.hcktn.groupong.model.entity.User;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;

public class UserDAOImplTest {

    @Test
    public void testRetrieveAll() throws Exception {
        UserDAO userDao = new UserDAOImpl();

        User user1 = new User();
        user1.setEmail("test@test.test");
        user1.setPassword("testpass");
        user1.setUsername("test user name");
        user1.setAvatar("www.test.test");
        user1.setScore(1000);

        User user2 = new User();
        user2.setEmail("test@test.test");
        user2.setPassword("testpass");
        user2.setUsername("test user name");
        user2.setAvatar("www.test.test");
        user2.setScore(1000);

        userDao.create(user1);
        userDao.create(user2);

        final List<User> users = userDao.retrieveAll();

        assertTrue(users.size() >= 2);
        assertTrue(users.get(0) instanceof User);
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
    }
}
