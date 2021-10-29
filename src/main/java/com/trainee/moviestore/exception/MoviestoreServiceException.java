package com.trainee.moviestore.exception;

public class MoviestoreServiceException extends RuntimeException{

    public MoviestoreServiceException() {
    }

    public MoviestoreServiceException(String message) {
        super(message);
    }

    public MoviestoreServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
