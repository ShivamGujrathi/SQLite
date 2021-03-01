package com.example.sqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Button b1, view;
    EditText editTextname, editTextemail, editTextphone, editTextaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextname = findViewById(R.id.Name);
        editTextemail = findViewById(R.id.email);
        editTextphone = findViewById(R.id.phoneN);
        editTextaddress = findViewById(R.id.address);
        b1 = findViewById(R.id.button1);
        view = findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringname = editTextname.getText().toString();
                String stringemail = editTextemail.getText().toString();
                String stringphone = editTextphone.getText().toString();
                String stringaddress = editTextaddress.getText().toString();
                if (stringname.length() <= 0 || stringemail.length() <= 0) {
                    Toast.makeText(MainActivity.this, "Enter the data", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                    EmployeeModel employeeModel = new EmployeeModel(stringname, stringemail, stringphone, stringaddress);
                    databaseHelper.addEmployee(employeeModel);
                    Toast.makeText(MainActivity.this, "ADD EMPLOYEE SUCCESFULLY", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }


            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,viewEmployeeactivity.class);
                startActivity(intent);
            }
        });

    }
}