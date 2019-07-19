package com.viber.voip.messages.ui.media.player.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.d.a.c;
import com.viber.common.a.e;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.bj;
import com.viber.voip.util.da;
import com.viber.voip.util.dd;
import com.viber.voip.util.dj;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

public final class f extends a<WebView>
{
  private static final e z = ViberEnv.getLogger();
  private View.OnTouchListener A;
  private a B;
  private b C;
  private WebViewClient D;
  private WebChromeClient E;
  private String F;

  public f(Context paramContext)
  {
    super(paramContext);
  }

  private void a(String paramString)
  {
    this.c = null;
    this.d = false;
    ((WebView)this.h).loadDataWithBaseURL(paramString, getJsPlayerContent(), "text/html", "utf-8", null);
  }

  private View.OnTouchListener getConsumeAllTouchesListener()
  {
    if (this.A == null)
      this.A = new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      };
    return this.A;
  }

  private String getJsPlayerContent()
  {
    if (da.a(this.F));
    try
    {
      this.F = bj.a(getContext().getAssets().open("embedded_media/media_player.html"));
      label29: if (this.F != null)
        return this.F;
      return "";
    }
    catch (IOException localIOException)
    {
      break label29;
    }
  }

  private WebChromeClient getWebChromeClient()
  {
    if (this.E == null)
      this.E = new WebChromeClient()
      {
        public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
        {
          return true;
        }
      };
    return this.E;
  }

  private WebViewClient getWebViewClient()
  {
    if (this.D == null)
      this.D = new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
          if (f.this.s())
            return;
          f.this.d = true;
          f.this.a(false);
        }
      };
    return this.D;
  }

  private void t()
  {
    this.B = new a();
    this.C = new b();
  }

  protected int a(int paramInt)
  {
    if ((com.viber.common.d.a.e()) && ((1 == paramInt) || (2 == paramInt)))
      return 0;
    return R.layout.media_url_web_player_preview_state;
  }

  protected void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
    WebView localWebView = (WebView)this.h;
    if (paramBoolean);
    for (View.OnTouchListener localOnTouchListener = null; ; localOnTouchListener = getConsumeAllTouchesListener())
    {
      localWebView.setOnTouchListener(localOnTouchListener);
      return;
    }
  }

  protected void b(long paramLong)
  {
    super.b(paramLong);
    this.C.a(paramLong);
  }

  protected WebView d(Context paramContext)
  {
    WebView localWebView = new WebView(paramContext);
    dj.h(localWebView);
    return localWebView;
  }

  protected void e()
  {
    ((WebView)this.h).removeJavascriptInterface("embeddedMediaBridge");
    super.e();
  }

  protected void f()
  {
    ((WebView)this.h).stopLoading();
    ((WebView)this.h).loadUrl("about:blank");
    ((WebView)this.h).destroy();
    super.f();
  }

  protected void g()
  {
    super.g();
    this.C.a();
  }

  protected int getErrorPreviewStateMessage()
  {
    return R.string.dialog_307d_message_video;
  }

  public int getPlayerType()
  {
    return 1;
  }

  protected void h()
  {
    super.h();
    this.C.b();
  }

  protected void i()
  {
    super.i();
    this.C.a(this.c);
  }

  @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
  protected void l()
  {
    super.l();
    WebSettings localWebSettings = ((WebView)this.h).getSettings();
    ((WebView)this.h).setVerticalScrollBarEnabled(false);
    ((WebView)this.h).setHorizontalScrollBarEnabled(false);
    localWebSettings.setSupportZoom(false);
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setDisplayZoomControls(false);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setUseWideViewPort(true);
    if (com.viber.common.d.a.b())
      localWebSettings.setMediaPlaybackRequiresUserGesture(false);
    if (com.viber.common.d.a.g())
    {
      localWebSettings.setMixedContentMode(0);
      CookieManager.getInstance().setAcceptThirdPartyCookies((WebView)this.h, true);
    }
    ((WebView)this.h).setWebChromeClient(getWebChromeClient());
    ((WebView)this.h).setWebViewClient(getWebViewClient());
    ((WebView)this.h).setOnTouchListener(getConsumeAllTouchesListener());
    t();
  }

  @SuppressLint({"AddJavascriptInterface"})
  protected void o()
  {
    super.o();
    ((WebView)this.h).addJavascriptInterface(this.B, "embeddedMediaBridge");
    a(null);
  }

  class a
  {
    a()
    {
    }

    @JavascriptInterface
    public void onBaseUrl(final String paramString)
    {
      f.this.a(new b.a(paramString)
      {
        protected void a()
        {
          f.a(f.this, paramString);
        }
      });
    }

    @JavascriptInterface
    public void onError(String paramString)
    {
      f.d locald = (f.d)new com.google.d.f().a(paramString, f.d.class);
      f.this.c(locald.a());
    }

    @JavascriptInterface
    public void onFinish()
    {
      f.this.k();
    }

    @JavascriptInterface
    public void onPause()
    {
      f.this.j();
    }

    @JavascriptInterface
    public void onPlay(String paramString)
    {
      f.this.b(Boolean.valueOf(paramString).booleanValue());
    }

    @JavascriptInterface
    public void onProgressChanged(final String paramString)
    {
      f.this.a(new b.a(paramString)
      {
        public void a()
        {
          long l = Float.valueOf(paramString).longValue();
          f.this.a(f.this.o, TimeUnit.SECONDS.toMillis(l));
        }
      });
    }

    @JavascriptInterface
    public void onReady(String paramString)
    {
      f.c localc = (f.c)new com.google.d.f().a(paramString, f.c.class);
      f localf = f.this;
      long l = localc.b();
      if (!localc.a());
      for (boolean bool = true; ; bool = false)
      {
        localf.b(l, bool);
        return;
      }
    }
  }

  class b
  {
    b()
    {
    }

    private String a(String paramString1, String paramString2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("embeddedMedia").append('.').append(paramString1);
      localStringBuilder.append("('");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("')");
      return localStringBuilder.toString();
    }

    private String a(String paramString, Object[] paramArrayOfObject)
    {
      JSONArray localJSONArray = new JSONArray(Arrays.asList(paramArrayOfObject));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("embeddedMedia").append('.').append(paramString);
      localStringBuilder.append('(');
      if (localJSONArray.length() > 0)
      {
        String str = localJSONArray.toString();
        localStringBuilder.append(str.substring(1, -1 + str.length()));
      }
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }

    private void b(final String paramString)
    {
      if (dd.a())
      {
        c(paramString);
        return;
      }
      f.this.a(new b.a(paramString)
      {
        public void a()
        {
          f.b.a(f.b.this, paramString);
        }
      });
    }

    @TargetApi(19)
    private void c(String paramString)
    {
      if (f.this.s())
        return;
      if (com.viber.common.d.a.d())
      {
        ((WebView)f.this.h).evaluateJavascript(paramString, null);
        return;
      }
      ((WebView)f.this.h).loadUrl("javascript:" + paramString);
    }

    void a()
    {
      b(a("play", new Object[0]));
    }

    void a(long paramLong)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(paramLong));
      b(a("seekTo", arrayOfObject));
    }

    void a(String paramString)
    {
      b(a("init", new com.google.d.f().b(new f.e(paramString, "android"))));
    }

    void b()
    {
      b(a("pause", new Object[0]));
    }
  }

  static final class c
  {

    @c(a="showCustomControls")
    private Boolean a;

    @c(a="duration")
    private Float b;

    boolean a()
    {
      if (this.a != null)
        return this.a.booleanValue();
      return true;
    }

    long b()
    {
      if (this.b != null)
        return TimeUnit.SECONDS.toMillis(this.b.longValue());
      return 0L;
    }
  }

  static final class d
  {

    @c(a="code")
    private Integer a;

    int a()
    {
      if (this.a == null)
        return 0;
      switch (this.a.intValue())
      {
      default:
        return 0;
      case 5:
      }
      return 1;
    }
  }

  static final class e
  {

    @c(a="url")
    private final String a;

    @c(a="platform")
    private final String b;

    e(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.c.f
 * JD-Core Version:    0.6.2
 */