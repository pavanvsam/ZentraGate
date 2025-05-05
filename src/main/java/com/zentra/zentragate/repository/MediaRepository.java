package com.zentra.zentragate.repository;

import com.zentra.zentragate.config.TMDBConfig;
import com.zentra.zentragate.entity.MediaDetail;
import com.zentra.zentragate.entity.MovieResult;
import com.zentra.zentragate.entity.TMDBResponse;
import com.zentra.zentragate.entity.TVResult;
import com.zentra.zentragate.util.exception.MediaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Repository
public class MediaRepository {


    private final TMDBConfig tmdbConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public MediaRepository(TMDBConfig tmdbConfig) {
        this.tmdbConfig = tmdbConfig;
        this.restTemplate = new RestTemplate();
    }


    public MediaDetail getMediaDetailsByImdbId(String imdbId) throws MediaNotFoundException {
        String searchUrl = String.format("%s/find/%s?api_key=%s&external_source=imdb_id",
                tmdbConfig.getBaseUrl(), imdbId, tmdbConfig.getApiKey());

        ResponseEntity<TMDBResponse> response = restTemplate.getForEntity(searchUrl, TMDBResponse.class);
        TMDBResponse tmdbResponse = response.getBody();

        if (tmdbResponse == null) {
            throw new MediaNotFoundException(imdbId);
        }

        MediaDetail mediaDetails = new MediaDetail();
        mediaDetails.setImdbId(imdbId);

        Optional<List<MovieResult>> movieResultsOpt = Optional.ofNullable(tmdbResponse.getMovieResults());
        Optional<List<TVResult>> tvResultsOpt = Optional.ofNullable(tmdbResponse.getTvResults());

        if (movieResultsOpt.isPresent() && !movieResultsOpt.get().isEmpty()) {
            setMovieMediaContent(tmdbResponse, mediaDetails);
        } else if (tvResultsOpt.isPresent() && !tvResultsOpt.get().isEmpty()) {
            setTVMediaContent(tmdbResponse, mediaDetails);
        } else {
            throw new MediaNotFoundException(imdbId);
        }

        return mediaDetails;
    }

    private static void setMovieMediaContent(TMDBResponse tmdbResponse, MediaDetail mediaDetails) {
        var movie = tmdbResponse.getMovieResults().getFirst();
        mediaDetails.setTitle(movie.getTitle());
        mediaDetails.setOverview(movie.getOverview());
        mediaDetails.setReleaseDate(movie.getReleaseDate());
        mediaDetails.setVoteAverage(movie.getVoteAverage());
        mediaDetails.setPosterPath(movie.getPosterPath());
        mediaDetails.setMediaType("movie");
    }

    private void setTVMediaContent(TMDBResponse tmdbResponse, MediaDetail mediaDetails) {
        var tv = tmdbResponse.getTvResults().getFirst();
        mediaDetails.setTitle(tv.getName());
        mediaDetails.setOverview(tv.getOverview());
        mediaDetails.setReleaseDate(tv.getFirstAirDate());
        mediaDetails.setVoteAverage(tv.getVoteAverage());
        mediaDetails.setPosterPath(tv.getPosterPath());
        mediaDetails.setMediaType("tv");
    }
}