package de.groupon.hcktn.groupong.model.dao.impl;

import de.groupon.hcktn.groupong.model.dao.StatusDAO;
import de.groupon.hcktn.groupong.model.entity.Status;
import de.groupon.hcktn.groupong.model.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
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
        Query allQuery = session.createSQLQuery("SELECT * from status");
        List<Object[]> allStatuses = allQuery.list();

        List<Status> statusesToReturn = new ArrayList<Status>();
        for (Object[] o : allStatuses) {
            Status tempStatus = new Status();
            tempStatus.setId((Integer) o[0]);
            tempStatus.setDescription((String) o[1]);
            statusesToReturn.add(tempStatus);
        }
        session.close();
        HibernateUtil.shutdown();
        return statusesToReturn;
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
