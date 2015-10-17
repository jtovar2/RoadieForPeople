package com.hackatl.roadieforpeople.backend.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.io.Serializable;


/**
 * Created by javier on 10/17/15.
 */
@SuppressWarnings("serial")
@Entity
public class RoadieUser implements Serializable
{
    @Id Long id;
    String firstName;
    String lastName;
    String phoneNumber;


    public Long getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }
}
