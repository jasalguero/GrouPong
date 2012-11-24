package de.groupon.hcktn.groupong.service;

import de.groupon.hcktn.groupong.model.entity.Status;

import java.util.List;

public interface StatusService {

    List<Status> fetchStatuses();

    Status fetchStatus(Integer statusId);

    Status fetchStatus(String statusDescription);

}
