package org.example.domain.usecases;

import io.reactivex.rxjava3.core.Single;
import org.example.domain.entities.Weather;
import org.example.domain.gateways.WeatherGateway;

public class GetCurrentWeatherUseCaseImpl implements GetCurrentWeatherUseCase {

    private final WeatherGateway weatherGateway;

    public GetCurrentWeatherUseCaseImpl(WeatherGateway weatherGateway) {
        this.weatherGateway = weatherGateway;
    }

    @Override
    public Single<Weather> execute(String place) {
        return weatherGateway.getCurrentWeather(place);
    }
}
