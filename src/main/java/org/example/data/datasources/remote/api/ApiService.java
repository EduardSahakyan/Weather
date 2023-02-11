package org.example.data.datasources.remote.api;

import org.example.data.datasources.remote.dto.WeatherDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import static org.example.common.ApiConfigs.CURRENT_WEATHER_ENDPOINT;

public interface ApiService {

    @GET(CURRENT_WEATHER_ENDPOINT)
    Call<WeatherDto> getCurrentWeather(@Query(value = "q", encoded = true) String place);

}
