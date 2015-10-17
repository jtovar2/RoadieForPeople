package com.hackatl.roadieforpeople.backend.model;

import com.google.appengine.repackaged.org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by javier on 10/17/15.
 */
@SuppressWarnings("serial")
@JsonSerialize
public class RoadieGeoPoint implements Serializable
{

    double latitude;
    double longitude;

    public RoadieGeoPoint()
    {}
}
