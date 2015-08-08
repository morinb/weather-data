package com.github.morinb.dtos.weather;

import java.io.Serializable;
import java.util.List;

public class WeatherData implements Serializable {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Rain rain;
    private Snow snow;
    private double dt;
    private Sys sys;
    private double id;
    private String name;
    private double cod;
}
