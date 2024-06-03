package com.example.aarchive.GuidedExercises;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

import java.util.HashMap;
import java.util.Map;

public class EleventhPracticeExercise2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleventh_practice_exercise2);

        ImageButton btnBackPE11 = findViewById(R.id.btnBackPE11);
        ImageView imageView = findViewById(R.id.ivBebeloves);
        RadioGroup radioGroup = findViewById(R.id.radioGroup2a);
        Button button = findViewById(R.id.btnClick);

        // Assigning images to radio buttons
        final Map<Integer, Integer> imageMap = new HashMap<>();
        imageMap.put(R.id.rdoYeji, R.drawable.yeji);
        imageMap.put(R.id.rdoKarina, R.drawable.karina);
        imageMap.put(R.id.rdoMina, R.drawable.mina);
        imageMap.put(R.id.rdoAiah, R.drawable.aiah);

        btnBackPE11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EleventhPracticeExercise2.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Find the selected radio button ID
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    // Get the corresponding image resource ID
                    Integer imageResId = imageMap.get(selectedRadioButtonId);
                    if (imageResId != null) {
                        // Set the image resource to the ImageView
                        imageView.setImageResource(imageResId);
                    }
                }
            }
        });
    }
}
