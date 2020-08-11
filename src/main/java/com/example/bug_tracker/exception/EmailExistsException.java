package com.example.bug_tracker.exception;

public class EmailExistsException extends Throwable {

    public EmailExistsException(final String message) {
        super(message);
    }
}
