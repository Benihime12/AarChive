package com.example.aarchive.GuidedExercises;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.CustomAdapter;
import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

import java.util.Arrays;
import java.util.List;

public class NinthGuidedExercise extends AppCompatActivity {

    ListView name;
    CustomAdapter adapter;
    String[] listOfNames = {"Aaron","Yeji","Karina","Mina","Aiah","Mark","Jude","Arthur","Pole","Ron","Eron"};
    double[] listOfSemGrades = {1.00,1.50,2.00,1.25,3.00,5.00,1.75,2.25,3.00,1.00,2.25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth_guided_exercise);
        name = findViewById(R.id.lvNameGE9);

        // Convert the array to a list
        List<String> namesList = Arrays.asList(listOfNames);

        // Initialize the custom adapter
        adapter = new CustomAdapter(this, R.layout.list_item, namesList);
        name.setAdapter(adapter);
        showSemGrade();

        ImageButton btnBackGE8 = findViewById(R.id.btnBackGE8);

        btnBackGE8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NinthGuidedExercise.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }

    public void showSemGrade() {
        name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String message = "Name: " + name.getItemAtPosition(i) + "\nSem Grade: " + listOfSemGrades[i];
                showToast(message);  // 1000 milliseconds = 1 second
            }
        });
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);

        // Show the toast for a custom duration
        toast.show();

        // Use a Handler to cancel the toast after the custom duration
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 1500);
    }
}
