package com.zero.fluttergo.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.zero.fluttergo.gopresenter.FlutterGo;

public class MainActivity extends AppCompatActivity {

    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvText = findViewById(R.id.demo_text);
        findViewById(R.id.demo_btn).setOnClickListener(view -> {
            tvText.setText("hello world 1 + 2 = " + FlutterGo.handleAdd(1, 2));
        });
    }
}
