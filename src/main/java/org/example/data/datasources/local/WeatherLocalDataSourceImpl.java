package org.example.data.datasources.local;

import org.example.domain.entities.Weather;

import java.io.*;

public class WeatherLocalDataSourceImpl implements WeatherLocalDataSource{

    public WeatherLocalDataSourceImpl() {

    }

    @Override
    public Weather getCurrentWeather(String place) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(place + ".txt"));
            Weather weather = (Weather) objectInputStream.readObject();
            objectInputStream.close();
            return weather;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void putWeather(Weather weather) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(weather.getPlaceName() + ".txt"));
            objectOutputStream.writeObject(weather);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
