package ru.ksu.motygullin.services.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bulat on 17.03.2017 at 18:53.
 */

public class Login implements Serializable {

    @SerializedName("username") public String userName;
}