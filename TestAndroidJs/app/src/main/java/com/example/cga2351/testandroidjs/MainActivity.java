package com.example.cga2351.testandroidjs;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_call_js_if)
    Button btnCallJsIf;
    @Bind(R.id.web_view)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        String htmlFile = getAssets();

        //设置编码
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        //支持js
        webView.getSettings().setJavaScriptEnabled(true);
        //设置背景颜色 透明
        webView.setBackgroundColor(Color.argb(0, 0, 0, 0));
        //设置本地调用对象及其接口
        webView.addJavascriptInterface(new JavaScriptObject(MainActivity.this), "myObj");
        //载入js
        webView.loadUrl("file:///android_asset/test.html");

    }

    @OnClick({R.id.btn_call_js_if, R.id.web_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_call_js_if:

                webView.loadUrl("javascript:funFromjs('aaa')");
//                Toast.makeText(MainActivity.this, "调用javascript:showAndroidToast()", Toast.LENGTH_LONG).show();

                break;
            case R.id.web_view:
                break;
        }
    }

    private class JavaScriptObject {
        Context mContxt;


        public JavaScriptObject(Context mContxt) {
            this.mContxt = mContxt;
        }

        @JavascriptInterface //sdk17版本以上加上注解
        public void fun1FromAndroid(String name) {
            Toast.makeText(mContxt, name, Toast.LENGTH_LONG).show();
        }

        @JavascriptInterface //sdk17版本以上加上注解
        public void fun2(String name) {
            Toast.makeText(mContxt, "调用fun2:" + name, Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface //sdk17版本以上加上注解
        public void showToast(String name) {
            Toast.makeText(mContxt, "showToast:" + name, Toast.LENGTH_SHORT).show();
        }
    }
}
