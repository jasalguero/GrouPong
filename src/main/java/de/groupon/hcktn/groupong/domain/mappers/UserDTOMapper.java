package de.groupon.hcktn.groupong.domain.mappers;

import de.groupon.hcktn.groupong.domain.response.UserDTO;
import de.groupon.hcktn.groupong.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper extends BaseDTOMapper {

    public UserDTO mapToUserDTO(final User user) {
        final UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setScore(user.getScore());
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
}
