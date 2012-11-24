package de.groupon.hcktn.groupong.model.dao.impl;

import de.groupon.hcktn.groupong.model.dao.AchievementDAO;
import de.groupon.hcktn.groupong.model.entity.Achievement;
import de.groupon.hcktn.groupong.model.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AchievementDAOImpl implements AchievementDAO {

    @Override
    public Achievement create(final Achievement achievement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(achievement);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
        return achievement;
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
        List<Achievement> achievementsToReturn = new ArrayList<Achievement>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query allQuery = session.createSQLQuery("SELECT * from achievement");
        try {
            List<Object[]> allAchievement = allQuery.list();
            for (Object[] o : allAchievement) {
                Achievement tempAchievement = new Achievement();
                tempAchievement.setId((Integer) o[0]);
                tempAchievement.setTitle((String) o[1]);
                tempAchievement.setDescription((String) o[2]);
                achievementsToReturn.add(tempAchievement);
            }
        } finally {
            session.close();
            try {
                HibernateUtil.shutdown();
            } catch (Exception e) {
                // nothing here, SQLite sux!
            }
            return achievementsToReturn;
        }
    }


    @Override
    public Achievement update(final Achievement achievement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(achievement);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
        return achievement;
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
