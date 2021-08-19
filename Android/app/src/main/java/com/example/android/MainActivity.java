package com.example.android;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonYes;
    Button buttonNo;
    TextView textViewQuestions;
    Question[] questions=new Question[]{
            new Question(R.string.question1,true),
            new Question(R.string.question2,true),
            new Question(R.string.question3,false)
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

        buttonYes=findViewById(R.id.ButtonYes);//tener en cuenta que el id del boton es realmente un int
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
        buttonNo=findViewById(R.id.ButtonNo);
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


    }


    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("questionIndex", questionIndex);
    }
   /* @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        questionIndex = savedInstanceState.getInt("questionIndex");

    }*/

}