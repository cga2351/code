package com.appnexus.opensdk;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Pair;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.Settings;
import com.appnexus.opensdk.utils.StringUtil;
import com.appnexus.opensdk.utils.WebviewUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class a
{
  private static void a(WebView paramWebView, Uri paramUri)
  {
    String str1 = paramUri.getQueryParameter("cb");
    String str2 = paramUri.getQueryParameter("url");
    Context localContext = paramWebView.getContext();
    boolean bool = false;
    if (localContext != null)
    {
      PackageManager localPackageManager = paramWebView.getContext().getPackageManager();
      bool = false;
      if (localPackageManager != null)
      {
        bool = false;
        if (str2 != null)
          break label106;
      }
    }
    while (true)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(new Pair("caller", "MayDeepLink"));
      localLinkedList.add(new Pair("mayDeepLink", String.valueOf(bool)));
      a(paramWebView, str1, localLinkedList);
      return;
      label106: Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str2)));
      localIntent.setFlags(268435456);
      ComponentName localComponentName = localIntent.resolveActivity(paramWebView.getContext().getPackageManager());
      bool = false;
      if (localComponentName != null)
        bool = true;
    }
  }

  private static void a(WebView paramWebView, String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("cb=");
    if (paramString != null);
    while (true)
    {
      localStringBuilder2.append(paramString);
      if (paramList == null)
        break;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if ((localPair.first != null) && (localPair.second != null))
          localStringBuilder1.append("&").append((String)localPair.first).append("=").append(Uri.encode((String)localPair.second));
      }
      paramString = "-1";
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = localStringBuilder1.toString();
    a(String.format("javascript:window.sdkjs.client.result(\"%s\")", arrayOfObject), paramWebView);
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  private static void a(f paramf, Uri paramUri)
  {
    String str1 = paramUri.getQueryParameter("url");
    if ((paramf.getContext() == null) || (str1 == null) || (!str1.startsWith("http")))
      return;
    String str2 = Uri.decode(str1);
    Class localClass = AdActivity.getActivityClass();
    Intent localIntent = new Intent(paramf.getContext(), localClass);
    localIntent.putExtra("ACTIVITY_TYPE", "BROWSER");
    WebView localWebView = new WebView(paramf.getContext());
    WebviewUtil.setWebViewSettings(localWebView);
    BrowserAdActivity.BROWSER_QUEUE.add(localWebView);
    localWebView.loadUrl(str2);
    if (paramf.a.getBrowserStyle() != null)
    {
      String str3 = "" + localWebView.hashCode();
      localIntent.putExtra("bridgeid", str3);
      AdView.b.d.add(new Pair(str3, paramf.a.getBrowserStyle()));
    }
    try
    {
      paramf.getContext().startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Toast.makeText(paramf.getContext(), R.string.action_cant_be_completed, 0).show();
      Clog.w(Clog.baseLogTag, Clog.getString(R.string.adactivity_missing, localClass.getName()));
      BrowserAdActivity.BROWSER_QUEUE.remove();
    }
  }

  static void a(f paramf, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    String str = localUri.getHost();
    if ("MayDeepLink".equals(str))
    {
      a(paramf, localUri);
      return;
    }
    if ("DeepLink".equals(str))
    {
      if (paramf.d())
      {
        b(paramf, localUri);
        return;
      }
      Clog.w(Clog.jsLogTag, Clog.getString(R.string.no_user_interaction, paramString));
      return;
    }
    if ("ExternalBrowser".equals(str))
    {
      if (paramf.d())
      {
        c(paramf, localUri);
        return;
      }
      Clog.w(Clog.jsLogTag, Clog.getString(R.string.no_user_interaction, paramString));
      return;
    }
    if ("InternalBrowser".equals(str))
    {
      if (paramf.d())
      {
        a(paramf, localUri);
        return;
      }
      Clog.w(Clog.jsLogTag, Clog.getString(R.string.no_user_interaction, paramString));
      return;
    }
    if ("RecordEvent".equals(str))
    {
      b(paramf, localUri);
      return;
    }
    if ("DispatchAppEvent".equals(str))
    {
      c(paramf, localUri);
      return;
    }
    if ("GetDeviceID".equals(str))
    {
      d(paramf, localUri);
      return;
    }
    if ("SetMRAIDRefreshFrequency".equals(str))
    {
      d(paramf, localUri);
      return;
    }
    Clog.w(Clog.baseLogTag, "ANJAM called with unsupported function: " + str);
  }

  private static void a(String paramString, WebView paramWebView)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        paramWebView.evaluateJavascript(paramString, null);
        return;
      }
      paramWebView.loadUrl(paramString);
      return;
    }
    catch (Exception localException)
    {
      Clog.e(Clog.baseLogTag, "ANJAMImplementation.loadResult -- Caught EXCEPTION...", localException);
      Clog.e(Clog.baseLogTag, "ANJAMImplementation.loadResult -- ...Recovering with webView.loadUrl.");
    }
  }

  private static void b(WebView paramWebView, Uri paramUri)
  {
    String str1 = paramUri.getQueryParameter("cb");
    String str2 = paramUri.getQueryParameter("url");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new Pair("caller", "DeepLink"));
    if ((paramWebView.getContext() == null) || (str2 == null))
    {
      a(paramWebView, str1, localLinkedList);
      return;
    }
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str2)));
      localIntent.setFlags(268435456);
      paramWebView.getContext().startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      a(paramWebView, str1, localLinkedList);
    }
  }

  private static void b(f paramf, Uri paramUri)
  {
    String str = paramUri.getQueryParameter("url");
    if ((str == null) || (!str.startsWith("http")))
      return;
    WebView localWebView = new WebView(paramf.getContext());
    localWebView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        Clog.d(Clog.baseLogTag, "RecordEvent completed loading: " + paramAnonymousString);
        CookieSyncManager localCookieSyncManager = CookieSyncManager.getInstance();
        if (localCookieSyncManager != null)
          localCookieSyncManager.sync();
      }
    });
    localWebView.loadUrl(str);
    localWebView.setVisibility(8);
    paramf.addView(localWebView);
  }

  private static void c(WebView paramWebView, Uri paramUri)
  {
    String str = paramUri.getQueryParameter("url");
    if ((paramWebView.getContext() == null) || (str == null) || (!str.startsWith("http")))
      return;
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str)));
      paramWebView.getContext().startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Toast.makeText(paramWebView.getContext(), R.string.action_cant_be_completed, 0).show();
    }
  }

  private static void c(f paramf, Uri paramUri)
  {
    String str1 = paramUri.getQueryParameter("event");
    String str2 = paramUri.getQueryParameter("data");
    paramf.a.getAdDispatcher().a(str1, str2);
  }

  private static void d(WebView paramWebView, Uri paramUri)
  {
    String str1 = paramUri.getQueryParameter("cb");
    String str2;
    if ((!StringUtil.isEmpty(Settings.getSettings().aaid)) && (Settings.getSettings().aaidEnabled))
      str2 = Settings.getSettings().aaid;
    for (String str3 = "aaid"; ; str3 = "sha1udid")
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(new Pair("caller", "GetDeviceID"));
      localLinkedList.add(new Pair("idname", str3));
      localLinkedList.add(new Pair("id", str2));
      a(paramWebView, str1, localLinkedList);
      return;
      str2 = Settings.getSettings().hidsha1;
    }
  }

  private static void d(f paramf, Uri paramUri)
  {
    paramf.a(Integer.parseInt(paramUri.getQueryParameter("ms")));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.a
 * JD-Core Version:    0.6.2
 */