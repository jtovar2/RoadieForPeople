package hackatl.com.roadieforpeople;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import hackatl.com.roadieforpeople.model.RoadieUser;
import hackatl.com.roadieforpeople.model.Route;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by javier on 10/17/15.
 */
public class PlaceRouteLayoutv2 extends LinearLayout
{

    public static final String LOGTAG = "PlaceRoutev2 Layout";

    EditText mDestinationEditText;
    EditText mDayEditText;
    EditText mMonthEditText;
    EditText mYearEditText;
    TextView mDateText;
    DateFormat mDateFormatter;
    Date mLeavingDate;
    View mCurrentView;

    String mStartingLocation;
    String mEndingLocation;


    Context mContext;
    RoadieUser mUser;
    RoutesApi mApi;
    public PlaceRouteLayoutv2(Context newContext)
    {
        super(newContext);
        loadViews(newContext);

    }

    public PlaceRouteLayoutv2(Context newContex, AttributeSet attributeSet)
    {
        super(newContex, attributeSet);
        loadViews(newContex);
    }
    public void loadViews(Context newContext)
    {
        mContext = newContext;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mCurrentView = inflater.inflate(R.layout.place_route_layout, this);


        mDayEditText = (EditText) mCurrentView.findViewById(R.id.editTextDay);
        mMonthEditText = (EditText) mCurrentView.findViewById(R.id.editTextMonth);
        mYearEditText = (EditText) mCurrentView.findViewById(R.id.editTextYear);
        mDestinationEditText = (EditText) mCurrentView.findViewById(R.id.editTextDestinantion);

        mLeavingDate = null;
    }

    public void setUser(RoadieUser newUser)
    {
        mUser = newUser;
    }

    public void setApi(RoutesApi newApi)
    {
        mApi = newApi;
    }

    public void setStartLocation(String newStartLocation)
    {
        mStartingLocation = newStartLocation;
    }

    public void submitRoute()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.getInteger(mYearEditText.getText().toString()), Integer.getInteger(mMonthEditText.getText().toString()) - 1 , Integer.getInteger(mDayEditText.getText().toString()), 0, 0);

        mLeavingDate = calendar.getTime();

        Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
        try {
            List<Address> destinationAddresses = geocoder.getFromLocationName(mDestinationEditText.getText().toString(), 2);
            mEndingLocation = destinationAddresses.get(0).getLocality();
        }
        catch (Exception e)
        {
            Log.v(LOGTAG, "Unable to find destination " + mDestinationEditText.getText().toString());
        }


        Route newRoute = new Route(mStartingLocation, mEndingLocation, mLeavingDate, mUser);

        mApi.placeRoute(newRoute, new Callback() {
            @Override
            public void success(Object o, Response response) {
                Log.v(LOGTAG, "YOOO that shit was successful");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.v(LOGTAG, "unable to place route on cloud");
                Log.v(LOGTAG, error.toString());

            }
        });

    }
}
