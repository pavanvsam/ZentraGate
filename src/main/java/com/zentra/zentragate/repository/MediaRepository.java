package com.zentra.zentragate.repository;

import com.zentra.zentragate.entity.MediaDetail;
import com.zentra.zentragate.util.exception.MediaNotFoundException;

public interface MediaRepository {

    MediaDetail getMediaDetailsByImdbId(String imdbId) throws MediaNotFoundException;
}
