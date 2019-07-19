package com.appnexus.opensdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.StringUtil;
import com.appnexus.opensdk.utils.ViewUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BrowserAdActivity
  implements AdActivity.a
{
  public static LinkedList<WebView> BROWSER_QUEUE = new LinkedList();
  private Activity a;
  private WebView b;

  public BrowserAdActivity(Activity paramActivity)
  {
    this.a = paramActivity;
  }

  private void a()
  {
    this.a.finish();
  }

  private void a(String paramString)
  {
    if (StringUtil.isEmpty(paramString));
    for (Uri localUri = null; localUri == null; localUri = Uri.parse(paramString))
    {
      Clog.w(Clog.browserLogTag, Clog.getString(R.string.opening_url_failed, paramString));
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
    localIntent.setFlags(268435456);
    try
    {
      this.a.startActivity(localIntent);
      destroy();
      a();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Clog.w(Clog.browserLogTag, Clog.getString(R.string.opening_url_failed, paramString));
    }
  }

  public void backPressed()
  {
  }

  public void browserLaunched()
  {
  }

  @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
  @TargetApi(17)
  public void create()
  {
    this.a.setContentView(R.layout.activity_in_app_browser);
    this.b = ((WebView)BROWSER_QUEUE.poll());
    if ((this.b == null) || (this.b.getSettings() == null))
    {
      a();
      return;
    }
    if ((this.b.getContext() instanceof MutableContextWrapper))
      ((MutableContextWrapper)this.b.getContext()).setBaseContext(this.a);
    WebView localWebView = (WebView)this.a.findViewById(R.id.web_view);
    ViewGroup.LayoutParams localLayoutParams = localWebView.getLayoutParams();
    ViewGroup localViewGroup = (ViewGroup)localWebView.getParent();
    int i = localViewGroup.indexOfChild(localWebView);
    localViewGroup.removeView(localWebView);
    ViewUtil.removeChildFromParent(this.b);
    this.b.setLayoutParams(localLayoutParams);
    localViewGroup.addView(this.b, i);
    final ImageButton localImageButton1 = (ImageButton)this.a.findViewById(R.id.browser_back);
    final ImageButton localImageButton2 = (ImageButton)this.a.findViewById(R.id.browser_forward);
    ImageButton localImageButton3 = (ImageButton)this.a.findViewById(R.id.open_browser);
    ImageButton localImageButton4 = (ImageButton)this.a.findViewById(R.id.browser_refresh);
    final ProgressBar localProgressBar = (ProgressBar)this.a.findViewById(R.id.progress_bar);
    localImageButton1.setEnabled(false);
    localImageButton2.setEnabled(false);
    int j = Build.VERSION.SDK_INT;
    Object localObject1;
    label305: Object localObject2;
    if (j >= 17)
    {
      Drawable localDrawable = this.a.getResources().getDrawable(17301540).mutate();
      localImageButton1.setScaleX(-1.0F);
      localImageButton1.setLayoutDirection(1);
      localImageButton1.setImageDrawable(localDrawable);
      String str = this.a.getIntent().getStringExtra("bridgeid");
      if (str == null)
        break label432;
      localObject1 = null;
      Iterator localIterator = AdView.b.d.iterator();
      if (!localIterator.hasNext())
        break label390;
      Pair localPair = (Pair)localIterator.next();
      if (!((String)localPair.first).equals(str))
        break label558;
      localObject2 = (AdView.b)localPair.second;
      AdView.b.d.remove(localPair);
    }
    while (true)
    {
      localObject1 = localObject2;
      break label305;
      localImageButton1.post(new Runnable()
      {
        public void run()
        {
          Bitmap localBitmap1 = BitmapFactory.decodeResource(BrowserAdActivity.a(BrowserAdActivity.this).getResources(), 17301540);
          localImageButton2.setImageBitmap(localBitmap1);
          Matrix localMatrix = new Matrix();
          localImageButton1.setScaleType(ImageView.ScaleType.MATRIX);
          localMatrix.postRotate(180.0F);
          Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), localMatrix, true);
          localImageButton1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          localImageButton2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          localImageButton1.setImageBitmap(localBitmap2);
        }
      });
      break;
      label390: if (localObject1 != null)
      {
        if (j < 16)
          break label525;
        localImageButton1.setBackground(localObject1.b);
        localImageButton2.setBackground(localObject1.a);
        localImageButton4.setBackground(localObject1.c);
      }
      while (true)
      {
        label432: localImageButton1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            BrowserAdActivity.b(BrowserAdActivity.this).goBack();
          }
        });
        localImageButton2.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            BrowserAdActivity.b(BrowserAdActivity.this).goForward();
          }
        });
        localImageButton4.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            BrowserAdActivity.b(BrowserAdActivity.this).reload();
          }
        });
        localImageButton3.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Clog.d(Clog.browserLogTag, Clog.getString(R.string.opening_native_current));
            BrowserAdActivity.a(BrowserAdActivity.this, BrowserAdActivity.b(BrowserAdActivity.this).getUrl());
          }
        });
        this.b.setWebViewClient(new WebViewClient()
        {
          public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
          {
            localImageButton1.setEnabled(paramAnonymousWebView.canGoBack());
            localImageButton2.setEnabled(paramAnonymousWebView.canGoForward());
            CookieSyncManager localCookieSyncManager = CookieSyncManager.getInstance();
            if (localCookieSyncManager != null)
              localCookieSyncManager.sync();
          }

          public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
          {
            Clog.v(Clog.browserLogTag, Clog.getString(R.string.opening_url, paramAnonymousString));
            if (paramAnonymousString.startsWith("http"))
              return false;
            BrowserAdActivity.a(BrowserAdActivity.this, paramAnonymousString);
            return true;
          }
        });
        this.b.setWebChromeClient(new t(this.a)
        {
          public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
          {
            Clog.w(Clog.browserLogTag, Clog.getString(R.string.console_message, paramAnonymousConsoleMessage.message(), paramAnonymousConsoleMessage.lineNumber(), paramAnonymousConsoleMessage.sourceId()));
            return true;
          }

          public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
          {
            Clog.w(Clog.browserLogTag, Clog.getString(R.string.js_alert, paramAnonymousString2, paramAnonymousString1));
            paramAnonymousJsResult.confirm();
            return true;
          }

          public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
          {
            if ((paramAnonymousInt < 100) && (localProgressBar.getVisibility() == 8))
              localProgressBar.setVisibility(0);
            localProgressBar.setProgress(paramAnonymousInt);
            if (paramAnonymousInt == 100)
              localProgressBar.setVisibility(8);
          }

          public void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
          {
            super.onShowCustomView(paramAnonymousView, paramAnonymousCustomViewCallback);
            if ((paramAnonymousView instanceof FrameLayout))
            {
              FrameLayout localFrameLayout = (FrameLayout)paramAnonymousView;
              if ((localFrameLayout.getFocusedChild() instanceof VideoView))
              {
                VideoView localVideoView = (VideoView)localFrameLayout.getFocusedChild();
                localFrameLayout.removeView(localVideoView);
                ((Activity)BrowserAdActivity.b(BrowserAdActivity.this).getContext()).setContentView(localVideoView);
                localVideoView.start();
              }
            }
          }
        });
        return;
        label525: localImageButton1.setBackgroundDrawable(localObject1.b);
        localImageButton2.setBackgroundDrawable(localObject1.a);
        localImageButton4.setBackgroundDrawable(localObject1.c);
      }
      label558: localObject2 = localObject1;
    }
  }

  public void destroy()
  {
    if (this.b == null)
      return;
    ViewUtil.removeChildFromParent(this.b);
    this.b.destroy();
  }

  public WebView getWebView()
  {
    return this.b;
  }

  public void interacted()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.BrowserAdActivity
 * JD-Core Version:    0.6.2
 */