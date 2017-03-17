package ru.ksu.motygullin.services.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bulat on 17.03.2017 at 18:51.
 */

public class Picture implements Serializable {

    @SerializedName("large") public String large;

    @SerializedName("medium") public String medium;

    @SerializedName("thumbnail") public String thumbnail;
}
