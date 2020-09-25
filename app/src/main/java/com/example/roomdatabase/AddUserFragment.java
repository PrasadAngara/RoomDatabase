package com.example.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddUserFragment extends Fragment {

    private EditText UserId, UserName, UserEmail;
    Button bsave;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_user, container, false);
        UserId = v.findViewById(R.id.user_id);
        UserName = v.findViewById(R.id.user_name);
        UserEmail = v.findViewById(R.id.user_email);
        bsave = v.findViewById(R.id.button);
        bsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(UserId.getText().toString());
                String username = UserName.getText().toString();
                String useremail = UserEmail.getText().toString();
                User user = new User();
                user.setId(id);
                user.setName(username);
                user.setEmail(useremail);
                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getContext(), "use added", Toast.LENGTH_LONG).show();
                UserId.setText("");
                UserEmail.setText("");
                UserName.setText("");

            }
        });
        return v;
    }
}