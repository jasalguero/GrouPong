package de.groupon.hcktn.groupong.resources;

import de.citydeal.backend.core.BackendServiceException;
import de.groupon.config.web.exception.DomainException;
import de.groupon.hcktn.groupong.domain.Avatars;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller("avatarResource")
@RequestMapping("groupong")
public class AvatarResource {

    @RequestMapping(value = "avatars", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    @ResponseBody
    public Avatars getAvatars() {
        final Avatars avatars = new Avatars();

        final List<String> urls = new LinkedList<String>();
        urls.add("http://www.avatarsdb.com/avatars/acrobat.gif");
        urls.add("http://www.avatarsdb.com/avatars/acrobat.gif");
        urls.add("http://www.avatarsdb.com/avatars/acrobat.gif");
        urls.add("http://www.avatarsdb.com/avatars/acrobat.gif");
        urls.add("http://www.avatarsdb.com/avatars/acrobat.gif");
        avatars.setUrls(urls);

        return avatars;
    }
}
