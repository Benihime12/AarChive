package com.example.aarchive.MachineProblems;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

public class FourthHandsOnExercise extends AppCompatActivity {

    private TextView tvStudentName;
    private TextView tvSemGrade;
    private TextView tvPEquivalent;
    private TextView tvRemarks;

    private EditText studentName;
    private EditText Prelim;
    private EditText Midterm;
    private EditText Finals;

    private Button btnCompute;
    private Button btnNewEnt;

    private String name;
    private double prelimG;
    private double midtermG;
    private double finalG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_hands_on_exercise);
        init();
        computeClick();
        newEventClicked();

        ImageButton btnBackMp4 = findViewById(R.id.btnBackMp4);
        btnBackMp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourthHandsOnExercise.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }

    public double average(double prelim, double midterm, double Final){
        return prelim * 0.25 + midterm * 0.25 + Final * 0.50;
    }
    public double equivalent(double average){
        double equi;

        if(average >= 99.5){
            equi = 1.00;
        } else if (average <= 99.49 && average >= 94.5) {
            equi = 1.50;
        }else if (average <= 94.49 && average >= 89.5) {
            equi = 2.00;
        }else if (average <= 89.49 && average >= 84.5) {
            equi = 2.50;
        }else if (average <= 84.49 && average >= 79.5) {
            equi = 3.00;
        }else if (average <= 79.49 && average >= 74.5) {
            equi = 3.50;
        }else if (average <= 74.49) {
            equi = 5.00;
        }else{
            return 0;
        }
        return equi;
    }
    public String Remark(double equi){
        if(equi > 3.00){
            tvRemarks.setTextColor(Color.RED);
            return "Failed!";
        }
        tvRemarks.setTextColor(Color.BLUE);
        return "Passed!";
    }
    public void newEventClicked(){
        btnNewEnt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FourthHandsOnExercise.this);
                builder.setTitle("Warning Message").setMessage("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        clearET();
                        clearTv();
                        tvRemarks.setTextColor(Color.BLACK);
                        studentName.setText("");
                        studentName.requestFocus();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();
            }

        });

    }

    public void computeClick(){
        AlertDialog.Builder builder = new AlertDialog.Builder(FourthHandsOnExercise.this);
        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder.setTitle("Warning Message").setMessage("All Entries Correct?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        if(!studentName.getText().toString().isEmpty()  && !Prelim.getText().toString().isEmpty()
                                && !Midterm.getText().toString().isEmpty() && !Finals.getText().toString().isEmpty()){

                            name = studentName.getText().toString();
                            prelimG = Double.parseDouble(Prelim.getText().toString());
                            midtermG = Double.parseDouble(Midterm.getText().toString());
                            finalG = Double.parseDouble(Finals.getText().toString());
                            double averageG = average(prelimG, midtermG, finalG);
                            DecimalFormat df = new DecimalFormat("#.##"); // Format to two decimal places
                            double equi = equivalent(averageG);
                            String remarks = Remark(equi);

                            try{
                                if((prelimG <= 100 && prelimG >= 0 ) && (midtermG <= 100 && midtermG >= 0 ) && (finalG <= 100 && finalG >= 0 ) ){
                                    tvStudentName.setText(name);
                                    tvSemGrade.setText(df.format(averageG));
                                    tvPEquivalent.setText(String.valueOf(equi));
                                    tvRemarks.setText(remarks);
                                }else{
                                    tvRemarks.setTextColor(Color.BLACK);
                                    builder.setTitle("Alert").setMessage("Enter value from 1 - 100 only!");
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.dismiss();
                                            clearET();
                                            studentName.setText(name);
                                        }
                                    });
                                    builder.setCancelable(false);
                                    AlertDialog dialog1 = builder.create();
                                    dialog1.show();
                                }
                            }catch (Exception e){
                            }

                        }else{
                            builder.setTitle("Alert").setMessage("Please enter all necessary details to compute");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                            builder.setCancelable(false);
                            AlertDialog dialog2 = builder.create();
                            dialog2.show();
                        }                        }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
    public void clearET(){
        studentName.setText("");
        Prelim.setText("");
        Midterm.setText("");
        Finals.setText("");

        Prelim.requestFocus();
    }
    public void clearTv(){
        tvStudentName.setText("SN");
        tvSemGrade.setText("SB");
        tvPEquivalent.setText("PE");
        tvRemarks.setText("Remark");
    }
    public void init(){
        tvStudentName = findViewById(R.id.tvSNDisp);
        tvSemGrade = findViewById(R.id.tvSGDisp);
        tvPEquivalent = findViewById(R.id.tvPEDisp);
        tvRemarks = findViewById(R.id.tvRemarksDisp);
        studentName = findViewById(R.id.etStudentName);
        Prelim = findViewById(R.id.etPrelim);
        Midterm = findViewById(R.id.etMidterm);
        Finals = findViewById(R.id.etFinal);
        btnCompute = findViewById(R.id.btnCompute);
        btnNewEnt = findViewById(R.id.btnNewEnt);
    }
}