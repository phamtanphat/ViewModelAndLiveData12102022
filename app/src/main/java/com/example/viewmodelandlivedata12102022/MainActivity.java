package com.example.viewmodelandlivedata12102022;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            handleNumber(5, 10)
                    .thenAccept(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) {
                            Log.d("BBB", integer + " ");
                        }
                    });
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private CompletableFuture<Integer> handleNumber(int numberA, int numberB) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    completableFuture.complete(numberA + numberB);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return completableFuture;
    }

    private void handleNumber1(int numberA, int numberB, OnListener onListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    onListener.onDataChange(numberA + numberB);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    interface OnListener {
        void onDataChange(int number);
    }
}
