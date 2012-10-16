package com.ms.android.gallery;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class galleryWebClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
    	Uri uri = Uri.parse(url);
        if (uri.getScheme().equals("mobile")) {
        	String imageUri = uri.getQueryParameter("uri");
            String path = "photoSwipe/" + imageUri;
            setWallpaper(path, view.getContext());
            return true;
        } else {
	        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
	        return false;
        }
    }
    
    private void setWallpaper(String path, Context context) {
    	InputStream is;
		try {
			AssetManager assets = context.getAssets();
			is = assets.open(path);
	    	BufferedInputStream bis = new BufferedInputStream(is);
	    	Bitmap bitmap = BitmapFactory.decodeStream(bis);
	    	
			WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
			Display display = wm.getDefaultDisplay();
//			Point size = new Point();
//			display.getSize(size);
//			int width = size.x;
//			int height = size.y;
			int width = display.getWidth();  // deprecated
			int height = display.getHeight();  // deprecated			
			int bitmapWidth = bitmap.getWidth();
			int bitmapHeight = bitmap.getHeight();
			String message = String.format(" Wallpaper is set.\n Screen size(%1$d, %2$d),\n Image size(%3$d, %4$d).\n File name %5$s", width, height,bitmapWidth, bitmapHeight, path);
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	    	Bitmap useThisBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
	    	bitmap.recycle();

	    	WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
			wallpaperManager.setBitmap(useThisBitmap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
    }
}


