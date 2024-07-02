package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weight, htft, htin;
        Button btnCalculate;
        TextView result;
        LinearLayout Llmain;

        weight = findViewById(R.id.weight); //here R stands for the resource class which fetches the value of that particular id defined
        htft = findViewById(R.id.htft);
        htin = findViewById(R.id.htin);
        btnCalculate = findViewById(R.id.btnCalculate);
        result = findViewById(R.id.result);
        Llmain = findViewById(R.id.Llmain);

        //on click listener is an interface which have the onclick method pre written which we later on override to make it do OUR work on that prewritten class defined in the onclicklistener interface
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            //here we can see that the onclick method in the onclicklistener interface have been overridden
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(weight.getText().toString()); // we did this because whenever we fetch the value from the xml file, we recieve it in the editable format, so we have to convert it into integer for this case to perform the operations, we did this by converting the editable format to string by the toString method and them parsing the string to integer.
                int htF = Integer.parseInt(htft.getText().toString());
                int htI = Integer.parseInt(htin.getText().toString());

                int totalinch = htF*12 + htI;
                double totalCm = totalinch*2.53;
                double totalMeter = totalCm/100;

                double bmi = wt/(totalMeter*totalMeter);

                if(bmi>25){
                    result.setText("You are Over Weight!");
                    Llmain.setBackgroundColor(getResources().getColor(R.color.over));
                } else if (bmi<18) {
                    result.setText("You are Under Weight!");
                    Llmain.setBackgroundColor(getResources().getColor(R.color.under));
                } else{
                    result.setText("Your BMI is in Normal, you're a Healthy Person!");
                    Llmain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });

    }
}