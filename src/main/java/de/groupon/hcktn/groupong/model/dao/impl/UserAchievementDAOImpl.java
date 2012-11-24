package de.groupon.hcktn.groupong.model.dao.impl;

import de.groupon.hcktn.groupong.model.dao.UserAchievementDAO;
import de.groupon.hcktn.groupong.model.entity.UserAchievement;
import de.groupon.hcktn.groupong.model.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserAchievementDAOImpl implements UserAchievementDAO {

    @Override
    public UserAchievement create(final UserAchievement userAchievement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(userAchievement);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
        return userAchievement;
    }


    @Override
    public UserAchievement retrieve(final Integer userAchievementId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UserAchievement userAchievement =  (UserAchievement) session.get(UserAchievement.class, userAchievementId);
        session.close();
        HibernateUtil.shutdown();
        return userAchievement;
    }


    @Override
    public List<UserAchievement> retrieveAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query allQuery = session.createSQLQuery("SELECT * from user_achievement");
        List<Object[]> allUserAchievement = allQuery.list();

        List<UserAchievement> userAchievementToReturn = new ArrayList<UserAchievement>();
        for (Object[] o : allUserAchievement) {
            UserAchievement tempUserAchievement = new UserAchievement();
            tempUserAchievement.setId((Integer) o[0]);
            tempUserAchievement.setUserId((Integer) o[1]);
            tempUserAchievement.setAchievementId((Integer) o[2]);
            userAchievementToReturn.add(tempUserAchievement);
        }
        session.close();
        HibernateUtil.shutdown();
        return userAchievementToReturn;
    }


    @Override
    public UserAchievement update(final UserAchievement userAchievement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(userAchievement);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
        return userAchievement;
    }


    @Override
    public void delete(final Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(retrieve(id));
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
    }

    @Override
    public List<UserAchievement> retrieveByUserId(Integer userId) {
        List<UserAchievement> userAchievementToReturn = new ArrayList<UserAchievement>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query allQuery = session.createSQLQuery("select * from user_achievement where user_id=" + userId);
        try {

            List<Object[]> allUserAchievement = allQuery.list();
            for (Object[] o : allUserAchievement) {
                UserAchievement tempUserAchievement = new UserAchievement();
                tempUserAchievement.setId((Integer) o[0]);
                tempUserAchievement.setUserId((Integer) o[1]);
                tempUserAchievement.setAchievementId((Integer) o[2]);
                userAchievementToReturn.add(tempUserAchievement);
            }
        } finally {
            session.close();
            try {
                HibernateUtil.shutdown();
            } catch (Exception e) {
                // nothing here, SQLite sux!
            }
            return userAchievementToReturn;
        }
    }
}
