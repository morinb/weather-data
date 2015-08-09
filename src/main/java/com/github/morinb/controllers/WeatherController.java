package com.github.morinb.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.morinb.dtos.weather.WeatherData;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class WeatherController {

    @Autowired
    EntityManager em;

    @RequestMapping(value = "/weather/city", method = RequestMethod.GET)
    @ResponseBody
    public String getCity() {
        return "Neuilly-sur-marne";
    }

    private String appId;

    private synchronized String getAppId() {
        if (appId == null) {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(WeatherController.class.getResourceAsStream("/api.key")))) {
                this.appId = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return appId;
    }

    @RequestMapping(value = "weather/cities/{cityId}", method = RequestMethod.GET)
    public List<WeatherData> getWeatherDatasById(@PathVariable Long cityId) {
        final Query findAll = em.createNamedQuery("WeatherData.findAllById");
        findAll.setParameter("id", cityId);
        List<WeatherData> resultList = (List<WeatherData>) findAll.getResultList();
        if (resultList == null || resultList.isEmpty()) {
            return Lists.newArrayList();
        }

        return resultList;
    }

    @RequestMapping(value = "weather/cityIds", method = RequestMethod.GET)
    public List<Long> getCityIds() {
        final Query findAll = em.createNamedQuery("WeatherData.cityIds");
        return (List<Long>)findAll.getResultList();
    }

    @RequestMapping(value = "weather/cities", method = RequestMethod.GET)
    public Map<Long, List<WeatherData>> getWeatherDatas() {
        final Query findAll = em.createNamedQuery("WeatherData.findAll");

        Map<Long, List<WeatherData>> result = Maps.newLinkedHashMap();

        List<WeatherData> resultList = (List<WeatherData>) findAll.getResultList();
        if (resultList == null || resultList.isEmpty()) {
            return Maps.newHashMap();
        }

        for (WeatherData wd : resultList) {
            if (result.containsKey(wd.getId())) {
                result.get(wd.getId()).add(wd);
            } else {
                List<WeatherData> lwd = Lists.newLinkedList();
                lwd.add(wd);
                result.put(wd.getId(), lwd);
            }
        }

        return result;
    }


    private static final ObjectMapper mapper = new ObjectMapper();

    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(method = RequestMethod.POST, value = "weather/store")
    public void storeWeather(@RequestBody Object o) {
        WeatherData weatherData = mapper.convertValue(o, WeatherData.class);

        // Check data already exists
        final Query findByKey = em.createNamedQuery("WeatherData.findByKey");
        findByKey.setParameter("dt", weatherData.getDt());
        findByKey.setParameter("id", weatherData.getId());


        try {
            weatherData = (WeatherData) findByKey.getSingleResult();
            System.out.println("weather data already known: " + weatherData.getId());

        } catch (NoResultException nre) {
            em.persist(weatherData);
            System.out.println("Create new weather data");
        }
        System.out.println(weatherData + " / " + weatherData.getDt() + " = " + new Date(weatherData.getDt() * 1000));
    }
}
