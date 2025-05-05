package com.zentra.zentragate.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TVResult {
    private Long id;
    private String name;
    private String overview;
    @JsonProperty("first_air_date")
    private String firstAirDate;
    @JsonProperty("vote_average")
    private Double voteAverage;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("media_type")
    private String mediaType;
}