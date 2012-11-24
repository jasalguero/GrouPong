package de.groupon.hcktn.groupong.resources;

import de.groupon.hcktn.groupong.domain.exception.BadRequestException;
import de.groupon.hcktn.groupong.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseResource {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleBadRequestException(final BadRequestException badRequestException) {
        return badRequestException.getMessage();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleNotFoundException(final NotFoundException notFoundException) {
        return notFoundException.getMessage();
    }
}
