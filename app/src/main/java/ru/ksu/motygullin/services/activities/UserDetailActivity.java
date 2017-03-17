package ru.ksu.motygullin.services.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import ru.ksu.motygullin.services.R;
import ru.ksu.motygullin.services.model.User;

/**
 * Created by Bulat on 17.03.2017 at 19:12.
 */

public class UserDetailActivity extends AppCompatActivity {
    private static final String EXTRA_USER = "EXTRA_USER";
    User user;
    EditText name;
    EditText surname;
    EditText email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);


        name = (EditText) findViewById(R.id.et1);
        surname = (EditText) findViewById(R.id.et2);
        email = (EditText) findViewById(R.id.et3);
        getExtrasFromIntent();
    }


    void getExtrasFromIntent() {
        user = (User) getIntent().getSerializableExtra(EXTRA_USER);
        name.setText(user.getName().getFirst());
        surname.setText(user.getName().getLast());
        email.setText(user.getMail());

    }

}
