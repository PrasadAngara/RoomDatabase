package com.example.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateFragment extends Fragment {


   private EditText uid,uname,uemail;
   private Button bupdate;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_update, container, false);
        uid=v.findViewById(R.id.user_id);
        uname=v.findViewById(R.id.user_name);
        uemail=v.findViewById(R.id.user_email);
        bupdate=v.findViewById(R.id.update_button);
        bupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(uid.getText().toString());
                String name=uname.getText().toString();
                String email=uemail.getText().toString();

                User user=new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabase.myDao().updateUSer(user);
                Toast.makeText(getContext(),"Updated",Toast.LENGTH_LONG).show();
                uid.setText("");
                uname.setText("");
                uemail.setText("");
            }
        });
        return v;
    }
}