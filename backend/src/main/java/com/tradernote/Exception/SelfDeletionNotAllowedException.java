package com.tradernote.Exception;

public class SelfDeletionNotAllowedException extends RuntimeException{
    public SelfDeletionNotAllowedException(String message) {
        super(message);
    }
}
