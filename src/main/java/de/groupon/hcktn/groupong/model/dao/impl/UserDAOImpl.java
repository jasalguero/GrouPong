package de.groupon.hcktn.groupong.model.dao.impl;

import de.groupon.hcktn.groupong.model.dao.UserDAO;
import de.groupon.hcktn.groupong.model.entity.User;
import de.groupon.hcktn.groupong.model.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public Integer create(final User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
        return user.getId();
    }


    @Override
    public User retrieve(final Integer userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User userAchievement =  (User) session.get(User.class, userId);
        session.close();
        HibernateUtil.shutdown();
        return userAchievement;
    }


    @Override
    public List<User> retrieveAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query allQuery = session.createSQLQuery("SELECT * from user");
        List<User> allUsers = allQuery.list();
        session.close();
        HibernateUtil.shutdown();
        return allUsers;
    }


    @Override
    public void update(final User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
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
