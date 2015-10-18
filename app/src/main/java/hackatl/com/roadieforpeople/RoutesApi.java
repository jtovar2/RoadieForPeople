package hackatl.com.roadieforpeople;

import java.util.ArrayList;

import hackatl.com.roadieforpeople.model.Route;
import hackatl.com.roadieforpeople.model.Routes;
import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by javier on 10/17/15.
 */
public interface RoutesApi
{

    //TODO add all methods from the API and annotate according to Retrofit

    @GET("/routecollection/{startLocation}")
    void getRoutes(@Path("startLocation")String startLocation, Callback<Routes> routes);


    @POST("/placeRoute")
    void placeRoute(Route newRoute, Callback callback);

    @DELETE("/deleteRoute")
    void deleteRoute(Long routeId);



}
