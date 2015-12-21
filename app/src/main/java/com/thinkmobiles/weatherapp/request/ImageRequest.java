package com.thinkmobiles.weatherapp.request;

import android.content.Context;
import android.graphics.Bitmap;

import com.octo.android.robospice.request.simple.BitmapRequest;

import java.io.File;

import roboguice.util.temp.Ln;

/**
 * Created by boris on 10.09.15.
 *
 */
public class ImageRequest extends BitmapRequest {

    private static final String API_PATH = "http://api.openweathermap.org/img/w/";
    private static final String PNG_EXTENSION = "png";

    public ImageRequest(Context context, String url) {
        super(buildUrl(url), new File(context.getCacheDir() + "/" + url));
    }

    @Override
    public Bitmap loadDataFromNetwork() throws Exception {
        Bitmap image = super.loadDataFromNetwork();

        if (getCacheFile().delete()) {
            Ln.w("File not deleted");
        }

        return image;
    }

    private static String buildUrl(String imageResource) {
        return API_PATH + imageResource + "." + PNG_EXTENSION;
    }
}
