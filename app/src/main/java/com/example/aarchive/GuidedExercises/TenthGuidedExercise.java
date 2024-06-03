package com.example.aarchive.GuidedExercises;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aarchive.MainActivity;
import com.example.aarchive.R;

public class TenthGuidedExercise extends AppCompatActivity {

    WebView browser;
    AutoCompleteTextView suggestedURL;
    ArrayAdapter adapter;
    Button submit;
    String [] urls = {"facebook.com","youtube.com"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth_guided_exercise);
        browser = findViewById(R.id.webView);
        suggestedURL = findViewById(R.id.actvURLGE10);
        submit = findViewById(R.id.btnOpenURLGE10);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,urls);
        suggestedURL.setThreshold(2);
        suggestedURL.setAdapter(adapter);
        initializeWebView();
        loadWebURL();

        ImageButton btnBackGE10 = findViewById(R.id.btnBackGE10);

        btnBackGE10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TenthGuidedExercise.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }
    public void initializeWebView(){
        browser.getSettings().setLoadsImagesAutomatically(true);
        // enabled java script
        browser.getSettings().setJavaScriptEnabled(true);
        // Android webview launches browser when calling loadurl
        browser.setWebViewClient(new WebViewClient());
        // enabled Scrollbar
        browser.setScrollBarStyle(browser.SCROLLBARS_INSIDE_OVERLAY);
    }
    public void loadWebURL(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = suggestedURL.getText().toString();
                if(!url.startsWith("www.") && !url.startsWith("https://") ){
                    url = "www." + url;
                }
                if(!url.startsWith("https://") ){
                    url = "https://" + url;
                }
                browser.loadUrl(url);
            }
        });
    }
}