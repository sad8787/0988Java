package com.example.a21082021;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button buttonADD;
    UserAdapter userAdapter;
    ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ////users
        /*Users users=new Users(MainActivity.this);
        userList=users.getUserslist();*/

        recyclerView = findViewById(R.id.recyclerView);
        buttonADD=findViewById(R.id.ADD);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        buttonADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//ADD USER
                Intent intent = new Intent(MainActivity.this, ADDUserActyvity.class);
                //intent.putExtra("questionIndex", questionIndex);
                startActivity(intent);
            }
        });

        //userAdapter = new UserAdapter(userList);
       // recyclerView.setAdapter(userAdapter);
    }

    private void recyclerViewInit(){
        Users users=new Users(MainActivity.this);
        userList=users.getUserslist();
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }
    @Override
    public void onResume() {
        super.onResume();
        recyclerViewInit();
    }
    private class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView itemTextView;
        User user;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            itemTextView = itemView.findViewById(R.id.itemTextView);
            itemView.setOnClickListener(this);//esto crea un evento onclic separado para cada linea
        }
        public void bind(User user){
            this.user=user;
            itemTextView.setText(this.user.getName()+" "+this.user.getLastname());

        }

        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this,UserInfoActivity.class);
            intent.putExtra("user",user);
            startActivity(intent);
        }
    }

    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        ArrayList<User> users;

        public UserAdapter(ArrayList<User> users) {
            this.users = users;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            User user = users.get(position);
            userHolder.bind(user);
        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }
}