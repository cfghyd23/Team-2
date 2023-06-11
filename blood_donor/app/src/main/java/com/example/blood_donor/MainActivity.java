package com.example.blood_donor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        myWebView.setWebViewClient(new Callback());
        myWebView.loadUrl("http://10.49.246.108:3000/");
//        myWebView.loadUrl("http://192.168.56.1:3000/");

    }
    private class Callback extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView wv,String url){
            return false;
        }

    }
    @Override
    public void onBackPressed(){
        if(myWebView!= null && myWebView.canGoBack()){
            myWebView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}