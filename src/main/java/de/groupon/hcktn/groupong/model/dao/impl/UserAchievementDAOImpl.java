package de.groupon.hcktn.groupong.model.dao.impl;

import de.groupon.hcktn.groupong.model.dao.UserAchievementDAO;
import de.groupon.hcktn.groupong.model.entity.UserAchievement;
import de.groupon.hcktn.groupong.model.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserAchievementDAOImpl implements UserAchievementDAO {

    @Override
    public Integer create(final UserAchievement userAchievement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(userAchievement);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
        return userAchievement.getId();
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
        List<UserAchievement> allUserAchievements = allQuery.list();
        session.close();
        HibernateUtil.shutdown();
        return allUserAchievements;
    }


    @Override
    public void update(final UserAchievement userAchievement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(userAchievement);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
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
}
