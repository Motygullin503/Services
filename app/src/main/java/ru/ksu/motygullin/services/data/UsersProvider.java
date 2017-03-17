package ru.ksu.motygullin.services.data;

import java.net.URL;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import ru.ksu.motygullin.services.model.User;

/**
 * Created by Bulat on 17.03.2017 at 18:57.
 */

public interface UsersProvider {

   @GET("/")

    Call<UserResponse> getUsers (@Query("results") String results);
}