package com.zentra.zentragate.controller;

import com.zentra.zentragate.entity.MediaDetail;
import com.zentra.zentragate.service.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/media")
public class MediaController {

    private final TMDBService tmdbService;

    @Autowired
    public MediaController(TMDBService tmdbService) {
        this.tmdbService = tmdbService;
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<MediaDetail> getMediaDetails(@PathVariable String imdbId) {
        MediaDetail mediaDetails = tmdbService.getMediaDetailsByImdbId(imdbId);
        return ResponseEntity.ok(mediaDetails);


    }
}