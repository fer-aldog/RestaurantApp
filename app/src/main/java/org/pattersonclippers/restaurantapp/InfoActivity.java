package org.pattersonclippers.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {
    Button bmoreBTN, bowieBTN, columBTN, fredBTN, owingBTN, rockvBTN, towsnBTN, washiBTN, wtmshBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        bmoreBTN = (Button) findViewById(R.id.bmoreBTN);
        bowieBTN = (Button) findViewById(R.id.bowieBTN);
        columBTN = (Button) findViewById(R.id.columBTN);
        fredBTN = (Button) findViewById(R.id.fredBTN);
        owingBTN = (Button) findViewById(R.id.owingBTN);
        rockvBTN = (Button) findViewById(R.id.rockvBTN);
        towsnBTN = (Button) findViewById(R.id.towsnBTN);
        washiBTN = (Button) findViewById(R.id.washiBTN);
        wtmshBTN = (Button) findViewById(R.id.wtmshBTN);

        bmoreBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=3731+Boston+St%2C+Baltimore%2C+MD+21224"));
                if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
            }
        });

        bowieBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=1417+S+Main+Chapel+Way+Ste+%23108%2C+Gambrills%2C+MD+21054"));
                if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
            }
        });

        columBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=10101+Twin+Rivers+Rd+Suite+C2%2D100%2C+Columbia%2C+MD+21044"));
                if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
            }
        });

        fredBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=3290+Bennett+Creek+Ave+Unit+D%2C+Ijamsville%2C+MD+21754"));
                if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
            }
        });

        owingBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=10200+Mill+Run+Cir+suite+104%2C+Owings+Mills%2C+MD+21117"));
                if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
            }
        });

        rockvBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=1800+Rockville+Pike+h1%2C+Rockville%2C+MD+20852"));
                if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
            }
        });

        towsnBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=1+E+Joppa+Rd+suite+165a%2C+Towson%2C+MD+21286"));
                if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
            }
        });

        washiBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=2479+18th+St+NW%2C+Washington%2C+DC+20009"));
                if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
            }
        });

        wtmshBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=8133%2DA%2C+Honeygo+Blvd%2C+Nottingham%2C+MD+21236"));
                if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
            }
        });


    }
}