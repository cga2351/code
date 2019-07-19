package com.my.target;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private final String a;
  private final WebViewClient b = new c(null);
  private b c;
  private aw d;
  private boolean e;
  private boolean f;

  private a(String paramString)
  {
    this.a = paramString;
  }

  public static a a(String paramString)
  {
    return new a(paramString);
  }

  private String a(Rect paramRect)
  {
    return paramRect.left + "," + paramRect.top + "," + paramRect.width() + "," + paramRect.height();
  }

  private String b(Rect paramRect)
  {
    return paramRect.width() + "," + paramRect.height();
  }

  private void d()
  {
    if (this.e);
    do
    {
      return;
      this.e = true;
    }
    while (this.c == null);
    this.c.a(this);
  }

  private void e(String paramString)
  {
    f("mraidbridge.nativeComplete(" + JSONObject.quote(paramString) + ")");
  }

  private void f(String paramString)
  {
    if (this.d == null)
    {
      dp.a("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + paramString);
      return;
    }
    String str = "javascript:window." + paramString + ";";
    dp.a("Injecting Javascript into MRAID WebView " + hashCode() + ": " + str);
    this.d.loadUrl(str);
  }

  public void a()
  {
    this.d = null;
  }

  void a(Uri paramUri)
  {
    String str1 = paramUri.getScheme();
    String str2 = paramUri.getHost();
    if ("mytarget".equals(str1))
    {
      if ("onloadmraidjs".equals(str2))
        dp.a("MraidBridge: JS call onLoad");
      dp.a("MraidBridge: got mytarget scheme " + paramUri);
      return;
    }
    String str3;
    b localb;
    int i;
    int j;
    if ("mraid".equals(str1))
    {
      if (str2.contains(","))
        str2 = str2.substring(0, str2.indexOf(",")).trim();
      dp.a("Got mraid command " + paramUri);
      str3 = paramUri.toString();
      localb = new b(str2, this.a);
      e(localb.toString());
      i = str3.indexOf("{");
      j = 1 + str3.lastIndexOf("}");
      if ((i < 0) || (j <= 0) || (i >= j))
        break label312;
    }
    while (true)
    {
      while (true)
      {
        try
        {
          if (j > str3.length())
            break label312;
          localJSONObject = new JSONObject(str3.substring(i, j));
          a(localb, localJSONObject);
          return;
        }
        catch (JSONException localJSONException)
        {
          a(localb.toString(), localJSONException.getMessage());
          return;
        }
        try
        {
          new URI(paramUri.toString());
          if ((this.d == null) || (!this.d.a()) || (this.c == null))
            break;
          this.c.a(paramUri);
          return;
        }
        catch (URISyntaxException localURISyntaxException)
        {
          dp.a("Invalid MRAID URL: " + paramUri);
          a("", "Mraid command sent an invalid URL");
          return;
        }
      }
      label312: JSONObject localJSONObject = null;
    }
  }

  public void a(b paramb)
  {
    this.c = paramb;
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  public void a(aw paramaw)
  {
    this.d = paramaw;
    this.d.getSettings().setJavaScriptEnabled(true);
    if ((Build.VERSION.SDK_INT >= 17) && ("interstitial".equals(this.a)))
      paramaw.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.d.setScrollContainer(false);
    this.d.setVerticalScrollBarEnabled(false);
    this.d.setHorizontalScrollBarEnabled(false);
    this.d.setWebViewClient(this.b);
    this.d.setWebChromeClient(new d(null));
    this.d.setVisibilityChangedListener(new e(null));
  }

  public void a(d paramd)
  {
    f("mraidbridge.setScreenSize(" + b(paramd.d()) + ");window.mraidbridge.setMaxSize(" + b(paramd.c()) + ");window.mraidbridge.setCurrentPosition(" + a(paramd.a()) + ");window.mraidbridge.setDefaultPosition(" + a(paramd.b()) + ")");
    f("mraidbridge.fireSizeChangeEvent(" + b(paramd.a()) + ")");
  }

  public void a(String paramString1, String paramString2)
  {
    f("mraidbridge.fireErrorEvent(" + JSONObject.quote(paramString2) + ", " + JSONObject.quote(paramString1) + ")");
  }

  public void a(ArrayList<String> paramArrayList)
  {
    f("mraidbridge.setSupports(" + TextUtils.join(",", paramArrayList) + ")");
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean != this.f)
      f("mraidbridge.setIsViewable(" + paramBoolean + ")");
    this.f = paramBoolean;
  }

  boolean a(b paramb, JSONObject paramJSONObject)
    throws JSONException
  {
    String str1 = paramb.toString();
    if ((paramb.a) && (this.d != null) && (!this.d.a()))
    {
      a(str1, "Cannot execute this command unless the user clicks");
      return false;
    }
    if (this.c == null)
    {
      a(str1, "Invalid state to execute this command");
      return false;
    }
    if (this.d == null)
    {
      a(str1, "The current WebView is being destroyed");
      return false;
    }
    int i = -1;
    switch (str1.hashCode())
    {
    default:
      switch (i)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      }
      break;
    case 94756344:
    case 624734601:
    case -934437708:
    case -1289167206:
    case 1614272768:
    case 1362316271:
    case 3417674:
    case 133423073:
    case -1910759310:
    case 892543864:
    case 1797992422:
    case -1886160473:
    case 459238621:
    case -733616544:
    case 0:
    }
    while (true)
    {
      return true;
      if (!str1.equals("close"))
        break;
      i = 0;
      break;
      if (!str1.equals("setResizeProperties"))
        break;
      i = 1;
      break;
      if (!str1.equals("resize"))
        break;
      i = 2;
      break;
      if (!str1.equals("expand"))
        break;
      i = 3;
      break;
      if (!str1.equals("useCustomClose"))
        break;
      i = 4;
      break;
      if (!str1.equals("setExpandProperties"))
        break;
      i = 5;
      break;
      if (!str1.equals("open"))
        break;
      i = 6;
      break;
      if (!str1.equals("setOrientationProperties"))
        break;
      i = 7;
      break;
      if (!str1.equals("vpaidInit"))
        break;
      i = 8;
      break;
      if (!str1.equals("vpaidEvent"))
        break;
      i = 9;
      break;
      if (!str1.equals("playheadEvent"))
        break;
      i = 10;
      break;
      if (!str1.equals("playVideo"))
        break;
      i = 11;
      break;
      if (!str1.equals("storePicture"))
        break;
      i = 12;
      break;
      if (!str1.equals("createCalendarEvent"))
        break;
      i = 13;
      break;
      if (!str1.equals(""))
        break;
      i = 14;
      break;
      this.c.a();
      continue;
      if (paramJSONObject == null)
      {
        a(str1, "setResizeProperties params cannot be null");
        return false;
      }
      int j = paramJSONObject.getInt("width");
      int k = paramJSONObject.getInt("height");
      int m = paramJSONObject.getInt("offsetX");
      int n = paramJSONObject.getInt("offsetY");
      boolean bool3 = paramJSONObject.optBoolean("allowOffscreen", false);
      int i1 = a.a(paramJSONObject.optString("customClosePosition"));
      return this.c.a(j, k, m, n, bool3, i1);
      return this.c.d();
      Uri localUri2 = null;
      if (paramJSONObject != null)
        localUri2 = Uri.parse(paramJSONObject.getString("url"));
      return this.c.b(localUri2);
      if (paramJSONObject == null)
      {
        a(str1, "useCustomClose params cannot be null");
        return false;
      }
      boolean bool2 = paramJSONObject.getBoolean("useCustomClose");
      this.c.b(bool2);
      continue;
      if (paramJSONObject == null)
      {
        a(str1, "open params cannot be null");
        return false;
      }
      Uri localUri1 = Uri.parse(paramJSONObject.getString("url"));
      this.c.a(localUri1);
      continue;
      if (paramJSONObject == null)
      {
        a(str1, "setOrientationProperties params cannot be null");
        return false;
      }
      boolean bool1 = paramJSONObject.getBoolean("allowOrientationChange");
      String str3 = paramJSONObject.getString("forceOrientation");
      c localc = c.a(str3);
      if (localc == null)
      {
        a(str1, "wrong orientation " + str3);
        return false;
      }
      return this.c.a(bool1, localc);
      this.c.n_();
    }
    if (paramJSONObject == null)
    {
      a(str1, "vpaidEvent params cannot be null");
      return false;
    }
    String str2 = paramJSONObject.getString("event");
    return this.c.a(str2);
    if (paramJSONObject == null)
    {
      a(str1, "playheadEvent params cannot be null");
      return false;
    }
    float f1 = (float)paramJSONObject.getDouble("remain");
    float f2 = (float)paramJSONObject.getDouble("duration");
    return this.c.a(f1, f2);
    dp.a("playVideo is currently unsupported");
    return false;
    dp.a("storePicture is currently unsupported");
    return false;
    dp.a("createCalendarEvent is currently unsupported");
    return false;
    a(str1, "Unspecified MRAID Javascript command");
    return false;
  }

  public void b()
  {
    f("mraidbridge.fireReadyEvent()");
  }

  public void b(String paramString)
  {
    if (this.d == null)
    {
      dp.a("MRAID bridge called setContentHtml before WebView was attached");
      return;
    }
    this.e = false;
    this.d.loadDataWithBaseURL("https://ad.mail.ru/", paramString, "text/html", "UTF-8", null);
  }

  public void c(String paramString)
  {
    f("mraidbridge.setPlacementType(" + JSONObject.quote(paramString) + ")");
  }

  public boolean c()
  {
    return (this.d != null) && (this.d.b());
  }

  public void d(String paramString)
  {
    f("mraidbridge.setState(" + JSONObject.quote(paramString) + ")");
  }

  @SuppressLint({"RtlHardcoded"})
  public static class a
  {
    public static int a(String paramString)
    {
      if (paramString == null)
        return 53;
      int i = -1;
      switch (paramString.hashCode())
      {
      default:
      case -1012429441:
      case -1314880604:
      case -1364013995:
      case -655373719:
      case 1163912186:
      case 1755462605:
      case 1288627767:
      }
      while (true)
        switch (i)
        {
        case 1:
        default:
          return 53;
        case 0:
          return 51;
          if (paramString.equals("top-left"))
          {
            i = 0;
            continue;
            if (paramString.equals("top-right"))
            {
              i = 1;
              continue;
              if (paramString.equals("center"))
              {
                i = 2;
                continue;
                if (paramString.equals("bottom-left"))
                {
                  i = 3;
                  continue;
                  if (paramString.equals("bottom-right"))
                  {
                    i = 4;
                    continue;
                    if (paramString.equals("top-center"))
                    {
                      i = 5;
                      continue;
                      if (paramString.equals("bottom-center"))
                        i = 6;
                    }
                  }
                }
              }
            }
          }
          break;
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        }
      return 17;
      return 83;
      return 85;
      return 49;
      return 81;
    }
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void a(Uri paramUri);

    public abstract void a(a parama);

    public abstract void a(boolean paramBoolean);

    public abstract boolean a(float paramFloat1, float paramFloat2);

    public abstract boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5);

    public abstract boolean a(ConsoleMessage paramConsoleMessage, a parama);

    public abstract boolean a(String paramString);

    public abstract boolean a(String paramString, JsResult paramJsResult);

    public abstract boolean a(boolean paramBoolean, c paramc);

    public abstract void b();

    public abstract void b(boolean paramBoolean);

    public abstract boolean b(Uri paramUri);

    public abstract boolean d();

    public abstract void n_();
  }

  private class c extends WebViewClient
  {
    private c()
    {
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      a.a(a.this);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      dp.a("Error: " + paramString1);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      a.this.a(paramWebResourceRequest.getUrl());
      return true;
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      Uri localUri = Uri.parse(paramString);
      a.this.a(localUri);
      return true;
    }
  }

  private class d extends WebChromeClient
  {
    private d()
    {
    }

    public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      if (a.b(a.this) != null)
        return a.b(a.this).a(paramConsoleMessage, a.this);
      return super.onConsoleMessage(paramConsoleMessage);
    }

    public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      if (a.b(a.this) != null)
        return a.b(a.this).a(paramString2, paramJsResult);
      return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
    }
  }

  private class e
    implements aw.a
  {
    private e()
    {
    }

    public void a()
    {
      if (a.b(a.this) != null)
        a.b(a.this).b();
    }

    public void a(boolean paramBoolean)
    {
      if (a.b(a.this) != null)
        a.b(a.this).a(paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.a
 * JD-Core Version:    0.6.2
 */