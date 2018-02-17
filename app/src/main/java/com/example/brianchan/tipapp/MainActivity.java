package com.example.brianchan.tipapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void beforeTax(View view) {
        Intent intent = new Intent(this, withoutTax.class);
        startActivity(intent);
    }

    public void afterTax(View view) {
        Intent intent = new Intent(this, withTax.class);
        startActivity(intent);
    }
}
