package hackatl.com.roadieforpeople.model;

import java.io.Serializable;

/**
 * Created by javier on 10/18/15.
 */
@SuppressWarnings("serial")
public class RoadieGeoPoint implements Serializable
{
    public double latitude;
    public double longitude;

    public RoadieGeoPoint(double newLat, double newLong)
    {
        longitude = newLong;
        latitude = newLat;
    }
}
