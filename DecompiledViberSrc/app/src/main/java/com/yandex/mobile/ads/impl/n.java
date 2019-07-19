package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.os.SystemClock;
import com.yandex.mobile.ads.AdActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class n
{
  public static void a(Context paramContext, bz parambz, String paramString, ResultReceiver paramResultReceiver, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("click_type", "default");
    parambz.a(fd.b.t, localHashMap);
    if (paramResultReceiver != null)
      paramResultReceiver.send(9, null);
    if ((paramContext != null) && (a.a()))
    {
      if ((!paramBoolean) || (!df.d(paramString)))
        break label72;
      a(paramContext, paramString, paramResultReceiver);
    }
    label72: 
    do
    {
      return;
      if (!df.a(paramContext, paramString, true))
        break;
    }
    while (paramResultReceiver == null);
    paramResultReceiver.send(7, null);
    return;
    a(paramContext, paramString, paramResultReceiver);
  }

  private static void a(Context paramContext, String paramString, ResultReceiver paramResultReceiver)
  {
    Intent localIntent;
    if (paramContext != null)
      localIntent = b(paramContext, paramString, paramResultReceiver);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder("Failed to show Browser. Exception: ").append(localException);
    }
  }

  private static Intent b(Context paramContext, String paramString, ResultReceiver paramResultReceiver)
  {
    Intent localIntent = new Intent(paramContext, AdActivity.class);
    localIntent.putExtra("window_type", "window_type_browser");
    localIntent.putExtra("extra_receiver", cw.a(paramResultReceiver));
    localIntent.putExtra("extra_browser_url", paramString);
    localIntent.addFlags(268435456);
    return localIntent;
  }

  static final class a
  {
    static final AtomicLong a = new AtomicLong(SystemClock.elapsedRealtime() - 2000L);

    static boolean a()
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = l1 - a.getAndSet(l1);
      return (l2 < 0L) || (l2 > 1000L);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.n
 * JD-Core Version:    0.6.2
 */