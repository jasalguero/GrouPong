package de.groupon.hcktn.groupong.model.dao.impl;

import de.groupon.hcktn.groupong.model.dao.MatchDAO;
import de.groupon.hcktn.groupong.model.entity.Match;
import de.groupon.hcktn.groupong.model.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class MatchDAOImpl implements MatchDAO {

    @Override
    public Match create(final Match match) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(match);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
        return match;
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
        List<Match> matchesToReturn = new ArrayList<Match>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query allQuery = session.createSQLQuery("SELECT * from game");
        try {
            List<Object[]> allMatches = allQuery.list();
            for (Object[] o : allMatches) {
                Match tempMatch = new Match();
                tempMatch.setId((Integer) o[0]);
                tempMatch.setUser1Id((Integer) o[1]);
                tempMatch.setUser2Id((Integer) o[2]);
                tempMatch.setScoreUser1((Integer) o[3]);
                tempMatch.setScoreUser2((Integer) o[4]);
                tempMatch.setMatchDate((String) o[5]);
                tempMatch.setStatusId((Integer) o[6]);
                matchesToReturn.add(tempMatch);
            }
        } finally {
            session.close();
            try {
                HibernateUtil.shutdown();
            } catch (Exception e) {
                // nothing here, SQLite sux!
            }
            return matchesToReturn;
        }
    }


    @Override
    public Match update(final Match match) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(match);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
        return match;
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
