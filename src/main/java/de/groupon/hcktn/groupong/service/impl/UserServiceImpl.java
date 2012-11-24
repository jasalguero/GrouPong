package de.groupon.hcktn.groupong.service.impl;

import de.groupon.hcktn.groupong.domain.mappers.UserDTOMapper;
import de.groupon.hcktn.groupong.domain.response.BaseDTO;
import de.groupon.hcktn.groupong.domain.response.UserDTO;
import de.groupon.hcktn.groupong.model.dao.UserDAO;
import de.groupon.hcktn.groupong.model.entity.User;
import de.groupon.hcktn.groupong.service.AvatarService;
import de.groupon.hcktn.groupong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserDTOMapper userDTOMapper;

    @Override
    public BaseDTO createUser(final UserDTO userDTO) {
        userDTO.setId(null);
        User user = userDTOMapper.mapToUser(userDTO);
        user = userDAO.create(user);
        return userDTOMapper.mapToUserDTO(user);
    }

    @Override
    public UserDTO fetchUser(final Integer userId) {
        for (UserDTO user : fetchUsers()) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public UserDTO fetchUser(final String email, final String password) {
        for (UserDTO user : fetchUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<UserDTO> fetchUsers() {
        final List<UserDTO> usersDTO = new ArrayList<UserDTO>();
        final List<User> users = userDAO.retrieveAll();
        for (User user : users) {
            usersDTO.add(userDTOMapper.mapToUserDTO(user));
        }
        return usersDTO;
    }
}
