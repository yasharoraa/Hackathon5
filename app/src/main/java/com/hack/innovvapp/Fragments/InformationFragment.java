package com.hack.innovvapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hack.innovvapp.Activities.MainActivity;
import com.hack.innovvapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class InformationFragment extends Fragment{

    private int type;

    @BindView(R.id.web_view_info)
    WebView webView;

    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info,container,false);

        if (getArguments()!=null){

            this.type = getArguments().getInt(MainActivity.FEEDBACK_TYPE);

        }

        unbinder = ButterKnife.bind(this,view);

        webView.setWebViewClient(new MyBrowser());

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        if (type == 0){
            webView.loadUrl("https://hi.wikipedia.org/wiki/%E0%A4%88-%E0%A4%AE%E0%A4%BF%E0%A4%A4%E0%A5%8D%E0%A4%B0");

        }else if (type == 1){
            webView.loadUrl("http://suraaj.rajasthan.gov.in/hi/bhamashah-yojana");
        }else if (type == 2){

        }



        return view;
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
