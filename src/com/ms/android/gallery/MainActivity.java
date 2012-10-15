package com.ms.android.gallery;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

@SuppressLint({ "ShowToast", "SetJavaScriptEnabled" })
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		String workingFileYo = "index.html";
		String resultsPageUrl = "file:///android_asset/photoSwipe/" + workingFileYo;
        WebView wv = (WebView) findViewById(R.id.webView1);
        wv.addJavascriptInterface(new JavascriptInterface(wv), "Android");
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
		wv.loadUrl(resultsPageUrl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void WebView1_onClick(View v) {
    	Toast.makeText(this, "Bidi", Toast.LENGTH_SHORT).show();
    }
}
