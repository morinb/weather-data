package com.github.morinb.dtos.weather;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq", sequenceName = "snow_oid")
public class Snow implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")@PrimaryKeyJoinColumn
    private Long snow_oid;


    private Integer _3h;

    public Snow() {
    }

    public Long getSnow_oid() {
        return snow_oid;
    }

    public void setSnow_oid(Long snow_oid) {
        this.snow_oid = snow_oid;
    }

    public Snow(Integer _3h) {
        this._3h = _3h;
    }

    public Integer get_3h() {
        return _3h;
    }

    public void set_3h(Integer _3h) {
        this._3h = _3h;
    }

    @Override
    public String toString() {
        return "Snow{" +
                "snow_oid=" + snow_oid +
                ", _3h=" + _3h +
                '}';
    }
}
