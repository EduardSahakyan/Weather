package org.example.data.mappers;

import org.example.data.datasources.remote.dto.WeatherDto;
import org.example.domain.entities.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherMapper implements Mapper<WeatherDto, Weather> {

    private WeatherMapper() {}

    private static WeatherMapper INSTANCE = null;

    public static synchronized WeatherMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WeatherMapper();
        }
        return INSTANCE;
    }

    @Override
    public Weather toEntity(WeatherDto dto) {
        return new Weather(
                dto.getLocation().getName(),
                dto.getLocation().getCountry(),
                dto.getCurrent().getCondition().getText(),
                dto.getCurrent().getTempC(),
                dto.getCurrent().getTempF()
        );
    }

    @Override
    public List<Weather> toList(List<WeatherDto> listDto) {
        List<Weather> weatherList = new ArrayList<>();
        listDto.forEach(element -> {
            weatherList.add(toEntity(element));
        });
        return weatherList;
    }
}
