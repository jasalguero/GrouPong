package de.groupon.hcktn.groupong.model.dao;

import de.groupon.hcktn.groupong.model.entity.Status;

import java.util.List;

public interface StatusDAO {
    public void createStatus(final Status status);
    public Status readStatus(final Integer statusId);
    public List<Status> readAllStatues();
    public void deleteStatus(final Integer statusId);
    public void updateStatus(final Status status);
}
