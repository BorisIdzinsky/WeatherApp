package com.thinkmobiles.weatherapp.model;

import com.google.api.client.util.Key;

import java.util.List;

/**
 * Created by boris on 09.09.15.
 *
 */
public class ResultData {

    @Key("coord")
    private Coordinates coord;
    @Key("weather")
    private List<WeatherData> weather;
    @Key("base")
    private String base;
    @Key("main")
    private Main main;
    @Key("visibility")
    private int visibility;
    @Key("wind")
    private Wind wind;
    @Key("clouds")
    private Clouds clouds;
    @Key("dt")
    private long dt;
    @Key("sys")
    private Sys sys;
    @Key("id")
    private long id;
    @Key("name")
    private String name;
    @Key("cod")
    private int cod;

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public List<WeatherData> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherData> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultData)) return false;

        ResultData that = (ResultData) o;

        if (visibility != that.visibility) return false;
        if (dt != that.dt) return false;
        if (id != that.id) return false;
        if (cod != that.cod) return false;
        if (coord != null ? !coord.equals(that.coord) : that.coord != null) return false;
        if (weather != null ? !weather.equals(that.weather) : that.weather != null) return false;
        if (base != null ? !base.equals(that.base) : that.base != null) return false;
        if (main != null ? !main.equals(that.main) : that.main != null) return false;
        if (wind != null ? !wind.equals(that.wind) : that.wind != null) return false;
        if (clouds != null ? !clouds.equals(that.clouds) : that.clouds != null) return false;
        if (sys != null ? !sys.equals(that.sys) : that.sys != null) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = coord != null ? coord.hashCode() : 0;
        result = 31 * result + (weather != null ? weather.hashCode() : 0);
        result = 31 * result + (base != null ? base.hashCode() : 0);
        result = 31 * result + (main != null ? main.hashCode() : 0);
        result = 31 * result + visibility;
        result = 31 * result + (wind != null ? wind.hashCode() : 0);
        result = 31 * result + (clouds != null ? clouds.hashCode() : 0);
        result = 31 * result + (int) (dt ^ (dt >>> 32));
        result = 31 * result + (sys != null ? sys.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + cod;
        return result;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}
