package com.example.basicdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public DBHelper dbhelper;
    private String name, email, phone;
    EditText nameeditext, emailedittext, phoneedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbhelper = new DBHelper(this);
        setContentView(R.layout.activity_main);
        nameeditext = findViewById(R.id.nameEditTextID);
        emailedittext = findViewById(R.id.emailEditTextID);
        phoneedittext = findViewById(R.id.phoneEditTextID);
    }

    public void savedataFunction(View view) {
        name = nameeditext.getText().toString();
        email = emailedittext.getText().toString();
        phone = phoneedittext.getText().toString();
        String value = dbhelper.addStudentInfo(name, email, phone);
        if (value.equals("y")) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Data failed", Toast.LENGTH_SHORT).show();
        }
    }
}