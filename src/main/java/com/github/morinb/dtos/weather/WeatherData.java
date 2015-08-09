package com.github.morinb.dtos.weather;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@SequenceGenerator(name = "seq", sequenceName = "weather_data_oid")
@NamedQueries({
        @NamedQuery(name = "WeatherData.findByKey", query = "SELECT w FROM WeatherData w WHERE w.dt=:dt AND w.id=:id"),
        @NamedQuery(name = "WeatherData.findAll", query = "SELECT w FROM WeatherData w ORDER by w.dt DESC"),
        @NamedQuery(name = "WeatherData.findAllById", query = "SELECT w FROM WeatherData w WHERE w.id=:id ORDER by w.dt DESC"),
        @NamedQuery(name = "WeatherData.cityIds", query = "SELECT w.id FROM WeatherData w GROUP BY w.id")

})
public class WeatherData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long weather_data_oid;

    @OneToOne(cascade = CascadeType.ALL)
    private Coord coord;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "weather_data_oid")
    private List<Weather> weather;

    private String base;

    @OneToOne(cascade = CascadeType.ALL)
    private Main main;

    @OneToOne(cascade = CascadeType.ALL)
    private Wind wind;

    @OneToOne(cascade = CascadeType.ALL)
    private Clouds clouds;

    @OneToOne(cascade = CascadeType.ALL)
    private Rain rain;

    @OneToOne(cascade = CascadeType.ALL)
    private Snow snow;

    private Long dt;

    @OneToOne(cascade = CascadeType.ALL)
    private Sys sys;

    private Long id;

    private String name;

    private Integer cod;

    private Integer visibility;

    public WeatherData() {
    }

    public Long getWeather_data_oid() {
        return weather_data_oid;
    }

    public void setWeather_data_oid(Long weather_data_oid) {
        this.weather_data_oid = weather_data_oid;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }


    @Override
    public String toString() {
        return "WeatherData{" +
                "coord=" + coord +
                ",\n weather=" + weather +
                ",\n base='" + base + '\'' +
                ",\n main=" + main +
                ",\n wind=" + wind +
                ",\n clouds=" + clouds +
                ",\n rain=" + rain +
                ",\n snow=" + snow +
                ",\n dt=" + dt +
                ",\n sys=" + sys +
                ",\n id=" + id +
                ",\n name='" + name + '\'' +
                ",\n cod=" + cod +
                ",\n visibility=" + visibility +
                '}';
    }
}
