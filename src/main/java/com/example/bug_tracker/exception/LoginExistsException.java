package com.example.bug_tracker.exception;

public class LoginExistsException extends Throwable {

    public LoginExistsException(final String message) {
        super(message);
    }
}
