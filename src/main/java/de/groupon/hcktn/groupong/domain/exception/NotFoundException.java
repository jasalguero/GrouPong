package de.groupon.hcktn.groupong.domain.exception;

public class NotFoundException extends RuntimeException {

    private NotFoundException() {}

    public NotFoundException(String message) {
        super(message);
    }
}
