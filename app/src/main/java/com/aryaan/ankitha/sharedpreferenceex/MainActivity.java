package com.aryaan.ankitha.sharedpreferenceex;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText1);

    }

    public void save(View view){

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",userName.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.commit();

        Toast.makeText(MainActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
    }

    public void goNext(View view){

        Toast.makeText(MainActivity.this, "Next", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ActivityB.class);
        startActivity(intent);
    }
}
