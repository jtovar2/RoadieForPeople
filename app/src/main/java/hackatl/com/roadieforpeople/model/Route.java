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

    Date leavingDate;

    Long id;

    RoadieUser driver;

    ArrayList<RoadieUser> commitedUsers;



}
