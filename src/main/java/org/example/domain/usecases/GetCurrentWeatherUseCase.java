package org.example.domain.usecases;

import io.reactivex.rxjava3.core.Single;
import org.example.domain.entities.Weather;

public interface GetCurrentWeatherUseCase {

    Single<Weather> execute(String place);

}
