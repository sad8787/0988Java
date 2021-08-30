package com.example.a21082021;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserlistFragment extends Fragment {


    private User user;
    private Button buttonADD;
    UserAdapter userAdapter;
    ArrayList<User> userList = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        user = (User) bundle.getSerializable("user");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_user_list, viewGroup, false);
        buttonADD=view.findViewById(R.id.addUserBtn);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        buttonADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//ADD USER
                Intent intent = new Intent(getContext(), ADDUserActyvity.class);
                //intent.putExtra("questionIndex", questionIndex);
                startActivity(intent);
            }
        });
        return view;
    }
    private void recyclerViewInit(){
        Users users=new Users(getActivity());
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
            Intent intent=new Intent(getContext(),UserInfoActivity.class);
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
            LayoutInflater inflater = LayoutInflater.from(getContext());
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
