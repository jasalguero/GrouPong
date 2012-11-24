package de.groupon.hcktn.groupong.model.dao.test;

import de.groupon.hcktn.groupong.model.dao.MatchDAO;
import de.groupon.hcktn.groupong.model.dao.impl.MatchDAOImpl;
import de.groupon.hcktn.groupong.model.entity.Match;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static junit.framework.Assert.*;

public class MatchDAOImplTest {


    @Test
    public void testCreateMatch() throws Exception {
        Match match = new Match();
        match.setUser1Id(1);
        match.setUser2Id(2);
        match.setScoreUser1(0);
        match.setScoreUser1(3);
        match.setMatchDate(Calendar.getInstance());
        match.setStatusId(1);

        MatchDAO matchDao = new MatchDAOImpl();
        Integer id = matchDao.create(match);

        assertNotNull(id);
    }

    @Test
    public void testCreateAndReadMatch() throws Exception {
        Match match = new Match();
        match.setUser1Id(1);
        match.setUser2Id(2);
        match.setScoreUser1(0);
        match.setScoreUser1(3);
        match.setMatchDate(Calendar.getInstance());
        match.setStatusId(1);

        MatchDAO matchDao = new MatchDAOImpl();
        Integer id = matchDao.create(match);

        Match retrievedMatch = matchDao.retrieve(id);
        assertEquals(match, retrievedMatch);
    }



    @Test
    public void testReadAllMatches() throws Exception {
        MatchDAO matchDao = new MatchDAOImpl();

        Match match1 = new Match();
        match1.setUser1Id(1);
        match1.setUser2Id(2);
        match1.setScoreUser1(0);
        match1.setScoreUser1(3);
        match1.setMatchDate(Calendar.getInstance());
        match1.setStatusId(1);
        matchDao.create(match1);

        Match match2 = new Match();
        match2.setUser1Id(2);
        match2.setUser2Id(3);
        match2.setScoreUser1(2);
        match2.setScoreUser1(1);
        match2.setMatchDate(Calendar.getInstance());
        match2.setStatusId(1);
        matchDao.create(match2);

        final List<Match> retrievedAllMatch = matchDao.retrieveAll();
        assertTrue(retrievedAllMatch.size()>=2);
    }

    @Test
    public void testUpdateMatch() throws Exception {
        MatchDAO matchDao = new MatchDAOImpl();
        Match match1 = new Match();
        match1.setUser1Id(1);
        match1.setUser2Id(2);
        match1.setScoreUser1(0);
        match1.setScoreUser1(3);
        match1.setMatchDate(Calendar.getInstance());
        match1.setStatusId(1);
        matchDao.create(match1);

        final int myStatusId = 3;
        match1.setStatusId(myStatusId);

        matchDao.update(match1);

        final Match retrievedMatch = matchDao.retrieve(match1.getId());
        assertTrue(myStatusId == retrievedMatch.getStatusId());

    }


    @Test
    public void testDeleteMatch() throws Exception {
        MatchDAO matchDao = new MatchDAOImpl();
        Match match1 = new Match();
        match1.setUser1Id(1);
        match1.setUser2Id(2);
        match1.setScoreUser1(0);
        match1.setScoreUser1(3);
        match1.setMatchDate(Calendar.getInstance());
        match1.setStatusId(1);
        final Integer id = matchDao.create(match1);
        matchDao.delete(id);
        Match retrievedMatches = matchDao.retrieve(id);
        assertNull(retrievedMatches);
    }

}
