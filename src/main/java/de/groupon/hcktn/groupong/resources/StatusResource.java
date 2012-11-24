package de.groupon.hcktn.groupong.resources;

import de.groupon.hcktn.groupong.domain.response.StatusDTO;
import de.groupon.hcktn.groupong.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/groupong")
public class StatusResource {

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/statuses", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    @ResponseBody
    public List<StatusDTO> fetchStatuses() {
        return statusService.fetchStatuses();
    }
}
