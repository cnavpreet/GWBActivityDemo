package com.auribises.gwbactivitydemo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishantkumar on 11/07/17.
 */

public class UserAdapter extends ArrayAdapter<User> {

    Context context;
    int resource;
    ArrayList<User> userList;

    public UserAdapter(Context context, int resource, ArrayList<User> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        userList = objects;
    }

    // getView method shall be executed n number of time from 0 to n-1
    // n is the size of ArrayList
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = null;

        //view should point to list_item
        view = LayoutInflater.from(context).inflate(resource,parent,false);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TextView txtName = (TextView)view.findViewById(R.id.textViewName);
        TextView txtPhone = (TextView)view.findViewById(R.id.textViewPhone);

        User user = userList.get(position);
        imageView.setBackgroundResource(user.getIcon());
        txtName.setText(user.getName());
        txtPhone.setText(user.getPhone());

        return view;
    }
}
