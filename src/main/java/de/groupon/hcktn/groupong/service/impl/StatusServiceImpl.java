package de.groupon.hcktn.groupong.service.impl;

import de.groupon.hcktn.groupong.domain.response.StatusDTO;
import de.groupon.hcktn.groupong.model.dao.StatusDAO;
import de.groupon.hcktn.groupong.model.entity.Status;
import de.groupon.hcktn.groupong.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusDAO statusDAO;

    @Override
    public List<StatusDTO> fetchStatuses() {
//        final List<StatusDTO> statusesDTO = new ArrayList<StatusDTO>();
//        final List<Status> statuses = statusDAO.retrieveAll();
//        for (Status status : statuses) {
//            statusesDTO.add(new StatusDTO(status));
//        }
//        return statusesDTO;

        final List<StatusDTO> statuses = new ArrayList<StatusDTO>();
        statuses.add(new StatusDTO(0, "CREATED"));
        statuses.add(new StatusDTO(1, "ACCEPTED"));
        statuses.add(new StatusDTO(2, "REFUSED"));
        statuses.add(new StatusDTO(3, "CONFIRMED_USER1"));
        statuses.add(new StatusDTO(4, "CONFIRMED_USER2"));
        statuses.add(new StatusDTO(5, "FINISHED"));
        return statuses;
    }

    @Override
    public StatusDTO fetchStatus(Integer statusId) {
        for (StatusDTO statusDTO : fetchStatuses()) {
            if (statusDTO.getId().equals(statusId)) {
                return statusDTO;
            }
        }
        return null;
    }

    @Override
    public StatusDTO fetchStatus(String description) {
        for (StatusDTO statusDTO : fetchStatuses()) {
            if (statusDTO.getDescription().equals(description)) {
                return statusDTO;
            }
        }
        return null;
    }


}
