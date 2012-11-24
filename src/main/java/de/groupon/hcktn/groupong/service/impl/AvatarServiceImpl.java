package de.groupon.hcktn.groupong.service.impl;

import de.groupon.hcktn.groupong.domain.response.AvatarDTO;
import de.groupon.hcktn.groupong.service.AvatarService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AvatarServiceImpl implements AvatarService{

    @Override
    public List<AvatarDTO> fetchAvatars() {
        final List<AvatarDTO> avatars = new LinkedList<AvatarDTO>();

        avatars.add(new AvatarDTO(0, "images/avatars/assassin_avatar.png"));
        avatars.add(new AvatarDTO(1, "images/avatars/commissar_avatar.png"));
        avatars.add(new AvatarDTO(2, "images/avatars/dad_avatar.png"));
        avatars.add(new AvatarDTO(3, "images/avatars/designer_avatar.png"));
        avatars.add(new AvatarDTO(4, "images/avatars/diver_avatar.png"));
        avatars.add(new AvatarDTO(5, "images/avatars/engineer_avatar.png"));
        avatars.add(new AvatarDTO(6, "images/avatars/fireman_avatar.png"));
        avatars.add(new AvatarDTO(7, "images/avatars/mom_avatar.png"));
        avatars.add(new AvatarDTO(8, "images/avatars/nurse_avatar.png"));
        avatars.add(new AvatarDTO(9, "images/avatars/witch_avatar.png"));

        return avatars;
    }
}
