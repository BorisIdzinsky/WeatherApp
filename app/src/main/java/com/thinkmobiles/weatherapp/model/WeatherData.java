package com.thinkmobiles.weatherapp.model;

import com.google.api.client.util.Key;

/**
 * Created by boris on 09.09.15.
 *
 */
public class WeatherData {

    @Key("id")
    private int id;
    @Key("main")
    private String main;
    @Key("description")
    private String description;
    @Key("icon")
    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherData)) return false;

        WeatherData that = (WeatherData) o;

        if (id != that.id) return false;
        if (main != null ? !main.equals(that.main) : that.main != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        return !(icon != null ? !icon.equals(that.icon) : that.icon != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (main != null ? main.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
