package com.spmno.cottagerenren;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.spmno.cottagerenren.utils.Constant;
import com.spmno.cottagerenren.widget.TopNavbar;

public class AuthActivity extends AppBaseActivity {

    private static final String TAG = "AuthActivity";
    private WebView webView;
    private TopNavbar topNavbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topNavbar.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_auth;
    }

    @Override
    protected void setupView() {
        topNavbar = (TopNavbar)findViewById(R.id.rl_top_navbar);
        webView = (WebView)findViewById(R.id.wv_auth);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalFadingEdgeEnabled(false);
        webView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    protected void initData() {
        StringBuilder authorizeUrl = new StringBuilder(Constant.AUTHORIZE_URL);
        authorizeUrl.append("?");
        authorizeUrl.append("client_id=").append(Constant.API_KEY);
        authorizeUrl.append("&redirect_uri=").append(Constant.DEFAULT_REDIRECT_URI);
        authorizeUrl.append("&response_type=").append("token");
        authorizeUrl.append("&display=").append("touch");
        String scope = TextUtils.join(" ", Constant.HAVE_PERMISSIONS);
        authorizeUrl.append("&scope=").append(scope);
        Log.i(TAG, "authorizeUrl = " + authorizeUrl.toString());

        webView.loadUrl(authorizeUrl.toString());
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webViewParam, String url) {
                Log.i(TAG,  "shouldOverrideUrlLoading() Redirect URL = " + url);

                if (url.startsWith(Constant.DEFAULT_REDIRECT_URI + "#error=login_denied")) {
                    AuthActivity.this.onBackPressed();
                } else if (url.startsWith("http://graph.renren.com/oauth/login_success.html#access_token")) {
                    String accessToken = url.substring(url.indexOf("="), url.indexOf("&"));
                    Log.i(TAG, "accessToken = " + accessToken);

                    AuthActivity.this.onBackPressed();
                    return false;
                }

                webViewParam.loadUrl(url);
                return true;
            }

            public void onReceivedSslError(WebView webViewParam, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public void onReceivedError(WebView webViewParam, int errorCode,
                                        String description, String failingUrl) {
                super.onReceivedError(webViewParam, errorCode, description, failingUrl);
                AuthActivity.this.onBackPressed();
            }

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.i(TAG, "Webview loading url: " + url);
                super.onPageStarted(view, url, favicon);
            }

            public void onPageFinished(WebView view, String url) {
                Log.i(TAG, "onPageFinished() url = " + url);
                super.onPageFinished(view, url);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView != null) {
                webView.stopLoading();
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.auth, menu);
        return true;
    }
    
}
