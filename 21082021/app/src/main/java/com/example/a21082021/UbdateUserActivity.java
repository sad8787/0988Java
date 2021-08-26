package com.example.a21082021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class UbdateUserActivity extends AppCompatActivity {
    User user;

    TextView nameu;
    TextView lastNameu;
    TextView fonNumberu;
    Button update;
    Button close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubdate_user);
        user=(User) getIntent().getSerializableExtra("user");

        nameu=findViewById(R.id.nameu);
        lastNameu=findViewById(R.id.lastNameu);
        fonNumberu=findViewById(R.id.fonNumberu);
        update=findViewById(R.id.Updateu);
        close=findViewById(R.id.Backu);

        nameu.setText(user.getName());
        lastNameu.setText(user.getLastname());
        fonNumberu.setText(user.getFonNomer());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users users=new Users(UbdateUserActivity.this);
                user.setName(nameu.getText().toString());
                user.setLastname(lastNameu.getText().toString());
                user.setFonNumber(fonNumberu.getText().toString());
                users.ubdateUser(user);
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