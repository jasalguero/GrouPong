package de.groupon.hcktn.groupong.model.dao.impl;

import de.groupon.hcktn.groupong.model.dao.MatchDAO;
import de.groupon.hcktn.groupong.model.entity.Match;
import de.groupon.hcktn.groupong.model.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class MatchDAOImpl implements MatchDAO {

    @Override
    public Integer create(final Match match) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(match);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
        return match.getId();
    }


    @Override
    public Match retrieve(final Integer matchId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Match achievement =  (Match) session.get(Match.class, matchId);
        session.close();
        HibernateUtil.shutdown();
        return achievement;
    }


    @Override
    public List<Match> retrieveAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query allQuery = session.createSQLQuery("SELECT * from game");
        List<Match> allMatches = allQuery.list();
        session.close();
        HibernateUtil.shutdown();
        return allMatches;
    }


    @Override
    public void update(final Match match) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(match);
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
