package com.example.aarchive.GuidedExercises;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

public class ThirdGuidedExercise extends AppCompatActivity {

    EditText num1, num2;
    Button sum, ave;
    double firstNum = 0, secondNum = 0, total = 0;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_guided_exercise);
        num1 = findViewById(R.id.etNum1GE3);
        num2 = findViewById(R.id.etNum2GE3);
        sum = findViewById(R.id.btnSumGE3);
        ave = findViewById(R.id.btnAveGE3);
        computeTotal();

        ImageButton btnBackGE3 = findViewById(R.id.btnBackGE3);
        btnBackGE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdGuidedExercise.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }

    public void computeTotal() {
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInputValid()) {
                    firstNum = Double.parseDouble(num1.getText().toString());
                    secondNum = Double.parseDouble(num2.getText().toString());
                    total = firstNum + secondNum;
                    Toast.makeText(getApplicationContext(),
                            "SUM: " + total, Toast.LENGTH_SHORT).show();
                }
            }
        });

        ave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInputValid()) {
                    firstNum = Double.parseDouble(num1.getText().toString());
                    secondNum = Double.parseDouble(num2.getText().toString());
                    total = (firstNum + secondNum) / 2;
                    Toast.makeText(getApplicationContext(),
                            "AVE: " + total, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isInputValid() {
        if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
            displayErrorMessage();
            return false;
        }
        try {
            Double.parseDouble(num1.getText().toString());
            Double.parseDouble(num2.getText().toString());
        } catch (NumberFormatException e) {
            displayErrorMessage();
            return false;
        }
        return true;
    }

    private void displayErrorMessage() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_2, findViewById(R.id.custom_toast_container));
        TextView text = layout.findViewById(R.id.text);
        text.setText("Please enter a Number" );

        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 300);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
