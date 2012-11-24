package de.groupon.hcktn.groupong.service.impl;

import de.groupon.hcktn.groupong.model.entity.Status;
import de.groupon.hcktn.groupong.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Override
    public List<Status> fetchStatuses() {
        final List<Status> statuses = new ArrayList<Status>();
        statuses.add(new Status(0, "CREATED"));
        statuses.add(new Status(1, "ACCEPTED"));
        statuses.add(new Status(2, "REFUSED"));
        statuses.add(new Status(3, "CONFIRMED_USER1"));
        statuses.add(new Status(4, "CONFIRMED_USER2"));
        statuses.add(new Status(5, "FINISHED"));
        return statuses;
    }

    @Override
    public Status fetchStatus(Integer statusId) {
        for (Status status : fetchStatuses()) {
            if (status.getId().equals(statusId)) {
                return status;
            }
        }
        return null;
    }

    @Override
    public Status fetchStatus(String description) {
        for (Status status : fetchStatuses()) {
            if (status.getDescription().equals(description)) {
                return status;
            }
        }
        return null;
    }


}
