package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebSettings;
import java.io.File;

public class hd extends fz
{
  private final du a = new du(this);

  public hd(Context paramContext, v paramv)
  {
    super(paramContext, paramv);
  }

  protected void a()
  {
    this.a.a(j());
  }

  @SuppressLint({"AddJavascriptInterface"})
  protected final void a(Context paramContext)
  {
    addJavascriptInterface(new fz.a(this, paramContext), "AdPerformActionsJSI");
  }

  protected final void a_(Context paramContext)
  {
    super.a_(paramContext);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setAppCachePath(new File(getContext().getCacheDir(), "com.yandex.mobile.ads.cache").getAbsolutePath());
    localWebSettings.setDatabasePath(getContext().getDatabasePath("com.yandex.mobile.ads.db").getAbsolutePath());
    localWebSettings.setAppCacheMaxSize(8388608L);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setCacheMode(-1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.hd
 * JD-Core Version:    0.6.2
 */