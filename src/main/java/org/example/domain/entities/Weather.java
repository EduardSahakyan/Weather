package org.example.domain.entities;

public class Weather {

    private final String placeName;
    private final String country;
    private final String condition;
    private final Double tempC;
    private final Double tempF;

    public Weather(String placeName, String country, String condition, Double tempC, Double tempF) {
        this.placeName = placeName;
        this.country = country;
        this.condition = condition;
        this.tempC = tempC;
        this.tempF = tempF;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getCountry() {
        return country;
    }

    public String getCondition() {
        return condition;
    }

    public Double getTempC() {
        return tempC;
    }

    public Double getTempF() {
        return tempF;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "placeName='" + placeName + '\'' +
                ", country='" + country + '\'' +
                ", condition='" + condition + '\'' +
                ", tempC=" + tempC +
                ", tempF=" + tempF +
                '}';
    }
}
