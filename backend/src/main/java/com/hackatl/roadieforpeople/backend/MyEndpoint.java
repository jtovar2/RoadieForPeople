/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.hackatl.roadieforpeople.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.hackatl.roadieforpeople.backend.model.Route;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.roadieforpeople.hackatl.com",
                ownerName = "backend.roadieforpeople.hackatl.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }


    public List<Route> getRoutes(@Named("startLocation") String startLocation)
    {
        List<Route> routes = OfyService.ofy().load().type(Route.class).filter("startLocation = ", startLocation).list();

        return routes;
    }

    public Route getRoute(@Named("id") Long routeId)
    {
        Route route = OfyService.ofy().load().type(Route.class).id(routeId).now();

        return route;
    }

    public void placeRoute(Route newRoute)
    {
        OfyService.ofy().save().entities(newRoute).now();

    }

    public void deleteRoute(@Named("id") Long routeId)
    {
        OfyService.ofy().delete().type(Route.class).id(routeId);
    }
}
