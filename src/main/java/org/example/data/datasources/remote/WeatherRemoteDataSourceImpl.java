package org.example.data.datasources.remote;

import io.reactivex.rxjava3.core.Single;
import org.example.data.datasources.remote.api.ApiService;
import org.example.data.datasources.remote.dto.WeatherDto;
import retrofit2.Response;

public class WeatherRemoteDataSourceImpl implements WeatherRemoteDataSource {

    private final ApiService apiService;

    public WeatherRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<WeatherDto> getCurrentWeather(String place) {
        return apiService.getCurrentWeather(place);
    }
}
