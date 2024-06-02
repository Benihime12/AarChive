package com.example.aarchive.GuidedExercises;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

public class FirstGuidedExercise extends AppCompatActivity {

        EditText name, age;
        TextView result;
        Button click;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_first_guided_exercise);

            ImageButton btnBackGE1 = findViewById(R.id.btnBackGE1);
            btnBackGE1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(FirstGuidedExercise.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    finish();
                }
            });

            name = findViewById(R.id.etNameGE1);
            age = findViewById(R.id.etAgeGE1);
            result = findViewById(R.id.tvResultGE1);
            click = findViewById(R.id.btnClickGE1);
            // calling our user-defined method named showResult()
            showResult();
        }
        public void showResult(){
            // using .setOnClickListener for button click
            click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // this will set the text value of the result
                    result.setText("Name: " + name.getText().toString() +
                            "\nAge: " + age.getText().toString());
                    // this will clear the text value of name and age
                    name.setText("");
                    age.setText("");
                    // this will set the cursor to name
                    name.requestFocus();
                }
            });
        }
    }
