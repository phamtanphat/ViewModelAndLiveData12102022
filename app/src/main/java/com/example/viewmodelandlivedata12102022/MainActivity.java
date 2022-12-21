package com.example.viewmodelandlivedata12102022;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity {

    EditText edtInput;
    Button btnGetText;
    TextView tvOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput = findViewById(R.id.edit_text);
        btnGetText = findViewById(R.id.button_get_text);
        tvOutput = findViewById(R.id.text_view_output);

        btnGetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
