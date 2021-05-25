package com.rahulnaskar.BMICalculator_Test_01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ImageDecoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    //Class Variables; also are called 'Fields'
    private TextView resultText;
    private RadioButton buttonMale;
    private RadioButton buttonFemale;
    private EditText editTextAge;
    private EditText editTextFeet;
    private EditText editTextInches;
    private EditText editTextWeight;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // String AlertText = "Hey YO! Let's see if this works or not.";
        // This is to testify the Android Toast testing ;)
        // Toast.makeText(this, AlertText, Toast.LENGTH_LONG).show();
        findViews();
        setupButtonClickListener();

    }

    private void findViews() {
        // findViewById(R.id.text_view_result);

        resultText = findViewById(R.id.text_view_result);
        buttonMale = findViewById(R.id.radio_button_male);
        buttonFemale = findViewById(R.id.radio_button_female);
        editTextAge = findViewById(R.id.edit_text_age);
        editTextFeet = findViewById(R.id.edit_text_feet);
        editTextInches = findViewById(R.id.edit_text_inches);
        editTextWeight = findViewById(R.id.edit_text_weight);

        buttonCalculate = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "Reacting my first ever button with on click! Wow@_@", Toast.LENGTH_SHORT).show();
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String ageText = editTextAge.getText().toString();
        String feetText = editTextFeet.getText().toString();
        String inchesText = editTextInches.getText().toString();
        String weightText = editTextWeight.getText().toString();

        // resultText.setText("Age: " + ageText + " " + "Feet: " + feetText + " " +"Inches: " + inchesText+ " " + "Weight: " + weightText);

        int age = Integer.parseInt(ageText);
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;
        double heightInMeters = (totalInches) * 0.0254;
        double bmi = weight / (heightInMeters * heightInMeters);

        // double bmiResult = bmi;
        // resultText.setText(bmiResult) ;

        /*
        if(bmiResult<=18.5){
            resultText.setText("Kya Karoge tum zindagi mein");
        }
        else if(bmiResult>=18.5 && bmiResult<=24.9){
            resultText.setText("Bete Mauj Kardi");
        }
        else {
            resultText.setText("Ab toh bas karde bansurike");
        } */
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiResult = myDecimalFormatter.format(bmi);
        String bmiKaResult;

        if (bmi < 18.5) {
            bmiKaResult = bmiResult + "- Underweight";
        } else if (bmi > 25) {
            bmiKaResult = bmiResult + "- Overweight";
        } else {
            bmiKaResult = bmiResult + "- Natural";
        }
        resultText.setText(bmiKaResult);
    }
}

