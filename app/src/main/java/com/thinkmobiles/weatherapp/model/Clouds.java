package com.thinkmobiles.weatherapp.model;

import com.google.api.client.util.Key;

/**
 * Created by boris on 09.09.15.
 *
 */
public class Clouds {

    @Key("all")
    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clouds)) return false;

        Clouds clouds = (Clouds) o;

        return all == clouds.all;

    }

    @Override
    public int hashCode() {
        return all;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }
}
