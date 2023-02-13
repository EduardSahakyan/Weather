package org.example.domain.usecases;

import org.example.domain.entities.Weather;
import org.example.domain.gateways.WeatherGateway;

public class GetWeatherLocalUseCaseImpl implements GetWeatherLocalUseCase {

    private final WeatherGateway weatherGateway;

    public GetWeatherLocalUseCaseImpl(WeatherGateway weatherGateway) {
        this.weatherGateway = weatherGateway;
    }

    @Override
    public Weather execute(String place) {
        return weatherGateway.getWeatherFromFiles(place);
    }
}
