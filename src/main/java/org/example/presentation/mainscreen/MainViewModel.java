package org.example.presentation.mainscreen;

import org.example.domain.entities.Weather;
import org.example.domain.usecases.GetCurrentWeatherUseCase;
import org.example.presentation.common.BaseViewModel;

import java.util.concurrent.*;

public class MainViewModel extends BaseViewModel {

    private final GetCurrentWeatherUseCase getCurrentWeatherUseCase;

    public MainViewModel(GetCurrentWeatherUseCase getCurrentWeatherUseCase) {
        this.getCurrentWeatherUseCase = getCurrentWeatherUseCase;
    }

    public Weather getCurrentWeather(String place) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Weather> future = executorService.submit(() -> getCurrentWeatherUseCase.execute(place));
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
