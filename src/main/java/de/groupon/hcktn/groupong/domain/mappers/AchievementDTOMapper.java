package de.groupon.hcktn.groupong.domain.mappers;

import de.groupon.hcktn.groupong.domain.response.AchievementDTO;
import de.groupon.hcktn.groupong.model.entity.Achievement;
import org.springframework.stereotype.Component;

@Component
public class AchievementDTOMapper extends BaseDTOMapper {

    public AchievementDTO mapToAchievementDTO(final Achievement achievement) {
        final AchievementDTO achievementDTO = new AchievementDTO();
        achievementDTO.setId(achievement.getId());
        achievementDTO.setTitle(achievement.getTitle());
        achievementDTO.setDescription(achievement.getDescription());
        return achievementDTO;
    }

}
