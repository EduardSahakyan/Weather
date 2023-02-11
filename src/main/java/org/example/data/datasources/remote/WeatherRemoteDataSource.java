package org.example.data.datasources.remote;

import org.example.data.datasources.remote.dto.WeatherDto;

public interface WeatherRemoteDataSource {

    WeatherDto getCurrentWeather(String place);

}
