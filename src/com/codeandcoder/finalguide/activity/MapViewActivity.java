package com.codeandcoder.finalguide.activity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.codeandcoder.finalguide.R;
import com.codeandcoder.finalguide.extra.AllConstants;

public class MapViewActivity extends Activity {
	/** Called when the activity is first created. */
	private WebView fweBview;
	Context con;
	ProgressBar mapprogress;

//	String url = "https://maps.google.com/?q="+ AllConstants.lat+","+ AllConstants.lng+"";
	
	String url = "https://maps.google.com/?saddr="+AllConstants.UPlat+","+AllConstants.UPlng+"&daddr="+ AllConstants.lat+","+ AllConstants.lng+"";

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mapview);
		con = this;
		mapprogress = (ProgressBar) findViewById(R.id.MprogressBar);
		Log.d("sssssssssssssssssssssssssssss",url);
		 
		try {
			updateWebView(url);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private class HelloWebViewClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);

			mapprogress.setVisibility(View.GONE);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && fweBview.canGoBack()) {
			fweBview.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);

	}

	private void updateWebView(String url) {
		// TODO Auto-generated method stub

		fweBview = (WebView) findViewById(R.id.mapView);
		fweBview.getSettings().setJavaScriptEnabled(true);
		fweBview.getSettings().setDomStorageEnabled(true);
		fweBview.loadUrl(url);

		fweBview.setWebViewClient(new HelloWebViewClient());

	}

}