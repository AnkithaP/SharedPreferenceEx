package com.aryaan.ankitha.sharedpreferenceex;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {

    TextView userNameText,passwordText;
    private static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        userNameText = (TextView)findViewById(R.id.textView3);
        passwordText = (TextView)findViewById(R.id.textView5);
    }

    public void load(View view){

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("username",DEFAULT);
        String password = sharedPreferences.getString("password",DEFAULT);

        if (name.equals(DEFAULT) || password.equals(DEFAULT)){
            Toast.makeText(ActivityB.this, "No Data Found", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(ActivityB.this, "Data Loaded successfully", Toast.LENGTH_SHORT).show();
            userNameText.setText(name);
            passwordText.setText(password);
        }
    }

    public void previous(View view){
        Toast.makeText(ActivityB.this, "Previous", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
