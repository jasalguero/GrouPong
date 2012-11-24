package de.groupon.hcktn.groupong.service.impl;

import de.groupon.hcktn.groupong.model.dao.UserAchievementDAO;
import de.groupon.hcktn.groupong.service.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAchievementServiceImpl implements UserAchievementService {

    @Autowired
    private UserAchievementDAO userAchievementDAO;

    @Override
    public Integer fetchUserAchievementsByUserId(final Integer userId) {
//        userAchievementDAO.
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
