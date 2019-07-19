package com.appnexus.opensdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.appnexus.opensdk.ut.UTAdRequester;
import com.appnexus.opensdk.ut.adresponse.BaseAdResponse;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.HTTPGet;
import com.appnexus.opensdk.utils.HTTPResponse;
import com.appnexus.opensdk.utils.Settings;
import com.appnexus.opensdk.utils.StringUtil;
import com.appnexus.opensdk.utils.ViewUtil;
import com.appnexus.opensdk.utils.WebviewUtil;
import com.appnexus.opensdk.viewability.ANOmidBannerHTMLAdSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
class f extends WebView
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, i
{
  private int A = 200;
  private Date B = new Date();
  private t C;
  private final Runnable D = new Runnable()
  {
    public void run()
    {
      if (f.i(f.this))
        return;
      f.this.s();
      f.k(f.this).postDelayed(this, f.j(f.this));
    }
  };
  AdView a;
  boolean b = false;
  protected String c;
  protected BaseAdResponse d;
  private boolean e = false;
  private u f = null;
  private UTAdRequester g;
  private boolean h = false;
  private boolean i;
  private MRAIDImplementation j;
  private ANOmidBannerHTMLAdSession k;
  private int l;
  private int m;
  private boolean n;
  private int o;
  private int p;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private Handler t = new Handler();
  private boolean u = false;
  private int v;
  private ProgressDialog w;
  private boolean x = false;
  private boolean y = false;
  private int z = 1000;

  public f(AdView paramAdView, UTAdRequester paramUTAdRequester)
  {
    super(new MutableContextWrapper(paramAdView.getContext()));
    this.a = paramAdView;
    this.g = paramUTAdRequester;
    this.c = MRAIDImplementation.a[MRAIDImplementation.MRAID_INIT_STATE.STARTING_DEFAULT.ordinal()];
    a();
    b();
  }

  private void A()
  {
    if ((this.a != null) && ((this.a instanceof InterstitialAdView)))
      ((InterstitialAdView)this.a).i();
  }

  private void B()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver.isAlive())
    {
      localViewTreeObserver.removeOnScrollChangedListener(this);
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }

  private void C()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver.isAlive())
    {
      localViewTreeObserver.removeOnScrollChangedListener(this);
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
      localViewTreeObserver.addOnScrollChangedListener(this);
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      WebviewUtil.onResume(this);
      this.s = true;
      if ((this.i) && (this.n))
        y();
    }
    while (true)
    {
      this.j.c();
      return;
      WebviewUtil.onPause(this);
      this.s = false;
      z();
    }
  }

  private void a(WebView paramWebView)
  {
    Class localClass = AdActivity.getActivityClass();
    Intent localIntent = new Intent(this.a.getContext(), localClass);
    localIntent.setFlags(268435456);
    localIntent.putExtra("ACTIVITY_TYPE", "BROWSER");
    BrowserAdActivity.BROWSER_QUEUE.add(paramWebView);
    if (this.a.getBrowserStyle() != null)
    {
      String str = "" + super.hashCode();
      localIntent.putExtra("bridgeid", str);
      AdView.b.d.add(new Pair(str, this.a.getBrowserStyle()));
    }
    try
    {
      this.a.getContext().startActivity(localIntent);
      A();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Clog.w(Clog.baseLogTag, Clog.getString(R.string.adactivity_missing, localClass.getName()));
      BrowserAdActivity.BROWSER_QUEUE.remove();
    }
  }

  private void a(HashMap paramHashMap)
  {
    if (paramHashMap.isEmpty())
      return;
    if (paramHashMap.containsKey("MRAID"))
      this.i = ((Boolean)paramHashMap.get("MRAID")).booleanValue();
    if ((paramHashMap.containsKey("ORIENTATION")) && (paramHashMap.get("ORIENTATION").equals("h")))
    {
      this.v = 2;
      return;
    }
    this.v = 1;
  }

  private void b(int paramInt)
  {
    this.o = paramInt;
  }

  private void c(int paramInt)
  {
    this.p = paramInt;
  }

  private String f(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      paramString = paramString.trim();
      if (!paramString.startsWith("<html>"))
        paramString = "<html><body style='padding:0;margin:0;'>" + paramString + "</body></html>";
    }
    return paramString;
  }

  private String g(String paramString)
  {
    StringBuilder localStringBuilder;
    if (!StringUtil.isEmpty(paramString))
    {
      Resources localResources = getResources();
      localStringBuilder = new StringBuilder("<html><head><script>");
      if ((localResources == null) || (!StringUtil.appendRes(localStringBuilder, localResources, R.raw.sdkjs)) || (!StringUtil.appendRes(localStringBuilder, localResources, R.raw.anjam)) || (!StringUtil.appendRes(localStringBuilder, localResources, R.raw.apn_mraid)))
        Clog.e(Clog.baseLogTag, "Error reading SDK's raw resources.");
    }
    else
    {
      return paramString;
    }
    localStringBuilder.append("</script></head>");
    return paramString.replaceFirst("<html>", localStringBuilder.toString());
  }

  private String h(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
      paramString = paramString.replaceFirst("<head>", "<head><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,user-scalable=no\"/>");
    return paramString;
  }

  private boolean i(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    localIntent.setFlags(268435456);
    try
    {
      this.a.getContext().startActivity(localIntent);
      bool2 = true;
      return bool2;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      boolean bool1;
      do
      {
        Clog.w(Clog.baseLogTag, Clog.getString(R.string.opening_url_failed, paramString));
        bool1 = this.i;
        boolean bool2 = false;
      }
      while (!bool1);
      Toast.makeText(this.a.getContext(), R.string.action_cant_be_completed, 0).show();
    }
    return false;
  }

  private boolean j(String paramString)
  {
    if ((paramString.contains("://play.google.com")) || ((!paramString.startsWith("http")) && (!paramString.startsWith("about:blank"))))
    {
      Clog.i(Clog.baseLogTag, Clog.getString(R.string.opening_app_store));
      return i(paramString);
    }
    return false;
  }

  private AdResponse w()
  {
    return new AdResponse()
    {
      public void destroy()
      {
        f.this.destroy();
      }

      public i getDisplayable()
      {
        return f.this;
      }

      public MediaType getMediaType()
      {
        return f.this.a.getMediaType();
      }

      public NativeAdResponse getNativeAdResponse()
      {
        return null;
      }

      public BaseAdResponse getResponseData()
      {
        return f.this.d;
      }

      public boolean isMediated()
      {
        return "ssm".equalsIgnoreCase(f.this.d.getContentSource());
      }
    };
  }

  private boolean x()
  {
    return new Date().getTime() - this.B.getTime() < this.A;
  }

  private void y()
  {
    if (!this.s)
      return;
    this.u = false;
    this.t.removeCallbacks(this.D);
    this.t.post(this.D);
  }

  private void z()
  {
    this.u = true;
    this.t.removeCallbacks(this.D);
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  protected void a()
  {
    Settings.getSettings().ua = getSettings().getUserAgentString();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setLightTouchEnabled(false);
    getSettings().setLoadsImagesAutomatically(true);
    getSettings().setSupportZoom(false);
    getSettings().setUseWideViewPort(false);
    if (Build.VERSION.SDK_INT >= 17)
      getSettings().setMediaPlaybackRequiresUserGesture(false);
    if (Build.VERSION.SDK_INT >= 21)
      getSettings().setMixedContentMode(0);
    getSettings().setAllowFileAccess(false);
    if (Build.VERSION.SDK_INT >= 11)
      getSettings().setAllowContentAccess(false);
    if (Build.VERSION.SDK_INT >= 16)
    {
      getSettings().setAllowFileAccessFromFileURLs(false);
      getSettings().setAllowUniversalAccessFromFileURLs(false);
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      CookieManager localCookieManager = CookieManager.getInstance();
      if (localCookieManager == null)
        break label202;
      localCookieManager.setAcceptThirdPartyCookies(this, true);
    }
    while (true)
    {
      setHorizontalScrollbarOverlay(false);
      setHorizontalScrollBarEnabled(false);
      setVerticalScrollbarOverlay(false);
      setVerticalScrollBarEnabled(false);
      setBackgroundColor(0);
      setScrollBarStyle(0);
      return;
      label202: Clog.d(Clog.baseLogTag, "Failed to set Webview to accept 3rd party cookie");
    }
  }

  public void a(int paramInt)
  {
    this.z = paramInt;
    this.A = paramInt;
    z();
    y();
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, MRAIDImplementation.CUSTOM_CLOSE_POSITION paramCUSTOM_CLOSE_POSITION, boolean paramBoolean)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getLayoutParams());
    if (!this.j.d)
    {
      this.l = localLayoutParams.width;
      this.m = localLayoutParams.height;
    }
    int i1 = (int)(0.5D + paramInt2 * localDisplayMetrics.density);
    int i2 = (int)(0.5D + paramInt1 * localDisplayMetrics.density);
    localLayoutParams.height = i1;
    localLayoutParams.width = i2;
    localLayoutParams.gravity = 17;
    if (this.a != null)
      this.a.a(i2, i1, paramInt3, paramInt4, paramCUSTOM_CLOSE_POSITION, paramBoolean, this.j);
    if (this.a != null)
      this.a.h();
    setLayoutParams(localLayoutParams);
  }

  void a(int paramInt1, int paramInt2, boolean paramBoolean1, final MRAIDImplementation paramMRAIDImplementation, final boolean paramBoolean2, final AdActivity.b paramb)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getLayoutParams());
    if (!this.j.d)
    {
      this.l = localLayoutParams.width;
      this.m = localLayoutParams.height;
    }
    if ((paramInt2 == -1) && (paramInt1 == -1) && (this.a != null))
      this.b = true;
    if (paramInt2 != -1);
    for (int i1 = (int)(0.5D + paramInt2 * localDisplayMetrics.density); ; i1 = paramInt2)
    {
      if (paramInt1 != -1);
      for (int i2 = (int)(0.5D + paramInt1 * localDisplayMetrics.density); ; i2 = paramInt1)
      {
        localLayoutParams.height = i1;
        localLayoutParams.width = i2;
        localLayoutParams.gravity = 17;
        boolean bool = this.b;
        b local4 = null;
        if (bool)
          local4 = new b()
          {
            public void a()
            {
              if ((paramMRAIDImplementation != null) && (paramMRAIDImplementation.d() != null))
              {
                f.this.a(paramMRAIDImplementation.d(), paramBoolean2, paramb);
                AdView.q = null;
              }
            }
          };
        if (this.a != null)
        {
          this.a.a(i2, i1, paramBoolean1, paramMRAIDImplementation, local4);
          this.a.h();
        }
        setLayoutParams(localLayoutParams);
        return;
      }
    }
  }

  protected void a(Activity paramActivity, boolean paramBoolean, AdActivity.b paramb)
  {
    if (paramb != AdActivity.b.c)
      AdActivity.a(paramActivity, paramb);
    if (paramBoolean)
      AdActivity.b(paramActivity);
    while (paramb != AdActivity.b.c)
      return;
    AdActivity.a(paramActivity);
  }

  public void a(BaseAdResponse paramBaseAdResponse)
  {
    int i1 = -1;
    if (paramBaseAdResponse == null)
    {
      f();
      return;
    }
    String str1 = paramBaseAdResponse.getAdContent();
    c(paramBaseAdResponse.getHeight());
    b(paramBaseAdResponse.getWidth());
    if (StringUtil.isEmpty(str1))
    {
      f();
      return;
    }
    Clog.i(Clog.baseLogTag, Clog.getString(R.string.webview_loading, str1));
    a(paramBaseAdResponse.getExtras());
    this.d = paramBaseAdResponse;
    this.h = "video".equalsIgnoreCase(this.d.getAdType());
    float f1 = this.a.getContext().getResources().getDisplayMetrics().density;
    int i2;
    if ((paramBaseAdResponse.getHeight() == 1) && (paramBaseAdResponse.getWidth() == 1))
      i2 = i1;
    while (true)
    {
      setLayoutParams(new FrameLayout.LayoutParams(i1, i2, 17));
      if (!this.h)
        break;
      this.f = new u(this);
      this.f.b(str1);
      loadUrl(Settings.getVideoHtmlPage());
      return;
      i2 = (int)(0.5F + f1 * paramBaseAdResponse.getHeight());
      i1 = (int)(0.5F + f1 * paramBaseAdResponse.getWidth());
    }
    String str2 = h(g(f(str1)));
    String str3 = this.k.prependOMIDJSToHTML(str2);
    loadDataWithBaseURL(Settings.getBaseUrl(), str3, "text/html", "UTF-8", null);
  }

  protected void a(final String paramString)
  {
    new HTTPGet()
    {
      protected String a()
      {
        return paramString;
      }

      protected void a(HTTPResponse paramAnonymousHTTPResponse)
      {
        if (paramAnonymousHTTPResponse.getSucceeded())
        {
          String str1 = f.a(f.this, paramAnonymousHTTPResponse.getResponseBody());
          String str2 = f.b(f.this, str1);
          String str3 = f.c(f.this, str2);
          f.this.loadDataWithBaseURL(Settings.getBaseUrl(), str3, "text/html", "UTF-8", null);
          f.this.p();
        }
      }
    }
    .execute(new Void[0]);
  }

  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  protected void b()
  {
    this.j = new MRAIDImplementation(this);
    this.k = new ANOmidBannerHTMLAdSession();
    this.C = new t(this);
    setWebChromeClient(this.C);
    setWebViewClient(new a(null));
  }

  void b(String paramString)
  {
    if (this.a != null)
    {
      this.a.getAdDispatcher().a(paramString);
      this.a.h();
    }
  }

  protected MRAIDImplementation c()
  {
    return this.j;
  }

  void c(String paramString)
  {
    if (this.a.getClickThroughAction() == ANClickThroughAction.RETURN_URL)
    {
      b(paramString);
      return;
    }
    d(paramString);
    e();
  }

  void d(String paramString)
  {
    if (this.a.getClickThroughAction() == ANClickThroughAction.OPEN_SDK_BROWSER)
    {
      Clog.d(Clog.baseLogTag, Clog.getString(R.string.opening_inapp));
      if (!j(paramString));
    }
    while (this.a.getClickThroughAction() != ANClickThroughAction.OPEN_DEVICE_BROWSER)
    {
      while (true)
      {
        return;
        try
        {
          if (this.a.getLoadsInBackground())
          {
            final c localc = new c(getContext());
            localc.loadUrl(paramString);
            localc.setVisibility(8);
            this.a.addView(localc);
            if (!this.a.getShowLoadingIndicator())
              continue;
            this.w = new ProgressDialog(v());
            this.w.setCancelable(true);
            this.w.setOnCancelListener(new DialogInterface.OnCancelListener()
            {
              public void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                localc.stopLoading();
              }
            });
            this.w.setMessage(getContext().getResources().getString(R.string.loading));
            this.w.setProgressStyle(0);
            this.w.show();
          }
        }
        catch (Exception localException)
        {
          Clog.e(Clog.baseLogTag, "Exception initializing the redirect webview: " + localException.getMessage());
          return;
        }
      }
      WebView localWebView = new WebView(new MutableContextWrapper(getContext()));
      WebviewUtil.setWebViewSettings(localWebView);
      localWebView.loadUrl(paramString);
      a(localWebView);
      return;
    }
    Clog.d(Clog.baseLogTag, Clog.getString(R.string.opening_native));
    i(paramString);
    A();
  }

  boolean d()
  {
    return this.y;
  }

  public void destroy()
  {
    if (this.C != null)
      this.C.onHideCustomView();
    if (!this.h)
      this.k.stopAdSession();
    ViewUtil.removeChildFromParent(this);
    try
    {
      super.destroy();
      removeAllViews();
      z();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        Clog.e(Clog.baseLogTag, Clog.getString(R.string.apn_webview_failed_to_destroy), localIllegalArgumentException);
    }
  }

  void e()
  {
    if (this.a != null)
    {
      this.a.getAdDispatcher().c();
      this.a.h();
    }
  }

  protected void e(String paramString)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        evaluateJavascript(paramString, null);
        return;
      }
      loadUrl(paramString);
      return;
    }
    catch (Exception localException)
    {
      Clog.e(Clog.baseLogTag, "AdWebView.injectJavaScript -- Caught EXCEPTION...", localException);
    }
  }

  protected void f()
  {
    this.e = true;
    if (this.g != null)
      this.g.continueWaterfall(ResultCode.INTERNAL_ERROR);
  }

  protected void g()
  {
    if (this.g != null)
      this.g.onReceiveAd(w());
  }

  int h()
  {
    return this.v;
  }

  public View i()
  {
    return this;
  }

  public boolean j()
  {
    return this.e;
  }

  public int k()
  {
    return this.o;
  }

  public int l()
  {
    return this.p;
  }

  public void m()
  {
    destroy();
  }

  public void n()
  {
    if (!this.h)
      this.k.fireImpression();
  }

  public boolean o()
  {
    return this.x;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    C();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    s();
  }

  protected void onDetachedFromWindow()
  {
    B();
    super.onDetachedFromWindow();
    if ((this.w != null) && (this.w.isShowing()))
      this.w.dismiss();
  }

  public void onGlobalLayout()
  {
    s();
  }

  public void onScrollChanged()
  {
    s();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.y = true;
    return super.onTouchEvent(paramMotionEvent);
  }

  public void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    a(getWindowVisibility(), paramInt);
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    a(paramInt, getVisibility());
  }

  public void p()
  {
    if (this.i);
    do
    {
      return;
      this.i = true;
    }
    while (!this.n);
    this.j.a(this, this.c);
    y();
  }

  void q()
  {
    if (this.a != null)
      this.a.c();
  }

  void r()
  {
    if (this.a != null)
      this.a.a(this.l, this.m, this.j);
  }

  protected void s()
  {
    boolean bool1 = true;
    if (x());
    while (!(v() instanceof Activity))
      return;
    int[] arrayOfInt1 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    Rect localRect1 = new Rect();
    boolean bool2 = getGlobalVisibleRect(localRect1);
    int i1 = arrayOfInt1[0];
    int i2 = arrayOfInt1[0] + getWidth();
    int i3 = arrayOfInt1[bool1];
    int i4 = arrayOfInt1[bool1] + getHeight();
    double d1 = 100.0D * (localRect1.height() * localRect1.width() / (getHeight() * getWidth()));
    int[] arrayOfInt2 = ViewUtil.getScreenSizeAsPixels((Activity)v());
    boolean bool3;
    if ((i2 > 0) && (i1 < arrayOfInt2[0]) && (i4 > 0) && (i3 < arrayOfInt2[bool1]))
    {
      bool3 = bool1;
      this.q = bool3;
      if (this.j != null)
      {
        this.j.c();
        this.j.a(i1, i3, getWidth(), getHeight());
        int i5 = getContext().getResources().getConfiguration().orientation;
        this.j.a(i5);
        if (!bool2)
          break label297;
        Rect localRect2 = new Rect();
        getLocalVisibleRect(localRect2);
        this.j.a(d1, localRect2);
      }
      label239: if ((this.h) && (this.f != null))
      {
        if (!bool2)
          break label314;
        if (d1 < 50.0D)
          break label309;
      }
    }
    label267: label297: label309: label314: for (this.r = bool1; ; this.r = false)
    {
      this.f.c();
      this.B = new Date();
      return;
      bool3 = false;
      break;
      this.j.a(0.0D, null);
      break label239;
      bool1 = false;
      break label267;
    }
  }

  public void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(0, 0);
  }

  boolean t()
  {
    return (this.q) && (this.s);
  }

  boolean u()
  {
    return (this.r) && (this.s);
  }

  protected Context v()
  {
    if ((getContext() instanceof MutableContextWrapper))
      return ((MutableContextWrapper)getContext()).getBaseContext();
    return getContext();
  }

  private class a extends WebViewClient
  {
    private a()
    {
    }

    public void onLoadResource(WebView paramWebView, String paramString)
    {
      if (paramString.startsWith("http"))
        try
        {
          WebView.HitTestResult localHitTestResult = f.this.getHitTestResult();
          if (localHitTestResult == null)
            return;
          if (localHitTestResult.getExtra() != null)
          {
            boolean bool = localHitTestResult.getExtra().equals(paramString);
            if (bool)
            {
              switch (localHitTestResult.getType())
              {
              case 2:
              case 3:
              case 4:
              case 5:
              default:
                return;
              case 1:
              case 6:
              case 7:
              case 8:
              }
              f.this.d(paramString);
              paramWebView.stopLoading();
              f.this.e();
              return;
            }
          }
        }
        catch (NullPointerException localNullPointerException)
        {
        }
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (!f.f(f.this))
      {
        f.this.e("javascript:window.mraid.util.pageFinished()");
        if (f.a(f.this))
        {
          f.c(f.this).a(f.this, f.this.c);
          f.g(f.this);
        }
        if ((!f.d(f.this)) || (f.e(f.this) == null))
          break label127;
        f.e(f.this).a();
      }
      while (true)
      {
        if (!f.d(f.this))
          f.h(f.this).initAdSession(f.this);
        f.a(f.this, true);
        return;
        label127: if (!f.c(f.this).k)
        {
          Clog.i(Clog.baseLogTag, "AdWebView.onPageFinished -- !isMRAIDTwoPartExpanded seding back success");
          f.this.g();
        }
      }
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      Clog.w(Clog.httpRespLogTag, Clog.getString(R.string.webview_received_error, paramInt, paramString1, paramString2));
    }

    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      f.this.f();
      Clog.w(Clog.httpRespLogTag, Clog.getString(R.string.webclient_error, paramSslError.getPrimaryError(), paramSslError.toString()));
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      boolean bool = true;
      Clog.v(Clog.baseLogTag, "Loading URL: " + paramString);
      if (paramString.startsWith("javascript:"))
        bool = false;
      String str;
      do
      {
        return bool;
        if (!paramString.startsWith("mraid://"))
          break;
        Clog.v(Clog.mraidLogTag, paramString);
        if (f.a(f.this))
        {
          f.c(f.this).a(paramString, f.b(f.this));
          return bool;
        }
        str = Uri.parse(paramString).getHost();
        if ((str != null) && (str.equals("enable")))
        {
          f.this.p();
          return bool;
        }
      }
      while ((str == null) || (!str.equals("open")));
      f.c(f.this).a(paramString, f.b(f.this));
      return bool;
      if (paramString.startsWith("anjam://"))
      {
        a.a(f.this, paramString);
        return bool;
      }
      if (paramString.startsWith("appnexuspb://"))
      {
        s.a(f.this, paramString);
        return bool;
      }
      if ((paramString.startsWith("video://")) && (f.d(f.this)) && (f.e(f.this) != null))
      {
        f.e(f.this).a(paramString);
        return bool;
      }
      f.this.c(paramString);
      return bool;
    }
  }

  static abstract interface b
  {
    public abstract void a();
  }

  private class c extends WebView
  {
    @SuppressLint({"SetJavaScriptEnabled"})
    public c(Context arg2)
    {
      super();
      WebviewUtil.setWebViewSettings(this);
      setWebViewClient(new WebViewClient()
      {
        private boolean c = false;

        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          Clog.v(Clog.browserLogTag, "Opening URL: " + paramAnonymousString);
          ViewUtil.removeChildFromParent(f.c.this);
          if ((f.l(f.this) != null) && (f.l(f.this).isShowing()))
            f.l(f.this).dismiss();
          if (this.c)
          {
            this.c = false;
            f.c.this.destroy();
            f.m(f.this);
            return;
          }
          f.c.this.setVisibility(0);
          f.a(f.this, f.c.this);
        }

        public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          Clog.v(Clog.browserLogTag, "Redirecting to URL: " + paramAnonymousString);
          this.c = f.d(f.this, paramAnonymousString);
          if ((this.c) && (f.l(f.this) != null) && (f.l(f.this).isShowing()))
            f.l(f.this).dismiss();
          return this.c;
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.f
 * JD-Core Version:    0.6.2
 */