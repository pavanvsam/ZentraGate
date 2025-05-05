package com.zentra.zentragate.util.exception;

public class MediaNotFoundException extends RuntimeException {
    public MediaNotFoundException(String imdbId) {
        super("Media not found with IMDB ID: " + imdbId);
    }
}
