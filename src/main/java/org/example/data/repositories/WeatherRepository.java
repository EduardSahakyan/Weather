package org.example.data.repositories;

import org.example.data.datasources.remote.WeatherRemoteDataSource;
import org.example.data.datasources.remote.dto.WeatherDto;
import org.example.data.mappers.WeatherMapper;
import org.example.domain.entities.Weather;
import org.example.domain.gateways.WeatherGateway;

public class WeatherRepository implements WeatherGateway {

    private final WeatherRemoteDataSource weatherRemoteDataSource;
    private final WeatherMapper weatherMapper;

    public WeatherRepository(
            WeatherRemoteDataSource weatherRemoteDataSource,
            WeatherMapper weatherMapper
    ) {
        this.weatherRemoteDataSource = weatherRemoteDataSource;
        this.weatherMapper = weatherMapper;
    }

    @Override
    public Weather getCurrentWeather(String place) {
        WeatherDto dto = weatherRemoteDataSource.getCurrentWeather(place);
        return weatherMapper.toEntity(dto);
    }
}
