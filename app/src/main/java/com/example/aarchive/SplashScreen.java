package com.example.aarchive;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Apply slow appearance animation to all components
        ImageView imgLogo = findViewById(R.id.imgLogo);
        ImageView imgSplash = findViewById(R.id.imgSplash);

        Animation slowAppearance = AnimationUtils.loadAnimation(this, R.anim.slow_appearance);
        imgSplash.startAnimation(slowAppearance);
        imgLogo.startAnimation(slowAppearance);

        final SharedPreferences sharedPreferences = getSharedPreferences("MainActivity", MODE_PRIVATE);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        }, 2500);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.fade_out_top_to_bottom);
    }
}
