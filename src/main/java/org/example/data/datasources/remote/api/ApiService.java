package org.example.data.datasources.remote.api;

import io.reactivex.rxjava3.core.Single;
import org.example.data.datasources.remote.dto.WeatherDto;
import retrofit2.http.GET;
import retrofit2.http.Query;
import static org.example.common.ApiConfigs.CURRENT_WEATHER_ENDPOINT;

public interface ApiService {

    @GET(CURRENT_WEATHER_ENDPOINT)
    Single<WeatherDto> getCurrentWeather(@Query(value = "q", encoded = true) String place);

}
