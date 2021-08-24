package com.example.a21082021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {

    TextView nameTexView;
    TextView lastNameTexView;
    TextView fonNumberTexView;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        nameTexView=findViewById(R.id.Name);
        lastNameTexView=findViewById(R.id.LastName);
        fonNumberTexView=findViewById(R.id.FonNumber);
        user=(User) getIntent().getSerializableExtra("user");
        nameTexView.setText(user.getName());
        lastNameTexView.setText(user.getLastname());
        fonNumberTexView.setText(user.getFonNomer());
    }
}