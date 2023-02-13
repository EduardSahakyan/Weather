package org.example.domain.gateways;

import io.reactivex.rxjava3.core.Single;
import org.example.domain.entities.Weather;

public interface WeatherGateway {

    Single<Weather> getCurrentWeather(String place);

    Weather getWeatherFromFiles(String place);

    void saveWeatherToFile(Weather weather);

}
