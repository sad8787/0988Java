package com.example.android;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SolutionActivity extends AppCompatActivity {
    private TextView answerTextView;
    private TextView explanationsTextView;
    private int textExplanations;
    private boolean isAnswerTrue;
    private int questionIndex;
    private Button buttonOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        isAnswerTrue = getIntent().getBooleanExtra("Solution", false);
        textExplanations=getIntent().getIntExtra("Explanations",1);
        questionIndex=getIntent().getIntExtra("questionIndex",1);
        explanationsTextView=findViewById(R.id.textExplanations);
        explanationsTextView.setText(textExplanations);
        answerTextView = findViewById(R.id.textQuestion);
        answerTextView.setText(isAnswerTrue?R.string.Yes:R.string.No);
        //Button
        buttonOK=findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SolutionActivity.this, MainActivity.class);
                intent.putExtra("questionIndex", questionIndex);
                startActivity(intent);
            }
        });

    }
}