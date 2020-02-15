package com.example.onboarding;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment {
    private static final String ARG_COUNT = "param1";
    private Integer counter;
    private String[] Youtube = {"rSwPBNu2Li8","ZjJUVsmjIj4","so4FwjfQ7YI","rSwPBNu2Li8"};

    public CardFragment() {
        // Required empty public constructor
    }
    public static CardFragment newInstance(Integer counter) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COUNT, counter);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            counter = getArguments().getInt(ARG_COUNT);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //TextView TvYOutube = view.findViewById(R.id.TvYoutube);
        try {
            WebView mWebView = view.findViewById(R.id.mWebView);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl("http://www.youtube.com/embed/" + Youtube[counter]);
        }catch(Exception e){
            //zodat de app niet crashed
        }



    }
}