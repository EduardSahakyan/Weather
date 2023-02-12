package org.example.data.datasources.remote;

import io.reactivex.rxjava3.core.Single;
import org.example.data.datasources.remote.dto.WeatherDto;

public interface WeatherRemoteDataSource {

    Single<WeatherDto> getCurrentWeather(String place);

}
