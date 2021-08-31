package com.example.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import android.app.AlertDialog;
import android.content.DialogInterface;
public class UserInfoFragment extends Fragment {
    private TextView userNameTextView;
    private TextView phoneTextView;
    private User user;
    private Button editUserDataBtn;
    private Button deleteUserBtn;
    private Button backBtn;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        user = (User) bundle.getSerializable("user");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_user_info, viewGroup, false);
        userNameTextView = view.findViewById(R.id.userNameTextView);
        phoneTextView = view.findViewById(R.id.phoneTextView);
        userNameTextView.setText(user.getUserName()+"\n"+user.getUserLastName());
        phoneTextView.setText(user.getPhone());
        editUserDataBtn = view.findViewById(R.id.editUserDataBtn);
        deleteUserBtn = view.findViewById(R.id.deleteUserBtn);
        backBtn=view.findViewById(R.id.back);
        editUserDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddUserActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);

            }
        });
        deleteUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Users users = new Users(getActivity());
                users.deleteUser(user.getUuid());
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
