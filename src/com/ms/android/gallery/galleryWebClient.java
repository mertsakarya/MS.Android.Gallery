package com.ms.android.gallery;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class galleryWebClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getScheme().equals("mobile")) {
            //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            //startActivity(intent);
            return true;
        }
        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
        return false;
    }
}
