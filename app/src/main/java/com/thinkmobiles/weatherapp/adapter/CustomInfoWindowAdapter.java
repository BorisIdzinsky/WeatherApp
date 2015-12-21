package com.thinkmobiles.weatherapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.thinkmobiles.weatherapp.R;
import com.thinkmobiles.weatherapp.model.Coordinates;
import com.thinkmobiles.weatherapp.model.ResultData;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by boris on 10.09.15.
 *
 */
public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    @Bind(R.id.city)
    protected TextView city;
    @Bind(R.id.wind)
    protected TextView wind;
    @Bind(R.id.cloudness)
    protected TextView cloudness;
    @Bind(R.id.pressure)
    protected TextView pressure;
    @Bind(R.id.humidity)
    protected TextView humidity;
    @Bind(R.id.sunrise)
    protected TextView sunrise;
    @Bind(R.id.sunset)
    protected TextView sunset;
    @Bind(R.id.geo_cords)
    protected TextView geoCords;
    @Bind(R.id.temp)
    protected TextView temp;
    @Bind(R.id.temp_icon)
    protected ImageView tempIcon;

    private Bitmap bitmap;
    private ResultData resultData;
    private Context context;

    public CustomInfoWindowAdapter(Context context, ResultData resultData, Bitmap bitmap) {
        this.bitmap = bitmap;
        this.resultData = resultData;
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = LayoutInflater.from(context).inflate(R.layout.info_window_layout, null);
        ButterKnife.bind(this, view);
        setResultData();
        return view;
    }

    private void setResultData() {
        if (resultData != null) {
            setTempIcon(bitmap);
            setCity(resultData.getName() + ", " + resultData.getSys().getCountry());
            setTemp(resultData.getMain().getTemp());
            setHumidity(Integer.toString(resultData.getMain().getHumidity()));
            setPressure(Integer.toString(resultData.getMain().getPressure()));
            setGeoCords(resultData.getCoord());
            setWind(Double.toString(resultData.getWind().getSpeed()));
            setCloudness(resultData.getWeather().get(0).getDescription());
            setSunrise(resultData.getSys().getSunrise());
            setSunset(resultData.getSys().getSunset());
        }
    }

    private void setCity(String text) {
        if (text != null) {
            city.setText(text);
        }
    }

    private void setWind(String speed) {
        if (speed != null) {
            wind.setText(speed + " m/s");
        }
    }

    private void setCloudness(String cloud) {
        if (cloud != null) {
            cloudness.setText(cloud);
        }
    }

    private void setPressure(String  pres) {
        if (pres != null) {
            pressure.setText(pres + " hpa");
        }
    }

    private void setHumidity(String humid) {
        if (humid != null) {
            humidity.setText(humid + " %");
        }
    }

    private void setSunrise(long sr) {
        sunrise.setText(timeStampToRealTime(sr));
    }

    private void setSunset(long ss) {
        sunset.setText(timeStampToRealTime(ss));
    }

    private void setGeoCords(Coordinates cords) {
        if (cords != null) {
            geoCords.setText("[ " + Double.toString(cords.getLat()) + ", " + Double.toString(cords.getLon()) + " ]");
        }
    }

    private void setTemp(double  temperature) {
        temp.setText(kalvinToCelsius(temperature));
    }

    private void setTempIcon(Bitmap bitmap) {
        if (bitmap != null) {
            tempIcon.setImageBitmap(bitmap);
        }
    }

    private String kalvinToCelsius(double temp) {
        double celsius = temp - 273.15;
        return String.format("%.1f", celsius) + " \u2103";
    }

    private String timeStampToRealTime(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(new Date(time * 1000));
    }
}

