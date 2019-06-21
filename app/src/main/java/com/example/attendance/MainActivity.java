
package com.example.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    TextView t1,t2,t3,t4;
    EditText e1, e2, e3, e4 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);

        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView5);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().equals("")
                        || e2.getText().toString().equals("")
                        || e3.getText().toString().equals("")
                        || e4.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter all values", Toast.LENGTH_SHORT).show();
                }
                else {
                    openAttend();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().equals("")
                        || e2.getText().toString().equals("")
                        || e3.getText().toString().equals("")
                        || e4.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "No values entered to Reset", Toast.LENGTH_SHORT).show();
                }
                else {
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");

                }
            }

        });


    }

    public void openAttend() {
        int n1 = Integer.parseInt(e1.getText().toString());
        int n4=Integer.parseInt(e4.getText().toString());
        int n2 = Integer.parseInt(e2.getText().toString());
        int n3 = Integer.parseInt(e3.getText().toString());


        Intent intent = new Intent(MainActivity.this, Attend.class);
        intent.putExtra("absent", n1);
        intent.putExtra("od", n2);
        intent.putExtra("miss class", n3);
        intent.putExtra("total days", n4);

        startActivity(intent);

    }


}