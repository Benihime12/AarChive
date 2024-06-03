package com.example.aarchive.GuidedExercises;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

public class FourthGuidedExercise extends AppCompatActivity {
    EditText username, password;
    TextView result;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_guided_exercise);
        username = findViewById(R.id.etUsernameGE4);
        password = findViewById(R.id.etPasswordGE4);
        result = findViewById(R.id.tvResultGE4);
        login = findViewById(R.id.btnLoginGE4);
        showResult();

        ImageButton btnBackGE4 = findViewById(R.id.btnBackGE4);
        btnBackGE4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourthGuidedExercise.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }
    public void showResult(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("aaron") &&
                        password.getText().toString().equals("pogi")){
                    result.setText("Welcome " + username.getText().toString() +"!");
                    // this will set the result text color into GREEN
                    result.setTextColor(Color.GREEN);
                    clearEntry();
                }else{
                    result.setText("Username and Password does not exist!");
                    // this will set the result text color into RED
                    result.setTextColor(Color.RED);
                    clearEntry();
                }
            }
        });
    }
    public void clearEntry(){
        result.setVisibility(View.VISIBLE);
        username.setText("");
        password.setText("");
        username.requestFocus();
    }
}