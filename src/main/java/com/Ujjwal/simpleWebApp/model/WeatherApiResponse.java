
package com.Ujjwal.simpleWebApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiResponse {

    private Request request;
    private Location location;
    private Current current;

    // Forecast keys may vary, so use a Map.
    private Map<String, ForecastDay> forecast;

    // Weather stack can return an error object.
    private ApiError error;

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Request {
        private String type;
        private String query;
        private String language;
        private String unit;
    }

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        private String name;
        private String country;
        private String region;
        private String lat;
        private String lon;

        @JsonProperty("timezone_id")
        private String timezoneId;

        private String localtime;

        @JsonProperty("localtime_epoch")
        private long localtimeEpoch;

        @JsonProperty("utc_offset")
        private String utcOffset;
    }

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Current {
        @JsonProperty("observation_time")
        private String observationTime;

        private Integer temperature;

        @JsonProperty("weather_code")
        private Integer weatherCode;

        @JsonProperty("weather_icons")
        private List<String> weatherIcons;

        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;

        private Astro astro;

        @JsonProperty("air_quality")
        private AirQuality airQuality;

        @JsonProperty("wind_speed")
        private Integer windSpeed;

        @JsonProperty("wind_degree")
        private Integer windDegree;

        @JsonProperty("wind_dir")
        private String windDir;

        private Integer pressure;
        private Integer precip;
        private Integer humidity;
        private Integer cloudcover;
        private Integer feelslike;

        @JsonProperty("uv_index")
        private Integer uvIndex;

        private Integer visibility;

        @JsonProperty("is_day")
        private String isDay;
    }

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Astro {
        private String sunrise;
        private String sunset;
        private String moonrise;
        private String moonset;

        @JsonProperty("moon_phase")
        private String moonPhase;

        @JsonProperty("moon_illumination")
        private Integer moonIllumination;
    }

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AirQuality {
        private String co;
        private String no2;
        private String o3;
        private String so2;

        @JsonProperty("pm2_5")
        private String pm25;

        private String pm10;

        @JsonProperty("us-epa-index")
        private String usEpaIndex;

        @JsonProperty("gb-defra-index")
        private String gbDefraIndex;
    }

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ForecastDay {
        private String date;

        @JsonProperty("date_epoch")
        private Long dateEpoch;

        private Astro astro;

        private Double maxtemp;
        private Double mintemp;
        private Double avgtemp;

        private Double totalprecip;
        private Double totalsnow;
        private Double sunhour;

        @JsonProperty("uv_index")
        private Integer uvIndex;

        @JsonProperty("air_quality")
        private AirQuality airQuality;

        private List<Hourly> hourly;
    }

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Hourly {
        private String time;
        private Integer temperature;

        @JsonProperty("weather_code")
        private Integer weatherCode;

        @JsonProperty("weather_icons")
        private List<String> weatherIcons;

        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;

        private Integer precip;
        private Integer humidity;
        private Integer visibility;
        private Integer pressure;
        private Integer cloudcover;
        private Integer heatindex;
        private Integer dewpoint;
        private Integer windchill;
        private Integer windgust;
        private Integer feelslike;

        @JsonProperty("uv_index")
        private Integer uvIndex;

        @JsonProperty("chanceofrain")
        private Integer chanceOfRain;

        @JsonProperty("chanceofremdry")
        private Integer chanceOfRemDry;

        @JsonProperty("chanceofwindy")
        private Integer chanceOfWindy;

        @JsonProperty("chanceofovercast")
        private Integer chanceOfOvercast;

        @JsonProperty("chanceofsunshine")
        private Integer chanceOfSunshine;

        @JsonProperty("chanceoffrost")
        private Integer chanceOfFrost;

        @JsonProperty("chanceofhightemp")
        private Integer chanceOfHighTemp;

        @JsonProperty("chanceoffog")
        private Integer chanceOfFog;

        @JsonProperty("chanceofsnow")
        private Integer chanceOfSnow;

        @JsonProperty("chanceofthunder")
        private Integer chanceOfThunder;

        @JsonProperty("air_quality")
        private AirQuality airQuality;
    }

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ApiError {
        private Integer code;
        private String type;
        private String info;
    }
}
