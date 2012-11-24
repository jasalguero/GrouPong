package de.groupon.hcktn.groupong.resources;

import de.groupon.hcktn.groupong.domain.response.UserDTO;
import de.groupon.hcktn.groupong.service.UserService;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/groupong")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Integer createUser(@RequestBody final UserDTO user, HttpServletRequest request) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    @ResponseBody
    public UserDTO fetchUser(@PathVariable final Integer userId) {
        return userService.fetchUser(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    @ResponseBody
    public UserDTO fetchUser(
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password", required = true) String password
            ) {
        return userService.fetchUser(email, password);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    @ResponseBody
    public List<UserDTO> fetchUsers() {
        return userService.fetchUsers();
    }

}
