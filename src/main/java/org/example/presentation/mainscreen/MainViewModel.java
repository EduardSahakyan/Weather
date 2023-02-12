package org.example.presentation.mainscreen;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.example.domain.entities.Weather;
import org.example.domain.usecases.GetCurrentWeatherUseCase;
import org.example.presentation.common.BaseViewModel;

import java.util.concurrent.*;

public class MainViewModel extends BaseViewModel {

    private final GetCurrentWeatherUseCase getCurrentWeatherUseCase;

    public MainViewModel(GetCurrentWeatherUseCase getCurrentWeatherUseCase) {
        this.getCurrentWeatherUseCase = getCurrentWeatherUseCase;
    }

    private final SubmissionPublisher<Weather> publisher = new SubmissionPublisher<>();

    public SubmissionPublisher<Weather> getPublisher() {
        return publisher;
    }

    public void getCurrentWeather(String place) {
        disposable = new CompositeDisposable();
        disposable.add(getCurrentWeatherUseCase.execute(place)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(publisher::submit, throwable -> {})
        );
    }
}
