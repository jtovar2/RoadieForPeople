package hackatl.com.roadieforpeople;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import hackatl.com.roadieforpeople.model.RoadieGeoPoint;
import hackatl.com.roadieforpeople.model.RoadieUser;
import hackatl.com.roadieforpeople.model.Route;
import hackatl.com.roadieforpeople.model.Routes;


public class MainActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener, RoadieForPeople.RouteListener, GoogleMap.OnMarkerClickListener
{

    public static final String LATLNG = "position";
    public static final String LOGTAG = "MainActivity";
    public static final String STARTLOCATION = "start";
    public static final String ENDLOCATION = "end";



    //These are for saving stuff in bundle
    public static final String CURRENT_LOCATION_KEY = "location";
    public static final String LAST_UPDATE_TIME = "lastTime";



    public static final int NUM_FRAGMENTS = 2;


    FragmentAdapter mFragmentAdapter;


    //Location variables
    GoogleApiClient mGoogleApiClient;
    LocationRequest mCurrentLocationRequest;
    Location mCurrentLocation;
    String mLastUpdateTime;
    GoogleMap mMap;
    Marker mCurrentLocationMarker;
    String mCurrentLocality;


    //Current Possible Routes
    ArrayList<Marker> mRouteMakerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((RoadieForPeople) getApplication()).setRouteListener(MainActivity.this);

        ((RoadieForPeople) getApplication()).setUser(new RoadieUser("Javier", "Tovar", "404-422-2794", new Long(101)));

        ViewPager pager = (ViewPager) findViewById(R.id.viewPagerIntroScreen);


        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        pager.setAdapter(mFragmentAdapter);







        updateValuesFromBundle(savedInstanceState);



        buildGoogleApiClient();
        createLocationRequest();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }













    ///TODO Fill out for stuff necessary for google services and location
    ///Location services
    protected void createLocationRequest() {
        mCurrentLocationRequest = new LocationRequest();
        mCurrentLocationRequest.setInterval(10000);
        mCurrentLocationRequest.setFastestInterval(5000);
        mCurrentLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }




    @Override
    public void onConnected(Bundle bundle) {
        startLocationUpdates();
        Log.v(LOGTAG, "Google Api Client is connected");

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location newLocation) {
        mCurrentLocation = newLocation;
        if(mLastUpdateTime == null)
        {
            getLocale();
        }
        mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());



        if(mMap == null)
        {
            createMap();
        }



        if(mCurrentLocationMarker != null){
            mCurrentLocationMarker.remove();

        }


    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }


    protected void startLocationUpdates()
    {
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mCurrentLocationRequest, this);
    }

    protected void stopLocationUpdates()
    {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
    }

    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putParcelable(CURRENT_LOCATION_KEY, mCurrentLocation);
        savedInstanceState.putString(LAST_UPDATE_TIME, mLastUpdateTime);
        super.onSaveInstanceState(savedInstanceState);
    }


    private void updateValuesFromBundle(Bundle savedInstanceState)
    {
        if (savedInstanceState != null) {

            // Update the value of mCurrentLocation from the Bundle and update the
            // UI to show the correct latitude and longitude.
            if (savedInstanceState.keySet().contains(CURRENT_LOCATION_KEY)) {
                // Since CURRENT_LOCATION_KEY was found in the Bundle, we can be sure that
                // mCurrentLocationis not null.
                mCurrentLocation = savedInstanceState.getParcelable(CURRENT_LOCATION_KEY);
            }

            // Update the value of mLastUpdateTime from the Bundle
            if (savedInstanceState.keySet().contains(LAST_UPDATE_TIME)) {
                mLastUpdateTime = savedInstanceState.getString(
                        LAST_UPDATE_TIME);
            }
        }
    }


    @Override
    public void onStart()
    {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        stopLocationUpdates();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if (mGoogleApiClient.isConnected()) {
            startLocationUpdates();
        }
    }

    public void createMap()
    {
        SupportMapFragment fragmentWithMap = (SupportMapFragment) mFragmentAdapter.getRegisteredFragment(0);
        mMap = fragmentWithMap.getMap();
        mMap.setOnMarkerClickListener(this);
    }


    public void getLocale()
    {
        try{
            Geocoder geo = new Geocoder(MainActivity.this.getApplicationContext(), Locale.getDefault());


            List<Address> addresses = geo.getFromLocation(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude(), 1);
            if (addresses.isEmpty()) {
                Log.d(LOGTAG, "address is empty");
            }
            else {
                if (addresses.size() > 0)
                {

                    Log.d(LOGTAG, "Check out the locality " + addresses.get(0).getLocality());

                    mCurrentLocality = addresses.get(0).getLocality();
                    ((RoadieForPeople) getApplication()).generateRoutes(mCurrentLocality);
                    mFragmentAdapter.setStartingLocation(mCurrentLocality);

                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void onRetrofitResult(int result)
    {
        switch(result)
        {
            case(RoadieForPeople.ROUTE_SUCESS):
                addRouteMarkers(((RoadieForPeople) getApplication()).getRoutes());
                break;
            case(RoadieForPeople.ROUTE_FAILURE):
                Log.v(LOGTAG, "Problem getting the routes from api");


        }
    }


    public void addRouteMarkers(Routes newRoutes)
    {
        mRouteMakerList = new ArrayList<Marker>();


        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Marker currentMarker = null;

        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
        for(Route currentRoute: newRoutes.getRoutes())
        {
            try
            {
                List<Address> addresses = geocoder.getFromLocationName(currentRoute.getEndLocation(), 2);
                LatLng latLng = new LatLng(addresses.get(0).getLatitude(), addresses.get(0).getLongitude());


                mRouteMakerList.add(mMap.addMarker(new MarkerOptions().position(latLng)));

            }
            catch(Exception e)
            {
                Log.v(LOGTAG, "Address not found " + currentRoute.getEndLocation());
            }
        }

        for (Marker marker : mRouteMakerList)
        {
            builder.include(marker.getPosition());
        }
        LatLngBounds bounds = builder.build();
        int padding = 40; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);

        mMap.animateCamera(cu);
    }

    public void submitRoute(View v)
    {

    }



    @Override
    public boolean onMarkerClick(Marker marker)
    {

        Intent i = new Intent(MainActivity.this, TripList.class);
        LatLng position = marker.getPosition();
        RoadieGeoPoint geoPoint = new RoadieGeoPoint(position.latitude, position.longitude);

        i.putExtra(LATLNG, geoPoint);
        startActivity(i);


        return true;
    }

}
