package com.example.attendance;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ProgressBar;

public class Attend extends AppCompatActivity {
    TextView t, t1,txt;
    ProgressBar p;
    private int pStatus = 0;
    float cc3;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attend);

        Intent intent = getIntent();
        int n1 = intent.getIntExtra("absent", 0);
        int n2 = intent.getIntExtra("od", 0);
        int n3 = intent.getIntExtra("miss class", 0);
        int n4 = intent.getIntExtra("total days",0);


        float ab,ab1,ab2,od,od1,md,md1,dp;
        float td=n4*7;
        ab=n1*7;
        ab1=ab/td;
        ab2= (ab1*100);
        od=n2/td;
        od1=  (od*100);
        md=n3/td;
        md1=  (md*100);
        cc3= 100-ab2-md1+od1;
        dp=md1/n3;


        t = (TextView) findViewById(R.id.textView4);
        t1 = (TextView) findViewById(R.id.textView5);


        if(cc3<100 && cc3>0) {

            t.setText("YOUR  ATTENDENCE  PERCENT : " + cc3);
            if ( cc3 < 80) {
                t1.setText("YOU  HAVE  LOW  ATTENDANCE");
                float mp, b;
                mp = 80 - cc3;
                b = mp / dp;
                int b1 = (int) b;

                t1.setText("YOU  NEED  TO  ATTEND  " + b1 + "  PERIODS");

            } else if ( cc3 > 80) {
                t1.setText("YOU  HAVE  SUFFICIENT  ATTENDANCE");
                float mp, b;
                mp = cc3-80;
                b = mp / dp;
                int b1 = (int) b;
                t1.setText("YOU  MAY  MISS  " + b1 + "  PERIODS");

            } else if (cc3 == 80) {
                t1.setText("YOUR ATTENDANCE IS IN THE BORDER");
            }

        }


        else
        {
            t.setText("INVALID INPUTS");
            Toast.makeText(Attend.this, "Invalid inputs", Toast.LENGTH_SHORT).show();
        }
        p = (ProgressBar) findViewById(R.id.progressBar);
        txt= (TextView) findViewById(R.id.txtProgress);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (pStatus <= cc3) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            p.setProgress(pStatus);
                            txt.setText(pStatus + " %");
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pStatus++;
                }
            }
        }).start();

    }

}