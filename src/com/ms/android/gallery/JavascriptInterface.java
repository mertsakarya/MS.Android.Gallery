package com.ms.android.gallery;

import android.webkit.WebView;
import android.widget.Toast;

public class JavascriptInterface {
    private WebView mAppView;

    /** Instantiate the interface and set the context */
    JavascriptInterface(WebView appView) {
    	mAppView = appView;
    }

	/** Show a toast from the web page */
    public void showToast(String toast) {
        Toast.makeText(mAppView.getContext(), toast, Toast.LENGTH_SHORT).show();
    }
}