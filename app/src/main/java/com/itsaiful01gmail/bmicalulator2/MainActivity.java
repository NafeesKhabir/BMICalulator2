package com.itsaiful01gmail.bmicalulator2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    TextView height,weight;
    EditText feet,inch,kg;
    Button calculate;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        height = (TextView) findViewById(R.id.height);
        weight = (TextView) findViewById(R.id.weight);
        feet = (EditText) findViewById(R.id.feet);
        inch = (EditText) findViewById(R.id.inch);
        kg = (EditText) findViewById(R.id.kg);
        calculate = (Button) findViewById(R.id.calculate);
        result = (TextView) findViewById(R.id.result);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }
    private void calculateBMI() {
        String feetstr = feet.getText().toString();
        String inchstr = inch.getText().toString();
        String kgstr = kg.getText().toString();
        if (feetstr != null && !"".equals(feetstr) && inchstr != null && !"".equals(inchstr)&& kgstr != null && !"".equals(kgstr)) {
            float feetValue = Float.parseFloat(feetstr);
            float inchValue = Float.parseFloat(inchstr);
            float kgValue = Float.parseFloat(kgstr);
            float Height = ((feetValue*12)+inchValue);
            float Height = (Height*2.5)/100;
            float bmi = kgValue / (Height*Height);
            displayBMI(bmi);
        }
    }
    private void displayBMI(float bmi){
        String bmiLabel="";
        if (Float.compare(bmi,15f)<=0){
            bmiLabel="Very Severely underweight";}
        else if(Float.compare(bmi,15f)>0 && Float.compare(bmi,16f)<=0){
            bmiLabel="Severely underweight";}
        else if (Float.compare(bmi,16f)>0 && Float.compare(bmi,18.5f)<=0){
            bmiLabel="underweight";}
        else if (Float.compare(bmi,18.5f)>0 && Float.compare(bmi,25f)<=0){
            bmiLabel="normal";}
        else if (Float.compare(bmi,25f)>0 && Float.compare(bmi,30f)<=0){
            bmiLabel="overweight";}
        else if (Float.compare(bmi,30f)>0 && Float.compare(bmi,35f)<=0){
            bmiLabel="obese class 1";}
        else if (Float.compare(bmi,35f)>0 && Float.compare(bmi,40f)<=0){
            bmiLabel="obese class 2";}
        else{
            bmiLabel="obese class 3";}

        bmiLabel="Result"+" "+ bmi + "\n" + bmiLabel;
        result.setText(bmiLabel);
    }
}
