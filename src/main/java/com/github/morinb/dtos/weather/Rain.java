package com.github.morinb.dtos.weather;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq", sequenceName = "rain_oid")
public class Rain implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")@PrimaryKeyJoinColumn
    private Long rain_oid;


    private Integer _3h;

    public Rain() {
    }

    public Rain(Integer _3h) {
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
        return "Rain{" +
                "rain_oid=" + rain_oid +
                ", _3h=" + _3h +
                '}';
    }
}
