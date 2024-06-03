package com.example.aarchive.GuidedExercises;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

public class EigthGuidedExercise extends AppCompatActivity {

    Spinner names;
    TextView result;
    ArrayAdapter<String> adapter;
    String[] listOfNames = {"My loves", "Karina", "Yeji", "Mina", "Aiah"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eigth_guided_exercise);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOfNames);
        names = findViewById(R.id.spnrNamesGE8);
        result = findViewById(R.id.tvResultGE8);
        showSelectedName();

        ImageButton btnBackGE8 = findViewById(R.id.btnBackGE8);

        btnBackGE8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EigthGuidedExercise.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }

    public void showSelectedName() {
        names.setAdapter(adapter);
        names.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    result.setText("Name: " + listOfNames[i] + "<3");
                    showToastWithCustomDuration("Name: " + listOfNames[i] + "<3", 1000);
                } else {
                    result.setText("Name: ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void showToastWithCustomDuration(final String message, final int durationInMillis) {
        final Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();

        // Cancel the toast after the specified duration
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 1500);
    }
}
