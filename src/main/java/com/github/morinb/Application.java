package com.github.morinb;

import com.github.morinb.dtos.weather.*;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    private EntityManagerFactory emf;

    public WeatherData sample() {
        WeatherData wd = new WeatherData();
        wd.setCoord(new Coord(-0.13, 51.51));
        wd.setWeather(Lists.newArrayList(new Weather(800, "Clear", "Sky is clear", "01n")));
        wd.setBase("stations");
        wd.setMain(new Main(288.74, 1022, 68, 285.93, 291.15, null, null));
        wd.setVisibility(10000);
        wd.setWind(new Wind(2.1, 170));
        wd.setClouds(new Clouds(0));
        wd.setDt(1439078911L);
        wd.setSys(new Sys(1, 5091, 0.0111, "GB", 1439094953L, 1439148910L));
        wd.setId(2643743L);
        wd.setName("London");
        wd.setCod(200);

        return wd;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
