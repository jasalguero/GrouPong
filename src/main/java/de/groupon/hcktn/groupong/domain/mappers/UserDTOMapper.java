package de.groupon.hcktn.groupong.domain.mappers;

import de.groupon.hcktn.groupong.domain.response.MatchDTO;
import de.groupon.hcktn.groupong.domain.response.UserDTO;
import de.groupon.hcktn.groupong.model.entity.User;
import de.groupon.hcktn.groupong.service.MatchService;
import de.groupon.hcktn.groupong.service.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDTOMapper extends BaseDTOMapper {

    @Autowired
    private UserAchievementService userAchievementService;

    @Autowired
    private MatchService matchService;

    public UserDTO mapToUserDTO(final User user) {
        final UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setScore(user.getScore());
        userDTO.setAchievements(userAchievementService.fetchUserAchievementsByUserId(user.getId()));
        userDTO.setMatches(matchService.fetchMatchesByUserId(user.getId()));
        userDTO.setRank(getRank(user.getScore()));

        return userDTO;
    }

    public User mapToUser(final UserDTO userDTO) {
        return update(new User(), userDTO);
    }

    public User update(final User user, final UserDTO userDTO) {
        if (userDTO.getId() != null) {
            user.setId(userDTO.getId());
        }
        if (userDTO.getUserName() != null) {
            user.setUsername(userDTO.getUserName());
        }
        if (userDTO.getPassword() != null) {
            user.setPassword(userDTO.getPassword());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getAvatar() != null) {
            user.setAvatar(userDTO.getAvatar());
        }
        if (userDTO.getScore() != null) {
            user.setScore(userDTO.getScore());
        }
        return user;
    }

    private String getRank(Integer score) {
        if ( score < 1100) {
            return "Newbie";
        } else if (score < 1200) {
            return "Novice";
        } else if (score < 1300) {
            return "Amateur";
        } else if (score < 1400) {
            return "Pro";
        } else if (score < 1500) {
            return "Elite";
        } else {
            return "Master";
        }
    }
}
