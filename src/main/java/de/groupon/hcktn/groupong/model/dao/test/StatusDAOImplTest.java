package de.groupon.hcktn.groupong.model.dao.test;

import de.groupon.hcktn.groupong.model.dao.StatusDAO;
import de.groupon.hcktn.groupong.model.dao.impl.StatusDAOImpl;
import de.groupon.hcktn.groupong.model.entity.Status;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

public class StatusDAOImplTest {

    @Test
    public void testCreateStatus() throws Exception {
        Status status = new Status();
        status.setDescription("test status");
        StatusDAO statusDao = new StatusDAOImpl();
        Integer id = statusDao.create(status);
        assertNotNull(id);
    }

    @Test
    public void testCreateAndReadStatus() throws Exception {
        Status status = new Status();
        status.setDescription("test status");
        StatusDAO statusDao = new StatusDAOImpl();
        Integer id = statusDao.create(status);
        final Status retrievedStatus = statusDao.retrieve(id);
        assertEquals(status, retrievedStatus);
    }


    @Test
    public void testReadAllStatuses() throws Exception {
        Status status1 = new Status();
        status1.setDescription("test status");
        StatusDAO statusDao = new StatusDAOImpl();
        statusDao.create(status1);

        Status status2 = new Status();
        status2.setDescription("test status");
        statusDao = new StatusDAOImpl();
        statusDao.create(status2);

        final List<Status> retrievedAllStatuses = statusDao.retrieveAll();

        assertTrue(retrievedAllStatuses.size()>=2);
        assertTrue(retrievedAllStatuses.get(0) instanceof Status);

        List<Status> allStatus = statusDao.retrieveAll();
        assertTrue(allStatus.contains(status1));
        assertTrue(allStatus.contains(status2));
    }

    @Test
    public void testUpdateStatus() throws Exception {
        Status status = new Status();
        status.setDescription("test status");
        StatusDAO statusDao = new StatusDAOImpl();
        Integer id = statusDao.create(status);
        final String myDescription = "new test status";
        status.setDescription(myDescription);
        statusDao.update(status);
        final Status retrievedStatus = statusDao.retrieve(status.getId());
        assertEquals(myDescription, retrievedStatus.getDescription());
    }


    @Test
    public void testDeleteStatus() throws Exception {
        Status status = new Status();
        status.setDescription("test status to be deleted");
        StatusDAO statusDao = new StatusDAOImpl();
        final Integer id = statusDao.create(status);
        statusDao.delete(id);
        Status retrievedStatus = statusDao.retrieve(id);
        assertNull(retrievedStatus);
    }

}
