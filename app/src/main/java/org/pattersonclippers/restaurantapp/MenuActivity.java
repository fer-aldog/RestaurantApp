package org.pattersonclippers.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    Intent incomingIntent;
    TextView setTextTV;
    Button infoBTN, siteBTN, planBTN;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setTextTV = (TextView) findViewById(R.id.setTextTV);
        infoBTN = (Button) findViewById(R.id.infoBTN);
        siteBTN = (Button) findViewById(R.id.siteBTN);
        planBTN = (Button) findViewById(R.id.planBTN);
        incomingIntent = getIntent();
        name = incomingIntent.getStringExtra("name");

        if(name.equals("")) {
            setTextTV.setText("What would you like to do?");
        } else {
            setTextTV.setText("What would you like to do, " + name + "?");
        }

        infoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MenuActivity.this, InfoActivity.class);
                startActivity(myIntent);
            }
        });
        siteBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MenuActivity.this, WebViewActivity.class);
                startActivity(myIntent);
            }
        });

        planBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MenuActivity.this, OrderActivity.class);
                startActivity(myIntent);
            }
        });
    }

}