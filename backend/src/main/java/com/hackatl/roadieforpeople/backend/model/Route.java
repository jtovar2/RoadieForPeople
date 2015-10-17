package com.hackatl.roadieforpeople.backend.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by javier on 10/16/15.
 */

@SuppressWarnings("serial")
@Entity
public class Route implements Serializable
{
    @Index
    String endLocation;
    @Index
    String startLocation;

    @Index
    Date leavingDate;

    @Id Long id;


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

    public Long getId()
    {
        return id;

    }


    public RoadieUser getDriver()
    {
        return driver;
    }


    public Date getLeavingDate()
    {
        return leavingDate;
    }


    public ArrayList<RoadieUser> getCommitedUsers()
    {
        return commitedUsers;
    }

    public void addUser(RoadieUser newUser)
    {
        commitedUsers.add(newUser);
    }
}
