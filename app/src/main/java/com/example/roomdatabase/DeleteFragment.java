package com.example.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteFragment extends Fragment {


private EditText TextUserId;
private Button delete_button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_delete, container, false);
        TextUserId=v.findViewById(R.id.userID);
        delete_button=v.findViewById(R.id.delete_userID);
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(TextUserId.getText().toString());
                User user=new User();
                user.setId(id);
                MainActivity.myAppDatabase.myDao().deletUser(user);
                Toast.makeText(getContext(),"user with id"+id ,Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }
}