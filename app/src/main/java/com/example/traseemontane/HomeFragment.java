package com.example.traseemontane;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    public WebView mWebView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);
        TextView title = (TextView)getActivity().findViewById(R.id.toolbar_title);
        title.setText(getString(R.string.app_name));

        mWebView = (WebView) view.findViewById(R.id.webview);
        mWebView.loadUrl("http://www.salvamontromania.ro/");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());
        return view;
    }


}
