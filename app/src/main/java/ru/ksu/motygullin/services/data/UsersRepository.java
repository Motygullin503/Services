package ru.ksu.motygullin.services.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import ru.ksu.motygullin.services.model.User;

/**
 * Created by Bulat on 18.03.2017 at 00:20.
 */

public class UsersRepository {
    private static final String USER_PREFERENCES = "users";
    private static final String USERNAME = "name";
    private static UsersRepository ourInstance;
    private Context context;

    private UsersRepository(@NonNull Context context) {
        this.context = context;
    }

    public static UsersRepository getInstance(@NonNull Context context) {
        if (ourInstance == null) {
            ourInstance = new UsersRepository(context.getApplicationContext());
        }
        return ourInstance;
    }

    public void saveUsers(List<User> userList) {
        SharedPreferences preferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<User>>() {
        }.getType();
        String jsonText = gson.toJson(userList, listType);
        editor.putString(USERNAME, jsonText);
        editor.commit();
    }

    public List<User> getUserList() {
        SharedPreferences preferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE);
        if (preferences.contains(USERNAME)) {
            Gson gson = new Gson();
            String jsonText = preferences.getString(USERNAME, "");
            Type listType = new TypeToken<List<User>>() {
            }.getType();
            List<User> contacts = gson.fromJson(jsonText, listType);
            return contacts;
        } else {
            List<User> users = new java.util.ArrayList();

            saveUsers(users);
            return users;
        }
    }
}
