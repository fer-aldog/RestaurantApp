package org.pattersonclippers.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView akiraWV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        akiraWV = (WebView) findViewById(R.id.akiraWV);
        akiraWV.loadUrl("https://www.akiraramenizakaya.com");
        akiraWV.getSettings().setJavaScriptEnabled(true);
        akiraWV.setWebViewClient(new WebViewClient());
    }
}