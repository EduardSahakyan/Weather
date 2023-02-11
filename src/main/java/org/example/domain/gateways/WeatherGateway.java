package org.example.domain.gateways;

import org.example.domain.entities.Weather;

public interface WeatherGateway {

    Weather getCurrentWeather(String place);

}
