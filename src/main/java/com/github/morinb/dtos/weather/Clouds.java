package com.github.morinb.dtos.weather;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq", sequenceName = "clouds_oid")
public class Clouds {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @PrimaryKeyJoinColumn
    private Long clouds_oid;

    @Column(name="_all")
    private Integer all;

    public Clouds() {
    }

    public Clouds(Integer all) {
        this.all = all;
    }

    public Long getClouds_oid() {
        return clouds_oid;
    }

    public void setClouds_oid(Long clouds_oid) {
        this.clouds_oid = clouds_oid;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "clouds_oid=" + clouds_oid +
                ", all=" + all +
                '}';
    }
}
