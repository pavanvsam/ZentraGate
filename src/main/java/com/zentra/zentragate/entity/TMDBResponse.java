package com.zentra.zentragate.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TMDBResponse {
    @JsonProperty("movie_results")
    private List<MovieResult> movieResults;

    @JsonProperty("tv_results")
    private List<TVResult> tvResults;

}