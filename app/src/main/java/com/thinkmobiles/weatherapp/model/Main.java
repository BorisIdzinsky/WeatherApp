package com.thinkmobiles.weatherapp.model;

import com.google.api.client.util.Key;

/**
 * Created by boris on 09.09.15.
 *
 */
public class Main {

    @Key("temp")
    private double temp;
    @Key("pressure")
    private int pressure;
    @Key("humidity")
    private int humidity;
    @Key("temp_min")
    private double tempMin;
    @Key("temp_max")
    private double tempMax;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Main)) return false;

        Main main = (Main) o;

        if (Double.compare(main.temp, temp) != 0) return false;
        if (pressure != main.pressure) return false;
        if (humidity != main.humidity) return false;
        if (Double.compare(main.tempMin, tempMin) != 0) return false;
        return Double.compare(main.tempMax, tempMax) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp1;
        temp1 = Double.doubleToLongBits(temp);
        result = (int) (temp1 ^ (temp1 >>> 32));
        result = 31 * result + pressure;
        result = 31 * result + humidity;
        temp1 = Double.doubleToLongBits(tempMin);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(tempMax);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                '}';
    }
}
