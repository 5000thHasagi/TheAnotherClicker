package com.example.theanotherclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTime, tvStacks;
    Button btnStart, btnQQ;
    CountDownTimer timer;

    int t = 30;
    int c = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = (TextView)findViewById(R.id.tvTimer);
        tvStacks = (TextView)findViewById(R.id.tvStacks);
        btnQQ = (Button)findViewById(R.id.btnQQQ);
        btnStart = (Button)findViewById(R.id.btnStart);

        btnStart.setEnabled(true);
        btnQQ.setEnabled(false);

        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                t--;
                tvTime.setText("Time: " + t);
            }

            @Override
            public void onFinish() {
                btnStart.setEnabled(true);
                btnQQ.setEnabled(false);
                tvTime.setText("Time: " + t);

            }
        };

        btnQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                tvStacks.setText("Q настакано: " + c);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
                btnStart.setEnabled(false);
                btnQQ.setEnabled(true);
                c = 0;
                t = 30;
                tvTime.setText("Time: " + t);
                tvStacks.setText("Q настакано: " + c);
            }
        });
    }
}