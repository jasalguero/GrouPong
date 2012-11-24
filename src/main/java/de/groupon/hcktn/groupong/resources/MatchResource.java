package de.groupon.hcktn.groupong.resources;

import de.groupon.hcktn.groupong.domain.exception.BadRequestException;
import de.groupon.hcktn.groupong.domain.response.BaseDTO;
import de.groupon.hcktn.groupong.domain.response.MatchDTO;
import de.groupon.hcktn.groupong.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.resource.ResourceException;
import java.util.List;

@Controller
@RequestMapping("/groupong")
public class MatchResource extends BaseResource {

    @Autowired
    private MatchService matchService;

    @RequestMapping(value = "/match", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    @ResponseBody
    public List<MatchDTO> fetchMatches(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "statusId", required = false) Integer statusId
            ) {
        if (userId != null && statusId != null) {
            return matchService.fetchMatchesByUserIdStatusId(userId, statusId);
        } else if (userId != null) {
            return matchService.fetchMatchesByUserId(userId);
        } else if (statusId != null) {
            return matchService.fetchMatchesByStatusId(statusId);
        } else {
            return matchService.fetchMatches();
        }
    }

    @RequestMapping(value = "/match", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public BaseDTO createMatch(@RequestBody final MatchDTO match) {
        return matchService.createMatch(match);
    }

    @RequestMapping(value = "/match", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public BaseDTO updateMatch(@RequestBody final MatchDTO match) throws ResourceException {
        if (match.getId() == null) {
            throw new BadRequestException("match id is null");
        }
        return matchService.updateMatch(match);
    }

}
