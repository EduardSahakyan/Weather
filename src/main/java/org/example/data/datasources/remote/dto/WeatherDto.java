package org.example.data.datasources.remote.dto;

public class WeatherDto {

    private LocationDto location;
    private CurrentDto current;

    public LocationDto getLocation() {
        return location;
    }

    public CurrentDto getCurrent() {
        return current;
    }
}
