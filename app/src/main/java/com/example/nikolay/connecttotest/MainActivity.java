package com.example.nikolay.connecttotest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    TextView txt;
    public String URL="https://stackoverflow.com/questions/39108167/findviewbyid-cannot-resolve-method"
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
txt =(TextView)findViewById(R.id.text);

       new HttpTask().execute();
    }
    private class HttpTask extends AsyncTask<Void,Void,String>
                  {
        OkHttpClient client = new OkHttpClient();
       private static final String URL = "https://stackoverflow.com/questions/39108167/findviewbyid-cannot-resolve-method";
        @Override
        protected String doInBackground(Void...voids)
        {
            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();

                String result = response.body().string();
                return result;
            }catch(IOException e){
            return ":(((";
        }
        }

        @Override
        protected void onPostExecute(String result) {

            TextView textView = (TextView)findViewById(R.id.text);
            textView.setText(result);
        }
    }

}
//        WebView myWebView = (WebView) findViewById(R.id.webview);
//        myWebView.loadUrl("https://vk.com/login?act=mobile&hash=389978535f930dcd");
//        WebSettings webSettings = myWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        myWebView.setWebViewClient(new WebViewClient());