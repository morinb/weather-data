package com.github.morinb.dtos.weather;

public final class WeatherUtil {
    public static String getImageUrl(String imageId) {
        return "http://openweathermap.org/img/w/" + imageId + ".png";
    }
}
