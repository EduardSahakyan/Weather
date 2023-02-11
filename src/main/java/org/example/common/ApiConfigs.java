package org.example.common;

public class ApiConfigs {

    private ApiConfigs() {}

    private static final String API_KEY = "51ac2c2804a64519bd7175252231301";
    public static final String BASE_URL = "https://api.weatherapi.com/v1/";
    public static final String SPORTS_ENDPOINT = "sports.json?key=" + API_KEY;
    public static final String CURRENT_WEATHER_ENDPOINT = "current.json?key=" + API_KEY;

}
