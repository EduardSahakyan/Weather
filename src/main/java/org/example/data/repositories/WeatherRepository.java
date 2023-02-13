package org.example.data.repositories;

import io.reactivex.rxjava3.core.Single;
import org.example.data.datasources.local.WeatherLocalDataSource;
import org.example.data.datasources.remote.WeatherRemoteDataSource;
import org.example.data.datasources.remote.dto.WeatherDto;
import org.example.data.mappers.WeatherMapper;
import org.example.domain.entities.Weather;
import org.example.domain.gateways.WeatherGateway;

public class WeatherRepository implements WeatherGateway {

    private final WeatherRemoteDataSource weatherRemoteDataSource;
    private final WeatherLocalDataSource weatherLocalDataSource;
    private final WeatherMapper weatherMapper;

    public WeatherRepository(
            WeatherRemoteDataSource weatherRemoteDataSource,
            WeatherLocalDataSource weatherLocalDataSource,
            WeatherMapper weatherMapper
    ) {
        this.weatherRemoteDataSource = weatherRemoteDataSource;
        this.weatherLocalDataSource = weatherLocalDataSource;
        this.weatherMapper = weatherMapper;
    }

    @Override
    public Single<Weather> getCurrentWeather(String place) {
        Single<WeatherDto> dto = weatherRemoteDataSource.getCurrentWeather(place);
        return dto.map(weatherMapper::toEntity);
    }

    @Override
    public Weather getWeatherFromFiles(String place) {
        return weatherLocalDataSource.getCurrentWeather(place);
    }

    @Override
    public void saveWeatherToFile(Weather weather) {
        weatherLocalDataSource.putWeather(weather);
    }
}
