package hackatl.com.roadieforpeople;

import java.util.ArrayList;

import hackatl.com.roadieforpeople.model.Route;
import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by javier on 10/17/15.
 */
public interface RoutesApi
{

    //TODO add all methods from the API and annotate according to Retrofit

    @GET("/getRoutes")
    void getRoutes(String startLocation, Callback<ArrayList<Route>> routes);


    @POST("/placeRoute")
    void placeRoute(Route newRoute);

    @DELETE("/deleteRoute")
    void deleteRoute(Long routeId);



}
