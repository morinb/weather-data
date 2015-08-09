package com.github.morinb.dtos.weather;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq", sequenceName = "sys_oid")
public class Sys implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")@PrimaryKeyJoinColumn
    private Long sys_oid;


    private Integer type;
    private Integer id;
    private Double message;
    private String country;
    private Long sunrise;
    private Long sunset;

    public Sys() {
    }

    public Sys(Integer type, Integer id, Double message, String country, Long sunrise, Long sunset) {
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Long getSys_oid() {
        return sys_oid;
    }

    public void setSys_oid(Long sys_oid) {
        this.sys_oid = sys_oid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "sys_oid=" + sys_oid +
                ", type=" + type +
                ", id=" + id +
                ", message=" + message +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
