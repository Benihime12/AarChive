package com.example.aarchive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.GuidedExercises.FirstGuidedExercise;
import com.example.aarchive.GuidedExercises.SecondGuidedExercise;
import com.example.aarchive.GuidedExercises.ThirdGuidedExercise;
import com.example.aarchive.MachineProblems.Calculator;
import com.example.aarchive.MachineProblems.FifthHandsOnExercise;
import com.example.aarchive.MachineProblems.FourthHandsOnExercise;
import com.example.aarchive.MachineProblems.SixthHandsOnExercise;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Button by its ID
        Button btnMp2 = findViewById(R.id.btnMp2);
        Button btnMp4 = findViewById(R.id.btnMp4);
        Button btnMp5 = findViewById(R.id.btnMp5);
        Button btnMp6 = findViewById(R.id.btnMp6);
        Button btnGE1 = findViewById(R.id.btnGE1);
        Button btnGE2 = findViewById(R.id.btnGE2);
        Button btnGE3 = findViewById(R.id.btnGE3);

        // Set an OnClickListener on the Button
        btnMp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calculator.class);
                startActivity(intent);
            }
        });

        btnMp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FourthHandsOnExercise.class);
                startActivity(intent);
            }
        });

        btnMp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FifthHandsOnExercise.class);
                startActivity(intent);
            }
        });

        btnMp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SixthHandsOnExercise.class);
                startActivity(intent);
            }
        });

        btnGE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstGuidedExercise.class);
                startActivity(intent);
            }
        });

        btnGE2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondGuidedExercise.class);
                startActivity(intent);
            }
        });

        btnGE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdGuidedExercise.class);
                startActivity(intent);
            }
        });
    }
}