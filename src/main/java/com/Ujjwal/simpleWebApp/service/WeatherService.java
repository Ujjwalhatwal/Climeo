
package com.Ujjwal.simpleWebApp.service;

import com.Ujjwal.simpleWebApp.model.WeatherApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private static final String API_URL =
            "https://api.weatherstack.com/current";

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    @Value("${weather.api.key}")
    private String apiKey;


    public WeatherApiResponse getWeather(String city) {

        if (city == null || city.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "City name cannot be empty"
            );
        }

        URI uri = UriComponentsBuilder
                .fromUriString(API_URL)
                .queryParam("access_key", apiKey)
                .queryParam("query", city.trim())
                .queryParam("units", "m")
                .encode()
                .build()
                .toUri();

        try {
            WeatherApiResponse response =
                    restTemplate.getForObject(
                            uri,
                            WeatherApiResponse.class
                    );

            if (response == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_GATEWAY,
                        "Empty response from weather provider"
                );
            }

            if (response.getError() != null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_GATEWAY,
                        response.getError().getInfo()
                );
            }

            return response;

        } catch (RestClientResponseException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_GATEWAY,
                    "Weather provider request failed",
                    ex
            );
        }
    }
}
