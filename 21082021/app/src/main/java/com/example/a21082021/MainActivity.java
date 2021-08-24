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
    Button buttonOk;
    UserAdapter userAdapter;
    ArrayList<User> userList = new ArrayList<>();
    String[] names={"Sadiel","Rafael","Juan","Michel","Maria","Elena","Roza",
                                "Firulay","Fulano","Mengano","Putin"};
    String[] lastNames={"Sadiel","Rafael","Juan","Michel","Maria","Elena","Roza",
            "Firulay","Fulano","Mengano","Putin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 1; i < 30; i++) {
            int a=i%11;
            String x=names[a];
            User user=new User();
            user.setName(names[a]);
            user.setLastname(lastNames[a]);
            user.setFonNumber("+796388555456");
            userList.add(user);
        }

        recyclerView = findViewById(R.id.recyclerView);
        buttonOk=findViewById(R.id.OK);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
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