package com.example.a21082021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserDeleteActivity extends AppCompatActivity {

    TextView nameTexView;
    TextView lastNameTexView;
    TextView fonNumberTexView;
    Button delete;
    Button close;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_delete);

        nameTexView=findViewById(R.id.Name);
        lastNameTexView=findViewById(R.id.LastName);
        fonNumberTexView=findViewById(R.id.FonNumber);
        user=(User) getIntent().getSerializableExtra("user");
        nameTexView.setText(user.getName());
        lastNameTexView.setText(user.getLastname());
        fonNumberTexView.setText(user.getFonNomer());
        delete=findViewById(R.id.buttonDelete);
        close=findViewById(R.id.ButtonBack);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users users=new Users(UserDeleteActivity.this);
                users.deleteUser(user);
                onBackPressed();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}