package hackatl.com.roadieforpeople.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by javier on 10/17/15.
 */
public class Route
{
    String endLocation;
    String startLocation;

    ///Geoppoint end and start location

    Date leavingDate;

    Long id;

    RoadieUser driver;

    ArrayList<RoadieUser> commitedUsers;


    public String getStartLocation()
    {
        return startLocation;
    }

    public String getEndLocation()
    {
        return endLocation;
    }

    public Route(String newStartLocation, String newEndLocation, Date newDate, RoadieUser newDriver)
    {
        endLocation = newEndLocation;
        startLocation = newStartLocation;
        leavingDate = newDate;
        commitedUsers = new ArrayList<>();

    }


}
