package de.groupon.hcktn.groupong.resources;

import de.groupon.hcktn.groupong.domain.response.AvatarDTO;
import de.groupon.hcktn.groupong.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("avatarResource")
@RequestMapping("groupong")
public class AvatarResource {

    @Autowired
    AvatarService avatarService;

    @RequestMapping(value = "avatars", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    @ResponseBody
    public List<AvatarDTO> getAvatars() {
        return avatarService.fetchAvatars();
    }
}
