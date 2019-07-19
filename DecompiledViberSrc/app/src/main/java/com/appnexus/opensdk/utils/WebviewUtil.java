package com.appnexus.opensdk.utils;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WebviewUtil
{
  private static String a()
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    if (localCookieManager != null)
    {
      String str1 = localCookieManager.getCookie(Settings.getCookieDomain());
      if (!TextUtils.isEmpty(str1))
        for (String str2 : str1.split("; "))
          if ((str2 != null) && (str2.contains("uuid2")))
            return str2;
    }
    return null;
  }

  public static void cookieSync(Map<String, List<String>> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty()));
    while (true)
    {
      return;
      CookieManager localCookieManager = CookieManager.getInstance();
      if (localCookieManager != null)
        try
        {
          String str1 = a();
          Iterator localIterator1 = paramMap.entrySet().iterator();
          while (localIterator1.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator1.next();
            String str2 = (String)localEntry.getKey();
            if ((str2 != null) && ((str2.equalsIgnoreCase("Set-cookie")) || (str2.equalsIgnoreCase("Set-cookie2"))))
            {
              Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
              while (localIterator2.hasNext())
              {
                String str3 = (String)localIterator2.next();
                if ((!TextUtils.isEmpty(str3)) && (str3.contains("uuid2")) && ((str1 == null) || (!str3.contains(str1))))
                {
                  localCookieManager.setCookie(Settings.getCookieDomain(), str3);
                  if (Build.VERSION.SDK_INT < 21)
                  {
                    CookieSyncManager localCookieSyncManager = CookieSyncManager.getInstance();
                    if (localCookieSyncManager == null)
                    {
                      Clog.i(Clog.httpRespLogTag, "Unable to find a CookieSyncManager");
                      return;
                    }
                    localCookieSyncManager.sync();
                  }
                  else
                  {
                    localCookieManager.flush();
                  }
                }
              }
            }
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
        }
        catch (Exception localException)
        {
        }
    }
  }

  public static String getCookie()
  {
    try
    {
      CookieManager localCookieManager = CookieManager.getInstance();
      if (localCookieManager == null)
      {
        Clog.i(Clog.httpRespLogTag, "Unable to find a CookieManager");
        return null;
      }
      String str = localCookieManager.getCookie(Settings.getBaseUrl());
      return str;
    }
    catch (Exception localException)
    {
      Clog.e(Clog.httpRespLogTag, "Unable to find a CookieManager - Exception: " + localException.getMessage());
    }
    return null;
  }

  public static void onPause(WebView paramWebView)
  {
    if (paramWebView == null)
      return;
    try
    {
      WebView.class.getDeclaredMethod("onPause", new Class[0]).invoke(paramWebView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void onResume(WebView paramWebView)
  {
    if (paramWebView == null)
      return;
    try
    {
      WebView.class.getDeclaredMethod("onResume", new Class[0]).invoke(paramWebView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  public static void setWebViewSettings(WebView paramWebView)
  {
    if (paramWebView == null);
    while (true)
    {
      return;
      try
      {
        paramWebView.getSettings().setBuiltInZoomControls(false);
        paramWebView.getSettings().setSupportZoom(true);
        paramWebView.getSettings().setUseWideViewPort(true);
        paramWebView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 21)
          paramWebView.getSettings().setMixedContentMode(0);
        paramWebView.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 17)
          paramWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        paramWebView.getSettings().setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 11)
          paramWebView.getSettings().setAllowContentAccess(false);
        if (Build.VERSION.SDK_INT >= 16)
        {
          paramWebView.getSettings().setAllowFileAccessFromFileURLs(false);
          paramWebView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          CookieManager localCookieManager = CookieManager.getInstance();
          if (localCookieManager != null)
          {
            localCookieManager.setAcceptThirdPartyCookies(paramWebView, true);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Clog.e(Clog.httpRespLogTag, "Unable update webview settings - Exception: " + localException.getMessage());
        return;
      }
    }
    Clog.d(Clog.baseLogTag, "Failed to set Webview to accept 3rd party cookie");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.WebviewUtil
 * JD-Core Version:    0.6.2
 */