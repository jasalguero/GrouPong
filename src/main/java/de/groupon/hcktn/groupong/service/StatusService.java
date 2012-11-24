package de.groupon.hcktn.groupong.service;

import de.groupon.hcktn.groupong.domain.response.StatusDTO;

import java.util.List;

public interface StatusService {

    List<StatusDTO> fetchStatuses();

    StatusDTO fetchStatus(Integer statusId);

    StatusDTO fetchStatus(String statusDescription);

}
