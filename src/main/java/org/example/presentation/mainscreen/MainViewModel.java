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

    SubmissionPublisher<Weather> publisher = new SubmissionPublisher<>();

    public void getCurrentWeather(String place) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Weather> future = executorService.submit(() -> getCurrentWeatherUseCase.execute(place));
        try {
            publisher.submit(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
