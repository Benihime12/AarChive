package com.example.aarchive.MachineProblems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.databinding.ActivitySummaryDetailsBinding;

public class SummaryDetails extends AppCompatActivity {
    private ActivitySummaryDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySummaryDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getEmployeeSetToDetails();
        backClicked();
    }
    public void getEmployeeSetToDetails(){
        Intent intent = getIntent();
        Employee employee = (Employee) intent.getSerializableExtra("Employee");

        if (employee != null) {
            binding.tvEmpID.setText(employee.getEmployeeID());
            binding.tvName.setText(employee.getEmployeeName());
            binding.tvPosCode.setText(employee.getPoscode());
            binding.tvCivilStatus.setText(employee.getEmployeeStatus());
            binding.tvDaysWorked.setText(employee.getEmployeeNumDaysWorked());
            binding.tvBasicPay.setText("Php " + String.format("%.2f", employee.getEmployeeBasPay()));
            binding.tvSSSContrib.setText("Php " + String.format("%.2f", employee.getEmployeeSSS()));
            binding.tvWithHolding.setText("Php " + String.format("%.2f", employee.getEmployeeWitTax()));
            binding.tvNetpay.setText("Php " + String.format("%.2f", employee.getNetPay()));
        }
    }
    public void backClicked(){
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}