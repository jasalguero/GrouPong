package de.groupon.hcktn.groupong.model.dao.test;

import de.groupon.hcktn.groupong.model.dao.StatusDAO;
import de.groupon.hcktn.groupong.model.dao.impl.StatusDAOImpl;
import de.groupon.hcktn.groupong.model.entity.Status;
import org.junit.Test;

public class StatusDAOImplTest {

    @Test
    public void testCreateStatus() throws Exception {
        Status myStatus = new Status();
        myStatus.setDescription("test status");
        StatusDAO statusDao = new StatusDAOImpl();
        statusDao.createStatus(myStatus);
    }
}
