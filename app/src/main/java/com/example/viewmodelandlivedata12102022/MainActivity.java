package com.example.viewmodelandlivedata12102022;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity {

    MyLiveData myLiveData;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLiveData = new MyLiveData();

        myLiveData.getString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("BBB", s);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                myLiveData.setData(String.valueOf(count++));
                new Handler().postDelayed(this::run, 1000);
            }
        }, 1000);
    }

}
