package de.groupon.hcktn.groupong.resources;

import de.groupon.hcktn.groupong.domain.response.MatchDTO;
import de.groupon.hcktn.groupong.service.NewMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping("/groupong")
public class NewMatchResource extends BaseResource {

    @Autowired
    private NewMatchService newMatchService;

    @RequestMapping(value = "/newmatch", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    @ResponseBody
    public Set<MatchDTO> newMatches(
            @RequestParam(value = "userId", required = false) Integer userId
    ) {
        return newMatchService.fetchNewMatches(userId);
    }
}
