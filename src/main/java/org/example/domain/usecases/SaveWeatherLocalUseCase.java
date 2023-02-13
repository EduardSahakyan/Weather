package org.example.domain.usecases;

import org.example.domain.entities.Weather;

public interface SaveWeatherLocalUseCase {

    void execute(Weather weather);

}
