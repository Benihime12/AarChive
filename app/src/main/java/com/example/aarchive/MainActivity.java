package com.example.aarchive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.GuidedExercises.EigthGuidedExercise;
import com.example.aarchive.GuidedExercises.EleventhGuidedExercise;
import com.example.aarchive.GuidedExercises.EleventhPracticeExercise2;
import com.example.aarchive.GuidedExercises.FifthGuidedExercise;
import com.example.aarchive.GuidedExercises.FirstGuidedExercise;
import com.example.aarchive.GuidedExercises.FourthGuidedExercise;
import com.example.aarchive.GuidedExercises.NinthGuidedExercise;
import com.example.aarchive.GuidedExercises.SQLiteDatabaseDemo;
import com.example.aarchive.GuidedExercises.SecondGuidedExercise;
import com.example.aarchive.GuidedExercises.SeventhGuidedExercise;
import com.example.aarchive.GuidedExercises.SixthGuidedExercise;
import com.example.aarchive.GuidedExercises.TenthGuidedExercise;
import com.example.aarchive.GuidedExercises.ThirdGuidedExercise;
import com.example.aarchive.GuidedExercises.TwelfthPracticeExercise;
import com.example.aarchive.MachineProblems.Calculator;
import com.example.aarchive.MachineProblems.FifthHandsOnExercise;
import com.example.aarchive.MachineProblems.FourthHandsOnExercise;
import com.example.aarchive.MachineProblems.SixthHandsOnExercise;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Machine Problems
        Button btnMp2 = findViewById(R.id.btnMp2);
        Button btnMp4 = findViewById(R.id.btnMp4);
        Button btnMp5 = findViewById(R.id.btnMp5);
        Button btnMp6 = findViewById(R.id.btnMp6);

        //Guided Exercises
        Button btnGE1 = findViewById(R.id.btnGE1);
        Button btnGE2 = findViewById(R.id.btnGE2);
        Button btnGE3 = findViewById(R.id.btnGE3);
        Button btnGE4 = findViewById(R.id.btnGE4);
        Button btnGE5 = findViewById(R.id.btnGE5);
        Button btnGE6 = findViewById(R.id.btnGE6);
        Button btnGE7 = findViewById(R.id.btnGE7);
        Button btnGE8 = findViewById(R.id.btnGE8);
        Button btnGE9 = findViewById(R.id.btnGE9);
        Button btnGE10 = findViewById(R.id.btnGE10);
        Button btnGE11 = findViewById(R.id.btnGE11);
        Button btnAddImages = findViewById(R.id.btnAddImages);
        Button btnappIcon = findViewById(R.id.btnappIcon);
        Button btnsqlite = findViewById(R.id.btnsqlite);

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

        btnGE4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FourthGuidedExercise.class);
                startActivity(intent);
            }
        });

        btnGE5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FifthGuidedExercise.class);
                startActivity(intent);
            }
        });

        btnGE6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SixthGuidedExercise.class);
                startActivity(intent);
            }
        });

        btnGE7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeventhGuidedExercise.class);
                startActivity(intent);
            }
        });

        btnGE8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EigthGuidedExercise.class);
                startActivity(intent);
            }
        });

        btnGE9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NinthGuidedExercise.class);
                startActivity(intent);
            }
        });

        btnGE10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TenthGuidedExercise.class);
                startActivity(intent);
            }
        });

        btnGE11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EleventhGuidedExercise.class);
                startActivity(intent);
            }
        });

        btnAddImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EleventhPracticeExercise2.class);
                startActivity(intent);
            }
        });

        btnappIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TwelfthPracticeExercise.class);
                startActivity(intent);
            }
        });

        btnsqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SQLiteDatabaseDemo.class);
                startActivity(intent);
            }
        });

    }
}