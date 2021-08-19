package com.example.sadiel1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonYes;
    Button buttonNo;
    TextView textViewQuestions;
    Questions[]questions=new Questions[]{
            new Questions(R.string.question1,true),
            new Questions(R.string.question2,true),
            new Questions(R.string.question3,false)
    };
    int questionIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewQuestions.setText(questions[questionIndex].getQuestionsText());

        buttonYes=findViewById(R.id.buttonYes);//tener en cuenta que el id del boton es realmente un int
        buttonYes.setOnClickListener(new View.OnClickListener() {//se crea el evento onclik
            @Override
            public void onClick(View view) {//escribe codigo aqui
                if (questions[questionIndex].isQuestionsTrue())
                    Toast.makeText(MainActivity.this,"Верно",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Не правильным",Toast.LENGTH_LONG).show();

                questionIndex=(questionIndex+1)%questions.length;// es igual if en anterior
                textViewQuestions.setText(questions[questionIndex].getQuestionsText());
            }
        });
        buttonNo=findViewById(R.id.buttonNo);
        buttonNo.setOnClickListener(new View.OnClickListener() {//se crea el evento onclik
            @Override
            public void onClick(View view) {//escribe codigo aqui
                if (!questions[questionIndex].isQuestionsTrue())
                    Toast.makeText(MainActivity.this,"Верно",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Не правильным",Toast.LENGTH_LONG).show();
                if (questionIndex<questions.length-1)
                    questionIndex++;
                else
                    questionIndex=0;
                textViewQuestions.setText(questions[questionIndex].getQuestionsText());
            }
        });
        textViewQuestions=findViewById(R.id.textViewQuestions);

    }
}