package com.thinkmobiles.weatherapp.model;

import com.google.api.client.util.Key;

/**
 * Created by boris on 09.09.15.
 *
 */
public class Sys {

    @Key("type")
    private int type;
    @Key("id")
    private int id;
    @Key("message")
    private double message;
    @Key("country")
    private String country;
    @Key("sunrise")
    private long sunrise;
    @Key("sunset")
    private long sunset;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sys)) return false;

        Sys sys = (Sys) o;

        if (type != sys.type) return false;
        if (id != sys.id) return false;
        if (Double.compare(sys.message, message) != 0) return false;
        if (sunrise != sys.sunrise) return false;
        if (sunset != sys.sunset) return false;
        return !(country != null ? !country.equals(sys.country) : sys.country != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type;
        result = 31 * result + id;
        temp = Double.doubleToLongBits(message);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (int) (sunrise ^ (sunrise >>> 32));
        result = 31 * result + (int) (sunset ^ (sunset >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "type=" + type +
                ", id=" + id +
                ", message=" + message +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
