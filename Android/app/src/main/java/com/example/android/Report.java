package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Report extends AppCompatActivity {
    int val;
    int length;
    String report;
    TextView textViewReport;
    TextView porcent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        val=getIntent().getIntExtra("val",0);
        length=getIntent().getIntExtra("length",0);
        report=getIntent().getStringExtra("report");
        textViewReport=findViewById(R.id.textViewReport);
        porcent=findViewById(R.id.porcent);
        textViewReport.setText(report);
        double a=(100*val)/length;
        DecimalFormat df = new DecimalFormat("#.00");
        porcent.setText("The exam was completed in a "+df.format(a)+"%");

    }
}