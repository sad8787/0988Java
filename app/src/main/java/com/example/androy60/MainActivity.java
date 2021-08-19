package com.example.androy60;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    Button buttonYes;
    Button buttonNo;
    TextView textViewQuestions;
    Question[]questions=new Question[]{
            new Question(R.string.question1,true),
            new Question(R.string.question2,true),
            new Question(R.string.question3,false)
    };
    int questionIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonYes=findViewById(R.id.y)
        textViewQuestions.setText(questions[questionIndex].getQuestionsText());
    }
}