package de.groupon.hcktn.groupong.model.dao.impl;

import de.groupon.hcktn.groupong.model.dao.StatusDAO;
import de.groupon.hcktn.groupong.model.entity.Status;
import de.groupon.hcktn.groupong.model.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StatusDAOImpl implements StatusDAO {


    @Override
    public Integer create(final Status status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(status);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
        return status.getId();
    }


    @Override
    public Status retrieve(final Integer statusId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Status status =  (Status) session.get(Status.class, statusId);
        session.close();
        HibernateUtil.shutdown();
        return status;
    }


    @Override
    public List<Status> retrieveAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query allQuery = session.createSQLQuery("SELECT * from status");
        List<Status> allStatuses = allQuery.list();
        session.close();
        HibernateUtil.shutdown();
        return allStatuses;
    }


    @Override
    public void update(final Status status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(status);
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
