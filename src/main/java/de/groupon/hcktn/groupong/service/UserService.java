package de.groupon.hcktn.groupong.service;

import de.groupon.hcktn.groupong.domain.response.BaseDTO;
import de.groupon.hcktn.groupong.domain.response.UserDTO;

import java.util.List;

public interface UserService {

    BaseDTO createUser(UserDTO userDTO);

    UserDTO fetchUser(Integer userId);

    UserDTO fetchUser(String email, String password);

    List<UserDTO> fetchUsers();

}
