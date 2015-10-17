package hackatl.com.roadieforpeople;


import android.support.multidex.MultiDexApplication;

/**
 * Created by javier on 10/17/15.
 */
public class RoadieForPeople extends MultiDexApplication
{

    public static final int ROUTE_SUCESS = 1;
    public static final int ROUTE_FAILURE = 2;

    public static final String API_URL = "https://groovy-granite-107306.appspot.com/_ah/api/myApi/v1";

    RouteListener mRouteListener;




    public interface RouteListener
    {
        void onRetrofitResult(int a);
    }
}
