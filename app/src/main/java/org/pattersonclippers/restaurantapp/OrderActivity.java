package org.pattersonclippers.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    ImageButton lessAVRBTN, moreAVRBTN, lessVegBTN, moreVegBTN;
    Button addVolBTN, addVegBTN, finaliseBTN;
    CheckBox eggVolCB, chashuVolCB, eggVegCB, chashuVegCB;
    TextView countAVR, countVeg, subpriceTV, taxpriceTV, totalTV;
    Ramen volcano, veggie;
    int totalAVR, totalVeg;
    double subtotal, tax, total;
    String theOrderSummary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        lessAVRBTN = (ImageButton) findViewById(R.id.lessAVRBTN);
        moreAVRBTN = (ImageButton) findViewById(R.id.moreAVRBTN);
        countAVR = (TextView) findViewById(R.id.countAVR);

        lessVegBTN = (ImageButton) findViewById(R.id.lessVegBTN);
        moreVegBTN = (ImageButton) findViewById(R.id.moreVegBTN);
        countVeg = (TextView) findViewById(R.id.countVeg);

        addVolBTN = (Button) findViewById(R.id.addVolBTN);
        addVegBTN = (Button) findViewById(R.id.addVegBTN);
        finaliseBTN = (Button) findViewById(R.id.finaliseBTN);

        subpriceTV = (TextView) findViewById(R.id.subpriceTV);
        taxpriceTV = (TextView) findViewById(R.id.taxpriceTV);
        totalTV = (TextView) findViewById(R.id.totalTV);

        eggVolCB = (CheckBox) findViewById(R.id.eggVolCB);
        chashuVolCB = (CheckBox) findViewById(R.id.chashuVolCB);
        eggVegCB = (CheckBox) findViewById(R.id.eggVegCB);
        chashuVegCB = (CheckBox) findViewById(R.id.chashuVegCB);

        totalAVR = 0;
        totalVeg = 0;
        subtotal = 0.00;
        tax = 0.00;
        total = 0.00;
        theOrderSummary = "Hello. This is what I will be ordering in your restaurant:\n";

        lessAVRBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalAVR == 0) {
                    totalAVR = 0;
                } else {
                    totalAVR--;
                }
                countAVR.setText("" + totalAVR);
            }
        });


        moreAVRBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalAVR++;
                countAVR.setText("" + totalAVR);
            }
        });

        //create a string variable to add the toString of each ramen made
        addVolBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totalAVR <= 0) {
                    int duration = Toast.LENGTH_SHORT;
                    Toast t = Toast.makeText(getApplicationContext(), "You didn't put in any ramen!", duration);
                    t.show();
                }
                else {
                    volcano = new Ramen("Akira Volcano Ramen Spicy", totalAVR);
                    if(chashuVolCB.isChecked()) {
                        volcano.setHasChashu(true);
                        volcano.addPrice(1.50);
                    }
                    if(eggVolCB.isChecked()) {
                        volcano.setHasSoftEgg(true);
                        volcano.addPrice(1.00);
                    }
                    volcano.setPrice(volcano.getPrice()*totalAVR);
                    subtotal += (volcano.getPrice() * volcano.getQuantity());
                    tax = subtotal * 0.06;
                    total = subtotal + tax;

                    theOrderSummary += volcano.toString() + "\n";
                    subpriceTV.setText(String.format("%.2f", subtotal));
                    taxpriceTV.setText(String.format("%.2f", tax));
                    totalTV.setText(String.format("%.2f", total));
                }
            }
        });

        lessVegBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalVeg == 0) {
                    totalVeg = 0;
                } else {
                    totalVeg--;
                }
                countVeg.setText("" + totalVeg);
            }
        });


        moreVegBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalVeg++;
                countVeg.setText("" + totalVeg);
            }
        });

        addVegBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totalVeg <= 0) {
                    int duration = Toast.LENGTH_SHORT;
                    Toast t = Toast.makeText(getApplicationContext(), "You didn't put in any ramen!", duration);
                    t.show();
                }
                else {
                    veggie = new Ramen("Vegetable Ramen", totalVeg);
                    if(chashuVegCB.isChecked()) {
                        veggie.setHasChashu(true);
                        veggie.addPrice(1.50);
                    }
                    if(eggVegCB.isChecked()) {
                        veggie.setHasSoftEgg(true);
                        veggie.addPrice(1.00);
                    }
                    veggie.setPrice(veggie.getPrice()*totalVeg);
                    subtotal += (veggie.getPrice() * veggie.getQuantity());
                    tax = subtotal * 0.06;
                    total = subtotal + tax;

                    theOrderSummary += veggie.toString() + "\n";
                    subpriceTV.setText(String.format("%.2f", subtotal));
                    taxpriceTV.setText(String.format("%.2f", tax));
                    totalTV.setText(String.format("%.2f", total));
                }
            }
        });

        finaliseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"condejustinejoy@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "My Akira Ramen Order");
                /*if(totalAVR >= 1 && totalVeg >= 1) {
                    intent.putExtra(Intent.EXTRA_TEXT, "Hello, I would like " + volcano.toString() + ". I would also like " + veggie.toString() + ". The subtotal price is $" + subpriceTV.getText() + " and the total price is $" + totalTV.getText() + ". That is all. Thank you very much!");
                    if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
                }
                else if(totalAVR >= 1) {
                    intent.putExtra(Intent.EXTRA_TEXT, "Hello, I would like " + volcano.toString() + ". The subtotal price is $" + subpriceTV.getText() + " and the total price is $" + totalTV.getText() + ". That is all. Thank you very much!");
                    if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
                }
                else if (totalVeg >= 1) {
                    intent.putExtra(Intent.EXTRA_TEXT, "Hello, I would like " + veggie.toString() + ". The subtotal price is $" + subpriceTV.getText() + " and the total price is $" + totalTV.getText() + ". That is all. Thank you very much!");
                    if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
                }
                else {
                    int duration = Toast.LENGTH_SHORT;
                    Toast t = Toast.makeText(getApplicationContext(), "Please create an order first.", duration);
                    t.show();
                }*/

                if(totalAVR >= 1 || totalVeg >= 1) {
                    intent.putExtra(Intent.EXTRA_TEXT, theOrderSummary + "\nThe subtotal price should be $" + subpriceTV.getText() + " and the total price should be $" + totalTV.getText() + ".\nThat is all. Thank you very much!");
                    if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
                }
                else {
                    int duration = Toast.LENGTH_SHORT;
                    Toast t = Toast.makeText(getApplicationContext(), "Please create an order first.", duration);
                    t.show();
                }

            }
        });
    }
}