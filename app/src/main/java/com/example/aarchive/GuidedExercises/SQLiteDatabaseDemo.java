package com.example.aarchive.GuidedExercises;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

public class SQLiteDatabaseDemo extends AppCompatActivity {

    EditText studentId, StudName, studentSemGrade;
    Button addRecord, deleteRecord, editRecord, viewRecord, viewAllRecord;
    SQLiteDatabase db;
    Cursor cursor;
    AlertDialog.Builder builder;
    StringBuffer buffer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database_demo);
        init();
        addStudentRecord();
        deleteStudentRecord();
        editStudentRecord();
        viewStudentRecord();
        viewAllStudentRecords();

        ImageButton btnBackSQLite = findViewById(R.id.btnBackSQL);
        btnBackSQLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SQLiteDatabaseDemo.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }
    public void init(){
        studentId = findViewById(R.id.etStudentID);
        StudName = findViewById(R.id.etStudName);
        studentSemGrade = findViewById(R.id.etStudentSemGrade);
        addRecord = findViewById(R.id.btnAddRecord);
        deleteRecord = findViewById(R.id.btnDeleteRecord);
        editRecord = findViewById(R.id.btnEditRecord);
        viewRecord = findViewById(R.id.btnViewRecord);
        viewAllRecord = findViewById(R.id.btnViewAllRecord);
        builder = new AlertDialog.Builder(this);

        db = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);

        db.execSQL("DROP TABLE IF EXISTS tbl_student;");
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_student (student_id INTEGER PRIMARY KEY AUTOINCREMENT, student_name TEXT, student_semGrade INTEGER);");
        studentId.setEnabled(false);
        StudName.requestFocus();
    }
    public void displayMessage(String title, String message){
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearEntries(){
        StudName.setText("");
        studentId.setText("");
        studentSemGrade.setText("");
        StudName.requestFocus();
    }
    public void addStudentRecord(){
        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(StudName.getText().toString().isEmpty()||
                        studentSemGrade.getText().toString().isEmpty()){
                    displayMessage("Error!","Please Complete the Entries");
                    return;
                }
                db.execSQL("INSERT INTO tbl_student(student_name,student_semGrade) " +
                        "VALUES('"+StudName.getText().toString()+"'"+","+
                        "'"+studentSemGrade.getText().toString()+"')");
                displayMessage("Information!","Student Record has been successfully added!");
                clearEntries();
            }
        });
    }
    public void deleteStudentRecord(){
        deleteRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(studentId.getText().toString().isEmpty()){
                    studentId.setEnabled(true);
                    displayMessage("Information!","Please Enter a Student ID");
                    studentId.requestFocus();
                    return;
                }
                // rawQuery() It directly accepts an SQL select statement as input.
                cursor = db.rawQuery("SELECT * FROM tbl_student WHERE student_id ="+Integer.parseInt(studentId.getText().toString()),null);
                if(cursor.moveToFirst()){
                    db.execSQL("DELETE FROM tbl_student WHERE student_id ="+Integer.parseInt(studentId.getText().toString()));
                    displayMessage("Information!","Student Record has been successfully deleted!");
                }else{
                    displayMessage("Error!","Invalid Student ID");
                }
                studentId.setEnabled(false);
                clearEntries();
            }
        });
    }
    public void editStudentRecord(){
        editRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(studentId.getText().toString().isEmpty()){
                    studentId.setEnabled(true);
                    displayMessage("Information!","Please Enter a Student ID");
                    editRecord.setText("SAVE");
                    studentId.requestFocus();
                    return;
                }
                cursor = db.rawQuery("SELECT * FROM tbl_student WHERE student_id ="+Integer.parseInt(studentId.getText().toString()),null);
                if(cursor.moveToFirst()){
                    db.execSQL("UPDATE tbl_student SET student_name='"+StudName.getText().toString()+"',student_semGrade='"+studentSemGrade.getText().toString()+
                            "'WHERE student_id='"+Integer.parseInt(studentId.getText().toString())+"'");
                    displayMessage("Information!","Student Record has been successfully modified!");
                }else{
                    displayMessage("Error!","Invalid Student ID");
                }
                editRecord.setText("EDIT");
                studentId.setEnabled(false);
                clearEntries();
            }
        });
    }
    public void viewStudentRecord(){
        viewRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(studentId.getText().toString().isEmpty()){
                    studentId.setEnabled(true);
                    displayMessage("Information!","Please Enter a Student ID");
                    studentId.requestFocus();
                    return;
                }
                cursor = db.rawQuery("SELECT * FROM tbl_student WHERE student_id ="+Integer.parseInt(studentId.getText().toString()),null);
                if (cursor.moveToFirst()){
                    buffer = new StringBuffer();
                    buffer.append("Student ID: " + cursor.getString(0)+"\n");
                    buffer.append("Student Name: " + cursor.getString(1)+"\n");
                    buffer.append("Student SemGrade: " + cursor.getString(2)+"\n----------");
                    displayMessage("Student Record",buffer.toString());
                }else{
                    displayMessage("Error!","Invalid Student ID");
                }
                studentId.setEnabled(false);
                clearEntries();
            }
        });
    }
    public void viewAllStudentRecords(){
        viewAllRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor = db.rawQuery("SELECT * FROM tbl_student",null);
                if(cursor.getCount()==0){
                    displayMessage("Information","No Student Records Found!");
                    return;
                }
                buffer = new StringBuffer();
                while (cursor.moveToNext()){
                    buffer.append("Student ID: " + cursor.getString(0)+"\n");
                    buffer.append("Student Name: " + cursor.getString(1)+"\n");
                    buffer.append("Student SemGrade: " + cursor.getString(2)+"\n----------\n");
                }
                displayMessage("Student Record",buffer.toString());
            }
        });
    }
}


