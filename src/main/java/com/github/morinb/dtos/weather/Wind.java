package com.github.morinb.dtos.weather;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq", sequenceName = "wind_oid")
public class Wind implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")@PrimaryKeyJoinColumn
    private Long wind_oid;


    private Double speed;
    private Integer deg;

    public Wind() {
    }

    public Wind(Double speed, Integer deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Long getWind_oid() {
        return wind_oid;
    }

    public void setWind_oid(Long wind_oid) {
        this.wind_oid = wind_oid;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "wind_oid=" + wind_oid +
                ", speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
