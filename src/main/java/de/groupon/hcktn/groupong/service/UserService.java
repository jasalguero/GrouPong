package de.groupon.hcktn.groupong.service;

import de.groupon.hcktn.groupong.domain.response.UserDTO;

import java.util.List;

public interface UserService {

    Integer createUser(UserDTO userDTO);

    UserDTO fetchUser(Integer userId);

    List<UserDTO> fetchUsers();

}
