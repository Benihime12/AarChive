package com.example.aarchive.GuidedExercises;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

public class SixthGuidedExercise extends AppCompatActivity {

    CheckBox one, two, three, four;
    TextView result;
    Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_guided_exercise);
        one = findViewById(R.id.chkOne);
        two = findViewById(R.id.chkTwo);
        three = findViewById(R.id.chkThree);
        four = findViewById(R.id.chkFour);
        result = findViewById(R.id.tvResultGE6);
        click = findViewById(R.id.btnClickGE6);
        showResult();

        ImageButton btnBackGE6 = findViewById(R.id.btnBackGE6);

        btnBackGE6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SixthGuidedExercise.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }
    public void showResult(){
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(two.isChecked() && four.isChecked()){
                    // this will show the TextView named result
                    result.setVisibility(View.VISIBLE);
                    result.setTextColor(Color.parseColor("#FF8686"));
                    result.setText("Number Combination Color is RED");
                }else if (one.isChecked() && three.isChecked()){
                    result.setVisibility(View.VISIBLE);
                    result.setTextColor(Color.parseColor("#9AC2FF"));
                    result.setText("Number Combination Color is BLUE");
                }else if ((one.isChecked() || three.isChecked()) ||
                        (two.isChecked() || four.isChecked())){
                    result.setVisibility(View.VISIBLE);
                    result.setTextColor(Color.parseColor("#85F082"));
                    result.setText("Number Combination Color is GREEN");
                }else{
                    // this will hide the TextView named result
                    result.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}