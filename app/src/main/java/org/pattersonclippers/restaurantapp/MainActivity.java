package org.pattersonclippers.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameET;
    Button setBTN;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = "";
        nameET = (EditText) findViewById(R.id.nameET);
        setBTN = (Button) findViewById(R.id.setBTN);

        setBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameET.getText().toString();

                //display sentence in textview
                Intent myIntent = new Intent(MainActivity.this, MenuActivity.class);
                myIntent.putExtra("name", name);
                startActivity(myIntent);

                //toast
                int duration = Toast.LENGTH_SHORT;


                if(name.equals("")) {
                    Toast t = Toast.makeText(getApplicationContext(), "Your name has not been set/.", duration);
                    t.show();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), "Your name has been set to '" + name + "'.", duration);
                    t.show();
                }
            }
        });
    }
}