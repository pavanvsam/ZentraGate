package com.zentra.zentragate.entity;

import lombok.Data;

@Data
public class MediaDetail {
    private String imdbId;
    private String title;
    private String overview;
    private String releaseDate;
    private Double voteAverage;
    private String posterPath;
    private String mediaType;
}