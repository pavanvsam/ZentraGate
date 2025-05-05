package com.zentra.zentragate.service;

import com.zentra.zentragate.entity.MediaDetail;
import com.zentra.zentragate.repository.MediaRepository;
import com.zentra.zentragate.util.exception.MediaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TMDBServiceImpl implements TMDBService {

    private final MediaRepository mediaRepository;

    @Autowired
    public TMDBServiceImpl(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    public MediaDetail getMediaDetailsByImdbId(String imdbId) throws MediaNotFoundException {
        return mediaRepository.getMediaDetailsByImdbId(imdbId);
    }

}