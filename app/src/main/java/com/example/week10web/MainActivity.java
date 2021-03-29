package com.example.week10web;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import static android.view.KeyEvent.KEYCODE_ENTER;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText edit;
    String input;
    //String prev;
    //String next;
    String current;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        //web.loadUrl("https://www.lut.fi");
        load();
        edit = (EditText) findViewById(R.id.editWeb);
    }
    public void load(){
        web.loadUrl("file:///android_asset/index.html");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void executeJavascript(View v){
        web.evaluateJavascript("shoutOut()", null);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void initializeHTML(View v){
        if (!web.getUrl().equals("file:///android_asset/index.html")){
            load();
        }
        else {
            web.evaluateJavascript("initialize()", null);
        }

    }


    public void webResults(View v){
//        prev = web.getUrl();
//        next = null;
        input = edit.getText().toString();

        web.loadUrl("http://" + input);
        //current = web.getUrl();
    }

    public void refreshPage(View v){
        current = web.getUrl();
        web.loadUrl(current);
    }

    public void prevPage(View v){
//        next = web.getUrl();
//        web.loadUrl(prev);
//        current = prev;
//        prev = null;

        web.goBack();
    }

    public void nextPage(View v){
//        prev = web.getUrl();
//        web.loadUrl(next);
//        current = next;
//        next = null;
        web.goForward();
    }
}