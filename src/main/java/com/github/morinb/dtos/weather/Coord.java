package com.github.morinb.dtos.weather;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq", sequenceName = "coord_oid")
public class Coord {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")@PrimaryKeyJoinColumn
    private Long coord_oid;
    private Double lon;
    private Double lat;
    public Coord() {
    }

    public Coord(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Long getCoord_oid() {
        return coord_oid;
    }

    public void setCoord_oid(Long coord_oid) {
        this.coord_oid = coord_oid;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "coord_oid=" + coord_oid +
                ", lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
