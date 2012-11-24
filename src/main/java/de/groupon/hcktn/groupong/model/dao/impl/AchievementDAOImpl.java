package de.groupon.hcktn.groupong.model.dao.impl;

import de.groupon.hcktn.groupong.model.dao.AchievementDAO;
import de.groupon.hcktn.groupong.model.entity.Achievement;
import de.groupon.hcktn.groupong.model.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AchievementDAOImpl implements AchievementDAO {

    @Override
    public Integer create(final Achievement achievement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(achievement);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
        return achievement.getId();
    }


    @Override
    public Achievement retrieve(final Integer achievementId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Achievement achievement =  (Achievement) session.get(Achievement.class, achievementId);
        session.close();
        HibernateUtil.shutdown();
        return achievement;
    }


    @Override
    public List<Achievement> retrieveAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query allQuery = session.createSQLQuery("SELECT * from achievement");
        List<Achievement> allAchievements = allQuery.list();
        session.close();
        HibernateUtil.shutdown();
        return allAchievements;
    }


    @Override
    public void update(final Achievement achievement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(achievement);
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
