package com.android.sampleplugin.activity;

import java.io.IOException;
import java.util.ArrayList;

import com.android.sampleplugin.component.Slider;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MainActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		WebView webView = new WebView(this);
		webView.clearCache(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebChromeClient(new WebChromeClient() {
                @Override
                public boolean onConsoleMessage(ConsoleMessage cm) {
                        Log.d("MyApplication",
                                        cm.message() + " -- From line " + cm.lineNumber()
                                                        + " of " + cm.sourceId());
                        return true;
                }
        });
		setContentView(webView);
		
		webView.loadUrl("http://192.168.56.1:8088/assets/");
	}
	
}
