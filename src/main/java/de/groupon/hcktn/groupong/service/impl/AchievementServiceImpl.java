package de.groupon.hcktn.groupong.service.impl;

import de.groupon.hcktn.groupong.domain.mappers.AchievementDTOMapper;
import de.groupon.hcktn.groupong.domain.response.AchievementDTO;
import de.groupon.hcktn.groupong.model.dao.AchievementDAO;
import de.groupon.hcktn.groupong.model.entity.Achievement;
import de.groupon.hcktn.groupong.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementDAO achievementDAO;

    @Autowired
    private AchievementDTOMapper achievementDTOMapper;

    @Override
    public List<AchievementDTO> fetchAchievements() {
        final List<AchievementDTO> achievementsDTO = new ArrayList<AchievementDTO>();
        final List<Achievement> achievements = achievementDAO.retrieveAll();
        for (Achievement achievement : achievements) {
            achievementsDTO.add(achievementDTOMapper.mapToAchievementDTO(achievement));
        }
        return achievementsDTO;
    }

}
