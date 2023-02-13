package org.example.domain.usecases;

import org.example.domain.entities.Weather;
import org.example.domain.gateways.WeatherGateway;

public class SaveWeatherLocalUseCaseImpl implements SaveWeatherLocalUseCase {

    private final WeatherGateway weatherGateway;

    public SaveWeatherLocalUseCaseImpl(WeatherGateway weatherGateway) {
        this.weatherGateway = weatherGateway;
    }

    @Override
    public void execute(Weather weather) {
        weatherGateway.saveWeatherToFile(weather);
    }

}
