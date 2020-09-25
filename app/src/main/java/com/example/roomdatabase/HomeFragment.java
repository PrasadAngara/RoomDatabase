package com.example.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener {

    Button badd, bview, bdelete, bupdate;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        badd = v.findViewById(R.id.add_contact);
        bview = v.findViewById(R.id.view_contact);
        bdelete = v.findViewById(R.id.delete_contact);
        bupdate = v.findViewById(R.id.update_contact);
        badd.setOnClickListener(this);
        bview.setOnClickListener(this);
        bdelete.setOnClickListener(this);
        bupdate.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_container, new AddUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.view_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_container, new ReadFragment()).addToBackStack(null).commit();
                break;

            case R.id.delete_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_container, new DeleteFragment()).addToBackStack(null).commit();
                break;
            case R.id.update_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_container, new UpdateFragment()).addToBackStack(null).commit();
                break;
        }
    }
}