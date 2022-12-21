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
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    EditText edtInput;
    Button btnGetText;
    TextView tvOutput;
    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput = findViewById(R.id.edit_text);
        btnGetText = findViewById(R.id.button_get_text);
        tvOutput = findViewById(R.id.text_view_output);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mainViewModel.getString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("BBB", "Update");
                tvOutput.setText(s);
            }
        });

        btnGetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtInput.getText().toString();
                mainViewModel.setString(text);
            }
        });
    }

}
