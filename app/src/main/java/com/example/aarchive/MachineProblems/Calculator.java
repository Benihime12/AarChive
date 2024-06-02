package com.example.aarchive.MachineProblems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        ImageButton btnBackmp1 = findViewById(R.id.btnBackmp1);
        btnBackmp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculator.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }

    public void Add(View view) {
        EditText et1 = (EditText) findViewById(R.id.etFirstNumber);
        EditText et2 = (EditText) findViewById(R.id.etSecondNumber);
        TextView et3 = (TextView) findViewById(R.id.tvResult);

        if (TextUtils.isEmpty(et1.getText()) || TextUtils.isEmpty(et2.getText())) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(et1.getText().toString());
        double n2 = Double.parseDouble(et2.getText().toString());
        double result = n1 + n2;

        et3.setText("The Result is: " + result);

        if (result % 2 == 0) {
            et3.setTextColor(Color.BLUE);
        } else {
            et3.setTextColor(Color.RED);
        }
    }

    public void Subtract(View view) {
        EditText et1 = (EditText) findViewById(R.id.etFirstNumber);
        EditText et2 = (EditText) findViewById(R.id.etSecondNumber);
        TextView et3 = (TextView) findViewById(R.id.tvResult);

        if (TextUtils.isEmpty(et1.getText()) || TextUtils.isEmpty(et2.getText())) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(et1.getText().toString());
        double n2 = Double.parseDouble(et2.getText().toString());
        double result = n1 - n2;

        et3.setText("The Result is: " + result);

        if (result % 2 == 0) {
            et3.setTextColor(Color.BLUE);
        } else {
            et3.setTextColor(Color.RED);
        }
    }

    public void Multiply(View view) {
        EditText et1 = (EditText) findViewById(R.id.etFirstNumber);
        EditText et2 = (EditText) findViewById(R.id.etSecondNumber);
        TextView et3 = (TextView) findViewById(R.id.tvResult);

        if (TextUtils.isEmpty(et1.getText()) || TextUtils.isEmpty(et2.getText())) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(et1.getText().toString());
        double n2 = Double.parseDouble(et2.getText().toString());
        double result = n1 * n2;

        et3.setText("The Result is: " + result);

        if (result % 2 == 0) {
            et3.setTextColor(Color.BLUE);
        } else {
            et3.setTextColor(Color.RED);
        }
    }

    public void Divide(View view) {
        EditText et1 = (EditText) findViewById(R.id.etFirstNumber);
        EditText et2 = (EditText) findViewById(R.id.etSecondNumber);
        TextView et3 = (TextView) findViewById(R.id.tvResult);

        if (TextUtils.isEmpty(et1.getText()) || TextUtils.isEmpty(et2.getText())) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(et1.getText().toString());
        double n2 = Double.parseDouble(et2.getText().toString());
        double result = n1 / n2;

        et3.setText("The Result is: " + result);

        if (result % 2 == 0) {
            et3.setTextColor(Color.BLUE);
        } else {
            et3.setTextColor(Color.RED);
        }
    }
}
