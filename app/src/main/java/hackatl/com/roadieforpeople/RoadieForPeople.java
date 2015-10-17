package hackatl.com.roadieforpeople;


import android.app.Activity;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import java.util.ArrayList;

import hackatl.com.roadieforpeople.model.Route;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by javier on 10/17/15.
 */
public class RoadieForPeople extends MultiDexApplication
{
    public static final String LOGTAG = "Roadie Application";
    public static final int ROUTE_SUCESS = 1;
    public static final int ROUTE_FAILURE = 2;

    public static final String API_URL = "https://groovy-granite-107306.appspot.com/_ah/api/myApi/v1";

    RouteListener mRouteListener;

    ArrayList<Route> mRoutes;
    private static RoutesApi mApi;
    private static RestAdapter mRestAdapter;

    public ArrayList<Route> getRoutes()
    {
        return mRoutes;
    }

    public void generateRoutes(String startLocation)
    {
        if(mRestAdapter == null)
        {
            createRestAdapter();
        }

        if(mApi == null)
        {
            createApi();
        }


        mApi.getRoutes(startLocation, new Callback<ArrayList<Route>>() {
            @Override
            public void success(ArrayList<Route> routes, Response response)
            {

                mRoutes = routes;
                mRouteListener.onRetrofitResult(ROUTE_SUCESS);
            }

            @Override
            public void failure(RetrofitError error)
            {
                Log.v(LOGTAG, "Unable to download routes");
                Log.v(LOGTAG, error.toString());
                Log.v(LOGTAG, error.getUrl());
            }
        });
    }

    public void createRestAdapter()
    {
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
    }


    public void createApi()
    {
        mApi = mRestAdapter.create(RoutesApi.class);
    }

    public interface RouteListener
    {
        void onRetrofitResult(int a);
    }

    public void setRouteListener(Activity a)
    {
        mRouteListener = (RouteListener) a;
    }
}
