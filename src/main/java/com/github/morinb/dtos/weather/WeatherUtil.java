package com.github.morinb.dtos.weather;

/**
 * Created by Baptiste on 09/08/2015.
 */
public final class WeatherUtil {
    public static String getImageUrl(String imageId) {
        return "http://openweathermap.org/img/w/" + imageId + ".png";
    }
}
