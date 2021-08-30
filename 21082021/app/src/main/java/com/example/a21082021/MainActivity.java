package com.example.a21082021;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
FragmentManager fragmentManager=getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Создаём фрагмент
        Fragment fragment = new UserlistFragment();
        fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
    }

}