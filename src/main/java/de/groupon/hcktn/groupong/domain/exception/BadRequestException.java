package de.groupon.hcktn.groupong.domain.exception;

public class BadRequestException extends RuntimeException {

    private BadRequestException() {}

    public BadRequestException(String message) {
        super(message);
    }

}
