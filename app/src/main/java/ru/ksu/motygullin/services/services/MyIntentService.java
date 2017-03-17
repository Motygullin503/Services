package ru.ksu.motygullin.services.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ksu.motygullin.services.data.UserResponse;
import ru.ksu.motygullin.services.data.UsersProvider;
import ru.ksu.motygullin.services.data.UsersRepository;
import ru.ksu.motygullin.services.model.User;

/**
 * Created by UseR7 on 11.03.2017.
 */

public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        UsersRepository repository = UsersRepository.getInstance(this);

        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.randomuser.me/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Call<UserResponse> usersCall;
            UsersProvider randomUser = retrofit.create(UsersProvider.class);
            usersCall = randomUser.getUsers("10");


            List<User> users;
            Response<UserResponse> response = usersCall.execute();

            UserResponse userResponse = response.body();
            users = userResponse.getUserList();

//            Toast.makeText(this, "you Started Intent Service "+users.size(), Toast.LENGTH_SHORT).show();

            repository.saveUsers(users);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void onDestroy() {
        Log.println(Log.WARN, "END", "new IService");
    }
}
