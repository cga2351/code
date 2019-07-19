package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class cj
{
  private static final ExecutorService a = Executors.newCachedThreadPool(new dc("YandexMobileAds.UrlTracker"));
  private final Context b;

  public cj(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }

  private static void a(String paramString, cs paramcs)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      a locala = new a(paramString, paramcs);
      a.execute(locala);
    }
  }

  public final void a(String paramString)
  {
    a(paramString, new cq(this.b));
  }

  public final void a(String paramString, v paramv, cp paramcp)
  {
    a(paramString, paramv, paramcp, new ca(this.b, paramv, null));
  }

  public final void a(String paramString, v paramv, cp paramcp, bz parambz)
  {
    a(paramString, new cr(this.b, paramv, parambz, paramcp));
  }

  private static final class a
    implements Runnable
  {
    private final String a;
    private final cs b;

    a(String paramString, cs paramcs)
    {
      this.a = paramString;
      this.b = paramcs;
    }

    public final void run()
    {
      String str = df.e(this.a);
      if (!TextUtils.isEmpty(str))
        this.b.a(str);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cj
 * JD-Core Version:    0.6.2
 */