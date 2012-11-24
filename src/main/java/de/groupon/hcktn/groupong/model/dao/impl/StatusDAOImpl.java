package de.groupon.hcktn.groupong.model.dao.impl;

import de.groupon.hcktn.groupong.model.dao.StatusDAO;
import de.groupon.hcktn.groupong.model.entity.Status;
import de.groupon.hcktn.groupong.model.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StatusDAOImpl implements StatusDAO {

    @Override
    public void createStatus(final Status status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(status);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
    }


    @Override
    public Status readStatus(final Integer statusId) {
        return null;
    }


    @Override
    public List<Status> readAllStatues() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public void deleteStatus(final Integer statusId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public void updateStatus(final Status status) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
