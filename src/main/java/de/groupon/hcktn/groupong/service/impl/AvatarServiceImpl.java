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

        avatars.add(new AvatarDTO("http://www.avatarsdb.com/avatars/acrobat.gif"));
        avatars.add(new AvatarDTO("http://www.avatarsdb.com/avatars/pc_user.gif"));
        avatars.add(new AvatarDTO("http://www.avatarsdb.com/avatars/cat_piano.gif"));
        avatars.add(new AvatarDTO("http://www.avatarsdb.com/avatars/dilemma_HH.jpg"));

        return avatars;
    }
}
