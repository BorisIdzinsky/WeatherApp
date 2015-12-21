package com.thinkmobiles.weatherapp.model;

import com.google.api.client.util.Key;

/**
 * Created by boris on 09.09.15.
 *
 */
public class Wind {

    @Key("speed")
    private double speed;
    @Key("deg")
    private int deg;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wind)) return false;

        Wind wind = (Wind) o;

        if (Double.compare(wind.speed, speed) != 0) return false;
        return deg == wind.deg;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(speed);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + deg;
        return result;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
