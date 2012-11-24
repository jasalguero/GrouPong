package de.groupon.hcktn.groupong.model.dao.test;

import de.groupon.hcktn.groupong.model.dao.MatchDAO;
import de.groupon.hcktn.groupong.model.dao.impl.MatchDAOImpl;
import de.groupon.hcktn.groupong.model.entity.Match;
import org.junit.Test;

import java.util.Calendar;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

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

//
//
//    @Test
//    public void testReadAllStatuses() throws Exception {
//        Status status1 = new Status();
//        status1.setDescription("test status");
//        StatusDAO statusDao = new StatusDAOImpl();
//        statusDao.create(status1);
//
//        Status status2 = new Status();
//        status2.setDescription("test status");
//        statusDao = new StatusDAOImpl();
//        statusDao.create(status2);
//
//        final List<Status> retrievedAllStatuses = statusDao.retrieveAll();
//
//        assertTrue(retrievedAllStatuses.size()>=2);
//    }
//
//    @Test
//    public void testUpdateStatus() throws Exception {
//        Status status = new Status();
//        status.setDescription("test status");
//        StatusDAO statusDao = new StatusDAOImpl();
//        Integer id = statusDao.create(status);
//        final String myDescription = "new test status";
//        status.setDescription(myDescription);
//        statusDao.update(status);
//        final Status retrievedStatus = statusDao.retrieve(status.getId());
//        assertEquals(myDescription, retrievedStatus.getDescription());
//
//    }
//
//
//    @Test
//    public void testDeleteStatus() throws Exception {
//        Status status = new Status();
//        status.setDescription("test status to be deleted");
//        StatusDAO statusDao = new StatusDAOImpl();
//        final Integer id = statusDao.create(status);
//        statusDao.delete(id);
//        Status retrievedStatus = statusDao.retrieve(id);
//        assertNull(retrievedStatus);
//    }

}
