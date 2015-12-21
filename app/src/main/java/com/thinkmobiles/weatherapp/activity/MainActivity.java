package com.thinkmobiles.weatherapp.activity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.octo.android.robospice.Jackson2GoogleHttpClientSpiceService;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.thinkmobiles.weatherapp.R;
import com.thinkmobiles.weatherapp.adapter.CustomInfoWindowAdapter;
import com.thinkmobiles.weatherapp.model.ResultData;
import com.thinkmobiles.weatherapp.request.CurrentWeatherDataRequest;
import com.thinkmobiles.weatherapp.request.ImageRequest;

import java.net.HttpURLConnection;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, SearchView.OnQueryTextListener {

    @Bind(R.id.tool_bar)
    protected Toolbar toolbar;

    private SpiceManager spiceManager = new SpiceManager(Jackson2GoogleHttpClientSpiceService.class);
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initializeMap();
    }

    @Override
    protected void onStart() {
        spiceManager.start(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        spiceManager.shouldStop();
        super.onStop();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchView search = (SearchView) menu.findItem(R.id.action_search).getActionView();
        search.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
    }

    private void initializeMap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void loadWeatherData(String city) {
        if (city != null) {
            spiceManager.execute(new CurrentWeatherDataRequest(city), new RequestListener<ResultData>() {
                @Override
                public void onRequestFailure(SpiceException spiceException) {
                }

                @Override
                public void onRequestSuccess(ResultData resultData) {
                    if (resultData != null && resultData.getCod() == HttpURLConnection.HTTP_OK) {
                        loadImage(resultData);
                    } else {
                        showErrorDialog(Integer.toString(resultData.getCod()));
                    }
                }
            });
        }
    }

    private void loadImage(final ResultData resultData) {
        if (resultData != null) {
            spiceManager.execute(new ImageRequest(this, resultData.getWeather().get(0).getIcon()), new RequestListener<Bitmap>() {
                @Override
                public void onRequestFailure(SpiceException spiceException) {
                }

                @Override
                public void onRequestSuccess(Bitmap bitmap) {
                    if (bitmap != null) {
                        addMarker(resultData, bitmap);
                    }
                }
            });
        }
    }

    private void addMarker(ResultData resultData, Bitmap bitmap) {
        if (resultData != null && map != null && bitmap != null) {
            LatLng latLng = new LatLng(resultData.getCoord().getLat(), resultData.getCoord().getLon());
            map.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.builder().target(latLng).zoom(7f).build()));
            map.setInfoWindowAdapter(new CustomInfoWindowAdapter(this, resultData, bitmap));
            Marker marker = map.addMarker(new MarkerOptions().position(latLng));
            marker.showInfoWindow();
        }
    }

    private void showErrorDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(getResources().getString(R.string.error_dialog_message_text) + " " + message).setPositiveButton(R.string.error_dialog_button_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        map.clear();
        loadWeatherData(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
