package de.groupon.hcktn.groupong.service.impl;

import de.groupon.hcktn.groupong.domain.response.UserDTO;
import de.groupon.hcktn.groupong.service.AvatarService;
import de.groupon.hcktn.groupong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AvatarService avatarService;

    @Override
    public Integer createUser(final UserDTO userDTO) {
        return 0;
    }

    @Override
    public UserDTO fetchUser(final Integer userId) {
        final UserDTO user = new UserDTO();
        user.setUserId(0);
        user.setUserName("n3on");
        user.setEmail("bbednarek@groupon.com");
        user.setAvatar(avatarService.fetchAvatars().get(0).getUrl());
        user.setScore(1000);
        return user;
    }

    @Override
    public List<UserDTO> fetchUsers() {
        final List<UserDTO> users = new LinkedList<UserDTO>();

        final UserDTO user = new UserDTO();
        user.setUserId(0);
        user.setUserName("bbednarek");
        user.setEmail("bbednarek@groupon.com");
        user.setAvatar(avatarService.fetchAvatars().get(0).getUrl());
        user.setScore(1000);
        users.add(user);

        final UserDTO user2 = new UserDTO();
        user2.setUserId(0);
        user2.setUserName("jsalguero");
        user2.setEmail("jsalguero@groupon.com");
        user2.setAvatar(avatarService.fetchAvatars().get(1).getUrl());
        user2.setScore(1200);
        users.add(user2);

        final UserDTO user3 = new UserDTO();
        user3.setUserId(0);
        user3.setUserName("zzabost");
        user3.setEmail("zzabost@groupon.com");
        user3.setAvatar(avatarService.fetchAvatars().get(2).getUrl());
        user3.setScore(800);
        users.add(user3);

        return users;
    }
}
