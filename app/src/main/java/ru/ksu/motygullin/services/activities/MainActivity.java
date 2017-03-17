package ru.ksu.motygullin.services.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ru.ksu.motygullin.services.R;
import ru.ksu.motygullin.services.data.UsersRepository;
import ru.ksu.motygullin.services.services.MyIntentService;
import ru.ksu.motygullin.services.services.UserListAdapter;

public class MainActivity extends AppCompatActivity {

    public static final String MY_ACTION = "ru.ksu.motygullin.services.MY_ACTION";
    Button button;
    RecyclerView rv;
    MyBroadcast broadcast;
    UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        rv = (RecyclerView) findViewById(R.id.list);
        broadcast = new MyBroadcast();

        adapter = new UserListAdapter(this);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                startService(intent);
                handleIntent();
            }
        });

        registerReceiver(broadcast, new IntentFilter(MY_ACTION));
    }

    void handleIntent() {
        sendBroadcast(new Intent(MY_ACTION));
    }


    public class MyBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            UsersRepository repository = UsersRepository.getInstance(getBaseContext());

            adapter.setUserList(repository.getUserList());
            rv.setVisibility(View.VISIBLE);
        }
    }
}
