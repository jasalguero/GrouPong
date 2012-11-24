package de.groupon.hcktn.groupong.service;

import de.groupon.hcktn.groupong.domain.response.AchievementDTO;

import java.util.List;

public interface AchievementService {

    List<AchievementDTO> fetchAchievements();

}
