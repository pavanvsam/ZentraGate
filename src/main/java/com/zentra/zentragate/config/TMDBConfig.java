package com.zentra.zentragate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "tmdb")
@Data
public class TMDBConfig {
    private String apiKey;
    private String baseUrl = "https://api.themoviedb.org/3";
}