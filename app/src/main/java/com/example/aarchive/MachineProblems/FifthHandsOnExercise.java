package com.example.aarchive.MachineProblems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

public class FifthHandsOnExercise extends AppCompatActivity {

    CheckBox cbCaffe;
    CheckBox cbGreen;
    CheckBox cbSmores;
    CheckBox cbMocha;
    RadioGroup rgDiscount;
    TextView tvSubDisp;
    TextView tvDisDisp;
    TextView tvNetAmtDisp;
    Button btnCompute;
    Button btnClearAll;
    RadioButton rbNoDiscountt;
    RadioButton rb5;
    RadioButton rb10;
    RadioButton rb15;

    double subAmount = 0;
    double discount = 0;
    double netAmount = 0;
    double totalDiscount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_hands_on_exercise);

        init();
        buttonsClicked();
        listenersAction();

        ImageButton btnBackmp5 = findViewById(R.id.btnBackMp5);
        btnBackmp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FifthHandsOnExercise.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }

    public void listenersAction() {
        cbCaffe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "You Selected Caffe Vanilla Frappuccino Php150.00", Toast.LENGTH_SHORT).show();
                    subAmount += 150;
                } else {
                    Toast.makeText(getApplicationContext(), "You Unselected Caffe Vanilla Frappuccino", Toast.LENGTH_SHORT).show();
                    subAmount -= 150;
                }
            }
        });
        cbGreen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "You Selected Green Tea Creme Frappuccinno Php190.00", Toast.LENGTH_SHORT).show();
                    subAmount += 190;
                } else {
                    Toast.makeText(getApplicationContext(), "You Unselected Green Tea Creme Frappuccinno", Toast.LENGTH_SHORT).show();
                    subAmount -= 190;
                }
            }
        });
        cbSmores.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "You Selected S'mores Frappuccino Php199.00", Toast.LENGTH_SHORT).show();
                    subAmount += 199;
                } else {
                    Toast.makeText(getApplicationContext(), "You Unselected S'mores Frappuccino", Toast.LENGTH_SHORT).show();
                    subAmount -= 199;
                }
            }
        });
        cbMocha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "You Selected Mocha Frappuccino Php130.00", Toast.LENGTH_SHORT).show();
                    subAmount += 130;
                } else {
                    Toast.makeText(getApplicationContext(), "You Unselected Mocha Frappuccino", Toast.LENGTH_SHORT).show();
                    subAmount -= 130;
                }
            }
        });
        rgDiscount.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb5) {
                    discount = 0.05;
                    Toast.makeText(getApplicationContext(), "You Select 5% discount", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.rb10) {
                    discount = 0.10;
                    Toast.makeText(getApplicationContext(), "You Select 10% discount", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.rb15) {
                    discount = 0.15;
                    Toast.makeText(getApplicationContext(), "You Select 15% discount", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.rbNoDiscount) {
                    discount = 0.00;
                    Toast.makeText(getApplicationContext(), "You Select No discount", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Compute() {
        totalDiscount = subAmount * discount;
        netAmount = subAmount - totalDiscount;
    }

    public void displayAmounts() {
        tvSubDisp.setText(String.format("%.2f", subAmount));
        tvDisDisp.setText(String.format("%.2f", totalDiscount));
        tvNetAmtDisp.setText(String.format("%.2f", netAmount));
    }

    public void buttonsClicked() {
        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Compute();
                displayAmounts();
            }
        });
        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearDisp();
                ClearDisp2();
                clearAmounts();
                rgDiscount.check(R.id.rbNoDiscount);
            }
        });
    }

    public void ClearDisp() {
        cbGreen.setChecked(false);
        cbCaffe.setChecked(false);
        cbMocha.setChecked(false);
        cbSmores.setChecked(false);
        rbNoDiscountt.setChecked(true);
    }

    public void ClearDisp2() {
        tvDisDisp.setText("0.00");
        tvSubDisp.setText("0.00");
        tvNetAmtDisp.setText("0.00");
    }

    public void clearAmounts() {
        subAmount = 0;
        discount = 0;
        netAmount = 0;
        totalDiscount = 0;
    }

    public void init() {
        cbGreen = findViewById(R.id.cbGreen);
        cbCaffe = findViewById(R.id.cbCaffe);
        cbSmores = findViewById(R.id.cbSmores);
        cbMocha = findViewById(R.id.cbMocha);
        rgDiscount = findViewById(R.id.rgDiscount);
        tvSubDisp = findViewById(R.id.tvSubtotalDisp);
        tvDisDisp = findViewById(R.id.tvDiscDisp);
        tvNetAmtDisp = findViewById(R.id.tvNetAmtDisp);
        btnCompute = findViewById(R.id.btnCompute2);
        btnClearAll = findViewById(R.id.btnClearAll);
        rbNoDiscountt = findViewById(R.id.rbNoDiscount);
        rb5 = findViewById(R.id.rb5);
        rb10 = findViewById(R.id.rb10);
        rb15 = findViewById(R.id.rb15);
        rgDiscount.check(R.id.rbNoDiscount);
    }
}
