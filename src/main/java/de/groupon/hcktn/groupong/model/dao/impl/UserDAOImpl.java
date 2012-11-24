package de.groupon.hcktn.groupong.model.dao.impl;

import de.groupon.hcktn.groupong.model.dao.UserDAO;
import de.groupon.hcktn.groupong.model.entity.User;
import de.groupon.hcktn.groupong.model.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
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
        List<Object[]> allUsers = allQuery.list();

        List<User> usersToReturn = new ArrayList<User>();
        for (Object[] o : allUsers) {
            User tempUser = new User();
            tempUser.setId((Integer) o[0]);
            tempUser.setEmail((String) o[1]);
            tempUser.setPassword((String) o[2]);
            tempUser.setUsername((String) o[3]);
            tempUser.setAvatar((String) o[4]);
            tempUser.setScore((Integer) o[5]);
            usersToReturn.add(tempUser);
        }
        session.close();
        HibernateUtil.shutdown();
        return usersToReturn;
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
