package hackatl.com.roadieforpeople;

import java.util.ArrayList;

import hackatl.com.roadieforpeople.model.Route;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by javier on 10/17/15.
 */
public interface RoutesApi
{

    //TODO add all methods from the API and annotate according to Retrofit

    @GET("/getRoutes")
    void getRoutes(String startLocation, Callback<ArrayList<Route>> routes);


    @GET("/getRoute")
    void getRoute(Long routeId)

}
