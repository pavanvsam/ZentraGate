package com.zentra.zentragate.constants;


public class Constants {

    public static final String IMDB_ID_SEARCH_URL_FORMAT = "%s/find/%s?api_key=%s&external_source=imdb_id";

    // Prevent instantiation
    private Constants() {
        throw new UnsupportedOperationException("Constants class should not be instantiated");
    }
}
