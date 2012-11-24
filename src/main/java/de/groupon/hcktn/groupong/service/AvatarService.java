package de.groupon.hcktn.groupong.service;

import de.groupon.hcktn.groupong.domain.response.AvatarDTO;

import java.util.List;

public interface AvatarService {

    List<AvatarDTO> fetchAvatars();
}
