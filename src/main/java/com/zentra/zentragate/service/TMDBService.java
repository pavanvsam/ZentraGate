package com.zentra.zentragate.service;

import com.zentra.zentragate.entity.MediaDetail;
import com.zentra.zentragate.repository.MediaRepository;
import com.zentra.zentragate.util.exception.MediaNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TMDBService {

    private final MediaRepository mediaRepository;

    public TMDBService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public MediaDetail getMediaDetailsByImdbId(String imdbId) throws MediaNotFoundException {
        return mediaRepository.getMediaDetailsByImdbId(imdbId);
    }

}