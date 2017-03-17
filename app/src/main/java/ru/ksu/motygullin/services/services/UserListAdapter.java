package ru.ksu.motygullin.services.services;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.ksu.motygullin.services.R;
import ru.ksu.motygullin.services.activities.UserDetailActivity;
import ru.ksu.motygullin.services.model.User;


public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private static final String EXTRA_USER = "EXTRA_USER";
    private final Context context;
    ArrayList<User> users;

    public UserListAdapter(Context context) {
        this.context = context;
        this.users = new ArrayList<>();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new UserViewHolder(view);
    }

    public void setUserList(List<User> users) {
        this.users = (ArrayList<User>) users;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User user = users.get(position);

        final String name = user.getName().getFirst();
        final String surname = user.getName().getLast();
        final String email = user.getMail();

        holder.name.setText(name);
        holder.surname.setText(surname);
        holder.email.setText(email);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserDetailActivity.class);

                intent.putExtra(EXTRA_USER, user);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView surname;
        TextView email;
        View view;


        public UserViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            name = (TextView) itemView.findViewById(R.id.name);
            surname = (TextView) itemView.findViewById(R.id.surname);
            email = (TextView) itemView.findViewById(R.id.email);
        }

    }

}
