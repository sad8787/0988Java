package com.example.android;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonYes;
    Button buttonNo;
    Button buttonSolution;
    TextView textViewQuestions;


    Question[] questions=new Question[]{
            new Question(R.string.question1,true,R.string.explanations1),
            new Question(R.string.question2,true,R.string.explanations2),
            new Question(R.string.question3,false,R.string.explanations3)
    };
    int questionIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!=null)
        {//recuperando valores
            questionIndex=savedInstanceState.getInt("questionIndex");

        }

        textViewQuestions=findViewById(R.id.textQuestion);
        textViewQuestions.setText(questions[questionIndex].getQuestionsText());

        //open new window
        buttonSolution=findViewById(R.id.ButtonSolution);
        buttonSolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SolutionActivity.class);
                intent.putExtra("Solution", questions[questionIndex].isQuestionsTrue());
                intent.putExtra("Explanations", questions[questionIndex].getExplanations());
                intent.putExtra("questionIndex", questionIndex);
                startActivity(intent);
            }
        });

        buttonYes=findViewById(R.id.ButtonYes);//tener en cuenta que el id del boton es realmente un int
        buttonYes.setOnClickListener(new View.OnClickListener() {//se crea el evento onclik
            @Override
            public void onClick(View view) {//escribe codigo aqui
                if (questions[questionIndex].isQuestionsTrue())
                    Toast.makeText(MainActivity.this,"Верно",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Не правильным",Toast.LENGTH_LONG).show();
                questions[questionIndex].setAnswer(true);
                //questionIndex=(questionIndex+1)%questions.length;// es igual if en anterior
                questionIndex++;
                if(questionIndex>=questions.length)
                    report();
                else
                    textViewQuestions.setText(questions[questionIndex].getQuestionsText());

            }
        });
        buttonNo=findViewById(R.id.ButtonNo);
        buttonNo.setOnClickListener(new View.OnClickListener() {//se crea el evento onclik
            @Override
            public void onClick(View view) {//escribe codigo aqui
                if (!questions[questionIndex].isQuestionsTrue())
                    Toast.makeText(MainActivity.this,"Верно",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Не правильным",Toast.LENGTH_LONG).show();
                questions[questionIndex].setAnswer(false);
                //questionIndex=(questionIndex+1)%questions.length;// es igual if en anterior
                questionIndex++;
                if(questionIndex>=questions.length)
                    report();
                else
                    textViewQuestions.setText(questions[questionIndex].getQuestionsText());

            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("questionIndex", questionIndex);
    }

    protected void report(){
        String report="";
        int val=0;
        for (int i=0;i<questions.length;i++) {
            if(questions[i].Thatsright()){
                val++;
                report+="Question number "+(i+1)+" You have answered correctly \n";
            }
            else
                report+="Question number "+(i+1)+" You have answered incorrect\n";
        }

        Intent intent = new Intent(MainActivity.this, Report.class);
        intent.putExtra("val", val);
        intent.putExtra("length", questions.length);
        intent.putExtra("report",report);
        startActivity(intent);

    }




}