package org.example.data.datasources.local;

import org.example.domain.entities.Weather;

import java.io.Serializable;

public interface WeatherLocalDataSource extends Serializable {
    Weather getCurrentWeather(String place); //place-i imast chka, vorovhetev mi weather unes, verjin pahacy
    //bayc ete place-ov es uzum, pti file-i anuny place-ov pahes vor amen angam qo uzacy ta, vonc kuzes tenc ara
    void putWeather(Weather weather); // dto chi, dton menak api calleri hamara, uxxaki weather
}
