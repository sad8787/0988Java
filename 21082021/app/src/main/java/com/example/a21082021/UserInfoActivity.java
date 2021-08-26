package com.example.a21082021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {

    TextView nameTexView;
    TextView lastNameTexView;
    TextView fonNumberTexView;
    Button delete;
    Button update;
    Button close;
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
        delete=findViewById(R.id.Deletebutton);
        update=findViewById(R.id.Updatebutton);
        close=findViewById(R.id.CloseBtn);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(UserInfoActivity.this,UserDeleteActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
                //delete
                onBackPressed();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserInfoActivity.this,UbdateUserActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
                //ubdate
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