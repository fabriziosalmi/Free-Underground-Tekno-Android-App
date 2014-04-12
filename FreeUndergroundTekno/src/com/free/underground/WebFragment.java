package com.free.underground;

import com.free.underground.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebFragment extends Fragment {
	private String currentURL; 
	
	public void init(String url) {
		currentURL = url; 
	} 
	
	@Override 
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState); 
	} 
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d("mycode", "WVF onCreateView");
		View v = inflater.inflate(R.layout.web_layout, container, false);
		if (currentURL != null) {
			Log.d("mycode", "Current URL 1["+currentURL+"]");
			WebView wv = (WebView) v.findViewById(R.id.webPage);
			wv.getSettings().setJavaScriptEnabled(true);
			wv.setWebViewClient(new MBWebClient());
			wv.loadUrl(currentURL); 
		} 
		return v; 
	} 
	
	@SuppressLint("SetJavaScriptEnabled")
	public void updateUrl(String url) {
		Log.d("mycode", "Update URL ["+url+"] - View ["+getView()+"]"); 
		currentURL = url; 
		WebView wv = (WebView) getView().findViewById(R.id.webPage);
		wv.getSettings().setJavaScriptEnabled(true); 
		wv.loadUrl(url); 
	} 
	private class MBWebClient extends WebViewClient { 
		@Override public boolean shouldOverrideUrlLoading(WebView view, String url) { 
            if (url.endsWith(".mp4")) 
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(url), "video/*");

                view.getContext().startActivity(intent);
                return true;
            } 
            else {
                return super.shouldOverrideUrlLoading(view, url);
            }
		} 
	} 
} 

