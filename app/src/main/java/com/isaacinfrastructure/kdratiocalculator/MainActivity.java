package com.isaacinfrastructure.kdratiocalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        new CountDownTimer(3000, 500) {
            public void onFinish() {
                Intent startActivity = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(startActivity);
                finish();
            }

            public void onTick(long millisUntilFinished) {
            }

        }.start();
        }
    }
