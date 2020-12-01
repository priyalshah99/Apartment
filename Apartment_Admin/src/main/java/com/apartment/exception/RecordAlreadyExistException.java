package com.apartment.exception;

@SuppressWarnings("serial")
public class RecordAlreadyExistException extends Exception {
    public RecordAlreadyExistException(String message) {
        super(message);
    }
}
