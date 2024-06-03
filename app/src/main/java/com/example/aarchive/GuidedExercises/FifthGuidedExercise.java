package com.example.aarchive.GuidedExercises;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

public class FifthGuidedExercise extends AppCompatActivity {

    RadioButton red, blue, yellow, green;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_guided_exercise);
        red = findViewById(R.id.rbRed);
        blue = findViewById(R.id.rbBlue);
        yellow = findViewById(R.id.rbYellow);
        green = findViewById(R.id.rbGreen);
        constraintLayout = findViewById(R.id.rootLayout);

        ImageButton btnBackGE5 = findViewById(R.id.btnBackGE5);
        btnBackGE5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FifthGuidedExercise.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }

    public void showSelectedColor() {
        final Handler handler = new Handler();
        final Toast toast;
        if (red.isChecked()) {
            toast = Toast.makeText(getApplicationContext(), "Color: RED", Toast.LENGTH_SHORT);
        } else if (blue.isChecked()) {
            toast = Toast.makeText(getApplicationContext(), "Color: BLUE", Toast.LENGTH_SHORT);
        } else if (yellow.isChecked()) {
            toast = Toast.makeText(getApplicationContext(), "Color: YELLOW", Toast.LENGTH_SHORT);
        } else if (green.isChecked()) {
            toast = Toast.makeText(getApplicationContext(), "Color: GREEN", Toast.LENGTH_SHORT);
        } else {
            return;
        }

        toast.show();

        // Delay dismissal of toast
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 1500); // 1.5 seconds delay
    }

    public void changeBackgroundColor(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        if (view.getId() == R.id.rbRed) {
            if (checked) {
                constraintLayout.setBackgroundColor(Color.parseColor("#FF8686")); // Red
                showSelectedColor();
            }
        } else if (view.getId() == R.id.rbBlue) {
            if (checked) {
                constraintLayout.setBackgroundColor(Color.parseColor("#9AC2FF")); // Blue
                showSelectedColor();
            }
        } else if (view.getId() == R.id.rbYellow) {
            if (checked) {
                constraintLayout.setBackgroundColor(Color.parseColor("#F7F97C")); // Yellow
                showSelectedColor();
            }
        } else if (view.getId() == R.id.rbGreen) {
            if (checked) {
                constraintLayout.setBackgroundColor(Color.parseColor("#85F082")); // Green
                showSelectedColor();
            }
        }
    }
}
