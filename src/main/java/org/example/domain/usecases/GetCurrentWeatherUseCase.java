package org.example.domain.usecases;

import org.example.domain.entities.Weather;

public interface GetCurrentWeatherUseCase {

    Weather execute(String place);

}
