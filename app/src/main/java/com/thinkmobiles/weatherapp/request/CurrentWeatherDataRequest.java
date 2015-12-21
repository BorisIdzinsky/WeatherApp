package com.thinkmobiles.weatherapp.request;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.octo.android.robospice.request.googlehttpclient.GoogleHttpClientSpiceRequest;
import com.thinkmobiles.weatherapp.model.ResultData;

/**
 * Created by boris on 09.09.15.
 *
 */
public class CurrentWeatherDataRequest extends GoogleHttpClientSpiceRequest<ResultData> {

    private static final String API_PATH = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String APPID = "APPID";
    private static final String  API_KEY= "a3fa1ded1968e0a4645be2684e6533b9";

    private String city;

    public CurrentWeatherDataRequest(String city) {
        super(ResultData.class);
        this.city = city;
    }

    @Override
    public ResultData loadDataFromNetwork() throws Exception {
        HttpRequest request = getHttpRequestFactory().buildGetRequest(new GenericUrl(buildURL()));
        request.setParser(new JacksonFactory().createJsonObjectParser());
        HttpResponse response = request.execute();
        return response.parseAs(getResultType());
    }

    private String buildURL() {
        return API_PATH + city + "&" + APPID + "=" +  API_KEY;
    }
}
