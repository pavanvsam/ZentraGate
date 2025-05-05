package com.zentra.zentragate.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieResult {
    private Long id;
    private String title;
    private String overview;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("vote_average")
    private Double voteAverage;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("media_type")
    private String mediaType;
}