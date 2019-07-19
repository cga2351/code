package com.iab.omid.library.appnexus.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.appnexus.adsession.ErrorType;
import com.iab.omid.library.appnexus.d.c;
import org.json.JSONObject;

public class d
{
  private static d a = new d();

  public static d a()
  {
    return a;
  }

  public void a(WebView paramWebView)
  {
    a(paramWebView, "finishSession", new Object[0]);
  }

  public void a(WebView paramWebView, float paramFloat)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Float.valueOf(paramFloat);
    a(paramWebView, "setDeviceVolume", arrayOfObject);
  }

  public void a(WebView paramWebView, ErrorType paramErrorType, String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramErrorType.toString();
    arrayOfObject[1] = paramString;
    a(paramWebView, "error", arrayOfObject);
  }

  public void a(WebView paramWebView, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      a(paramWebView, "publishVideoEvent", new Object[] { paramString, paramJSONObject });
      return;
    }
    a(paramWebView, "publishVideoEvent", new Object[] { paramString });
  }

  public void a(WebView paramWebView, String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    a(paramWebView, "startSession", new Object[] { paramString, paramJSONObject1, paramJSONObject2 });
  }

  void a(WebView paramWebView, String paramString, Object[] paramArrayOfObject)
  {
    if (paramWebView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      a(localStringBuilder, paramArrayOfObject);
      localStringBuilder.append(")}");
      a(paramWebView, localStringBuilder);
      return;
    }
    c.a("The WebView is null for " + paramString);
  }

  void a(final WebView paramWebView, StringBuilder paramStringBuilder)
  {
    final String str = paramStringBuilder.toString();
    Handler localHandler = paramWebView.getHandler();
    if ((localHandler == null) || (Looper.myLooper() == localHandler.getLooper()))
    {
      paramWebView.loadUrl(str);
      return;
    }
    localHandler.post(new Runnable()
    {
      public void run()
      {
        paramWebView.loadUrl(str);
      }
    });
  }

  public void a(WebView paramWebView, JSONObject paramJSONObject)
  {
    a(paramWebView, "init", new Object[] { paramJSONObject });
  }

  void a(StringBuilder paramStringBuilder, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      int i = paramArrayOfObject.length;
      int j = 0;
      if (j < i)
      {
        Object localObject = paramArrayOfObject[j];
        if (localObject == null)
          paramStringBuilder.append('"').append('"');
        while (true)
        {
          paramStringBuilder.append(",");
          j++;
          break;
          if ((localObject instanceof String))
          {
            String str = localObject.toString();
            if (str.startsWith("{"))
              paramStringBuilder.append(str);
            else
              paramStringBuilder.append('"').append(str).append('"');
          }
          else
          {
            paramStringBuilder.append(localObject);
          }
        }
      }
      paramStringBuilder.setLength(-1 + paramStringBuilder.length());
    }
  }

  public boolean a(WebView paramWebView, String paramString)
  {
    if ((paramWebView != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramWebView.loadUrl("javascript: " + paramString);
      return true;
    }
    return false;
  }

  public void b(WebView paramWebView)
  {
    a(paramWebView, "publishImpressionEvent", new Object[0]);
  }

  public void b(WebView paramWebView, String paramString)
  {
    if (paramString != null)
      a(paramWebView, "var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);".replace("%SCRIPT_SRC%", paramString));
  }

  public void c(WebView paramWebView, String paramString)
  {
    a(paramWebView, "setNativeViewHierarchy", new Object[] { paramString });
  }

  public void d(WebView paramWebView, String paramString)
  {
    a(paramWebView, "setState", new Object[] { paramString });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.b.d
 * JD-Core Version:    0.6.2
 */