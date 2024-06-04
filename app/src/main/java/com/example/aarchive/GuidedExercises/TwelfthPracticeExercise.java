package com.example.aarchive.GuidedExercises;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

import java.util.Random;

public class TwelfthPracticeExercise extends AppCompatActivity {

    private ConstraintLayout layout;
    private int[] images = {
            R.drawable.miming1,
            R.drawable.miming2,
            R.drawable.miming3,
            R.drawable.karina,
            R.drawable.yeji,
            R.drawable.mina,
            R.drawable.aiah
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelfth_practice_exercise);

        layout = findViewById(R.id.mainBG);
        Button btnClickPE12 = findViewById(R.id.btnClickPE12);
        ImageButton btnBackPE12 = findViewById(R.id.btnBackPE12);

        btnClickPE12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBackground();
            }
        });

        btnBackPE12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwelfthPracticeExercise.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }

    private void changeBackground() {
        Random random = new Random();
        int index = random.nextInt(images.length);
        layout.setBackgroundResource(images[index]);
    }
}
