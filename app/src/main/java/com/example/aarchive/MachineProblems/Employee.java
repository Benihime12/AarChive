package com.example.aarchive.MachineProblems;

import java.io.Serializable;

public class Employee implements Serializable {
    private String employeeID;
    private String employeeName;
    private String poscode;
    private String employeeStatus;
    private String employeeNumDaysWorked;
    private double employeeBasPay;
    private double employeeSSS;
    private double employeeWitTax;
    private double netPay;

    public Employee(String employeeID, String employeeName, String poscode, String employeeStatus, String employeeNumDaysWorked, double employeeBasPay, double employeeSSS, double employeeWitTax, double netPay) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.poscode = poscode;
        this.employeeStatus = employeeStatus;
        this.employeeNumDaysWorked = employeeNumDaysWorked;
        this.employeeBasPay = employeeBasPay;
        this.employeeSSS = employeeSSS;
        this.employeeWitTax = employeeWitTax;
        this.netPay = netPay;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPoscode() {
        return poscode;
    }

    public void setPoscode(String poscode) {
        this.poscode = poscode;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeNumDaysWorked() {
        return employeeNumDaysWorked;
    }

    public void setEmployeeNumDaysWorked(String employeeNumDaysWorked) {
        this.employeeNumDaysWorked = employeeNumDaysWorked;
    }

    public double getEmployeeBasPay() {
        return employeeBasPay;
    }

    public void setEmployeeBasPay(double employeeBasPay) {
        this.employeeBasPay = employeeBasPay;
    }

    public double getEmployeeSSS() {
        return employeeSSS;
    }

    public void setEmployeeSSS(double employeeSSS) {
        this.employeeSSS = employeeSSS;
    }

    public double getEmployeeWitTax() {
        return employeeWitTax;
    }

    public void setEmployeeWitTax(double employeeWitTax) {
        this.employeeWitTax = employeeWitTax;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }
}
