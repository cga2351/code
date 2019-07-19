package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class z extends WebView
{
  Map<String, Object> c;
  public Integer d = null;

  protected z(Context paramContext)
  {
    super(paramContext);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setAllowFileAccess(false);
    if (fl.a(11))
    {
      localWebSettings.setAllowContentAccess(false);
      if (fl.a(16))
      {
        localWebSettings.setAllowFileAccessFromFileURLs(false);
        localWebSettings.setAllowUniversalAccessFromFileURLs(false);
      }
    }
  }

  public final Object a(String paramString)
  {
    if (this.c != null)
      return this.c.get(paramString);
    return null;
  }

  protected void a_(Context paramContext)
  {
  }

  @SuppressLint({"AddJavascriptInterface"})
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    super.addJavascriptInterface(paramObject, paramString);
    if (this.c == null)
      this.c = new HashMap();
    this.c.put(paramString, paramObject);
  }

  protected String b()
  {
    return "";
  }

  public final void b(String paramString)
  {
    loadDataWithBaseURL("https://yandex.ru", paramString + b() + "<body style='margin:0; padding:0;'>", "text/html", "UTF-8", null);
  }

  @TargetApi(11)
  final void b_()
  {
    if (fl.a(11))
      getSettings().setDisplayZoomControls(false);
  }

  public final void e()
  {
    cw.a(this);
    new Object[1][0] = getClass().toString();
  }

  public final void f()
  {
    cw.b(this);
    new Object[1][0] = getClass().toString();
  }

  public void g()
  {
    dh.a(this);
    if (this.c != null)
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
        removeJavascriptInterface((String)localIterator.next());
      this.c.clear();
    }
    destroy();
    new Object[1][0] = getClass().toString();
  }

  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    if (fl.a(11))
      super.removeJavascriptInterface(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.z
 * JD-Core Version:    0.6.2
 */