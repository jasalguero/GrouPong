package de.groupon.hcktn.groupong.service.impl;

import de.groupon.hcktn.groupong.domain.response.UserDTO;
import de.groupon.hcktn.groupong.service.AvatarService;
import de.groupon.hcktn.groupong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AvatarService avatarService;

    //TODO: Remove this section
    final List<UserDTO> users = new LinkedList<UserDTO>();
    @PostConstruct
    public void init() {
        final UserDTO user = new UserDTO();
        user.setUserId(0);
        user.setUserName("bbednarek");
        user.setEmail("bbednarek@groupon.com");
        user.setAvatar(avatarService.fetchAvatars().get(0).getUrl());
        user.setScore(1000);
        users.add(user);

        final UserDTO user2 = new UserDTO();
        user2.setUserId(1);
        user2.setUserName("jsalguero");
        user2.setEmail("jsalguero@groupon.com");
        user2.setAvatar(avatarService.fetchAvatars().get(1).getUrl());
        user2.setScore(1200);
        users.add(user2);

        final UserDTO user3 = new UserDTO();
        user3.setUserId(2);
        user3.setUserName("zzabost");
        user3.setEmail("zzabost@groupon.com");
        user3.setAvatar(avatarService.fetchAvatars().get(2).getUrl());
        user3.setScore(800);
        users.add(user3);
    }

    @Override
    public Integer createUser(final UserDTO userDTO) {
        userDTO.setUserId(null);
        userDTO.setScore(1000);

        userDTO.setUserId(users.get(users.size() - 1).getUserId() + 1);
        users.add(userDTO);
        return userDTO.getUserId();
    }

    @Override
    public UserDTO fetchUser(final Integer userId) {
        for (UserDTO user : fetchUsers()) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<UserDTO> fetchUsers() {
        return users;
    }
}
