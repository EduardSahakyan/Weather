package org.example.domain.usecases;

import org.example.domain.entities.Weather;

public interface GetWeatherLocalUseCase {

    Weather execute(String place);

}
