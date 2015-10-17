package hackatl.com.roadieforpeople;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener
{


    public static final String LOGTAG = "MainActivity";


    //These are for saving stuff in bundle
    public static final String CURRENT_LOCATION_KEY = "location";
    public static final String LAST_UPDATE_TIME = "lastTime";



    public static final int NUM_FRAGMENTS = 2;


    FragmentAdapter mFragmentAdapter;


    //Location variables
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    Location mCurrentLocation;
    String mLastUpdateTime;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager pager = (ViewPager) findViewById(R.id.viewPagerIntroScreen);


        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        MapViewFragment fragment = MapViewFragment.newInstance();

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
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
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
    public void onLocationChanged(Location location) {
        mCurrentLocation = location;
        mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());


        /*
        MapViewFragment fragmentWithLocation = (MapViewFragment) mFragmentAdapter.getRegisteredFragment(2);

        if(fragmentWithLocation != null)
        {
            fragmentWithLocation.updateLocation(mCurrentLocation);
        }
        */
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }


    protected void startLocationUpdates()
    {
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);
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
}
