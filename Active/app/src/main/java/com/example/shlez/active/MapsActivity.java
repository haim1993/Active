package com.example.shlez.active;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.google.android.gms.maps.UiSettings.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private final static int MY_PERMISSIONS_FINE_LOCATION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;




            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setRotateGesturesEnabled(false);
                mMap.getUiSettings().setTiltGesturesEnabled(false);

            LatLng myLocation = new LatLng(32.0853,34.7818);
            CameraPosition target = CameraPosition.builder().target(myLocation).zoom(14).build();
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));

//            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//            LocationListener locationListener = new LocationListener() {
//                public void onLocationChanged(Location location) {
//
//                    Toast.makeText(getApplicationContext(), "Your location is : (" + location.getLongitude() + "," + location.getLatitude() + ")", Toast.LENGTH_LONG).show();
//                    LatLng myLocation = new LatLng(location.getLongitude(), location.getLatitude());
//                    CameraPosition target = CameraPosition.builder().target(myLocation).zoom(14).build();
//                    mMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
//                }
//
//                @Override
//                public void onStatusChanged(String provider, int status, Bundle extras) {}
//
//                @Override
//                public void onProviderEnabled(String provider) {}
//
//                @Override
//                public void onProviderDisabled(String provider) {}
//            };
//            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);

        } else {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_FINE_LOCATION);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_FINE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        mMap.setMyLocationEnabled(true);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "This app requires location permissions to be granted", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
        }
    }
}
