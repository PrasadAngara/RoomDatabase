package com.example.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ReadFragment extends Fragment {

private TextView textinfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_read, container, false);
        textinfo=v.findViewById(R.id.text_display);

        List<User> users=MainActivity.myAppDatabase.myDao().getUsers();

        String info="";

        for (User usr:users)
        {
            int id=usr.getId();
            String name=usr.getName();
            String email=usr.getEmail();

            info=info+"\n\n"+"Id :"+id+"\n"+"Name :"+name+"\n"+"Email :"+email;
        }
textinfo.setText(info);

        return v;
    }
}