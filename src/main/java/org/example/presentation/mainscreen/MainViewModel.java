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
        disposable = new CompositeDisposable(); // Esi nra hamara vor утечка памяти chunenas, aysinqn et fonum vor du ban es qashum, xosqi urish screen mtnes kangnacnes, hima vor urish ekran mtnes petq chi el qashi
        disposable.add(getCurrentWeatherUseCase.execute(place)// kanchum em use casey vory Single<Weather> a return anum
                .subscribeOn(Schedulers.io()) // dra vra kanchum em esi, vory cuyc a talis te et im usecasei metody vor Threadum a ashxatelu
                .observeOn(Schedulers.single()) // Esi kanchum es vor nshes te ardyunqy vor threadum es lselu, single-y eti mer himikva threadna vor Screeny bacuma
                .subscribe(publisher::submit, throwable -> {}));
        //Rx-um miqani hat threadner ka arandznacrac konkret ashxatanqi hamar, ete grel kardalu het gorc unenq eti io a
        // Aysinqn io threadum menq qashum enq datan, henc datan hasnuma single threadum cuyc enq talu
        // subscribe metodnel nra hamar te henc hasni datan inch pti anenq
        // 2 hat lambda ka mejy, 1) erb success a aysinqn datan hasela, 2rd erb error a . mez throwable a talis vor message unenanq
        // Hima vor run anem cragiry u kanchem qashelu metody, nayi vonca ashxatum
        // Hajord menun bacuma polyubomu u chi spasum vor datan ga, henc datan galisa nor cuyca talis
    }
}
