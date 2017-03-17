package ru.ksu.motygullin.services.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bulat on 17.03.2017 at 18:50.
 */

public class Location implements Serializable {

    @SerializedName("street") public String street;

    @SerializedName("city") public String city;

    @SerializedName("state") public String state;

    @SerializedName("zip") public String zip;
}