package org.example.data.datasources.remote;

import org.example.data.datasources.remote.api.ApiService;
import org.example.data.datasources.remote.dto.WeatherDto;
import retrofit2.Response;

public class WeatherRemoteDataSourceImpl implements WeatherRemoteDataSource {

    private final ApiService apiService;

    public WeatherRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public WeatherDto getCurrentWeather(String place) {
        try {
            Response<WeatherDto> response = apiService.getCurrentWeather(place).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new Exception(response.message());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
