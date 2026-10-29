
package com.Ujjwal.simpleWebApp.controller;

import com.Ujjwal.simpleWebApp.model.WeatherApiResponse;
import com.Ujjwal.simpleWebApp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather/{city}")
    public ResponseEntity<WeatherApiResponse> getWeather(
            @PathVariable("city") String city) {

        WeatherApiResponse response =
                weatherService.getWeather(city);

        return ResponseEntity.ok(response);
    }
}
