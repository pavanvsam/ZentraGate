package com.zentra.zentragate.service;

import com.zentra.zentragate.entity.MediaDetail;
import com.zentra.zentragate.util.exception.MediaNotFoundException;

public interface TMDBService {

    MediaDetail getMediaDetailsByImdbId(String imdbId) throws MediaNotFoundException;
}
