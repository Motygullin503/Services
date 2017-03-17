package ru.ksu.motygullin.services.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.ksu.motygullin.services.model.User;

/**
 * Created by Bulat on 17.03.2017 at 19:16.
 */

public class UserResponse {

    @SerializedName("results") private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> mUserList) {
        this.userList = mUserList;
    }
}