package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.view.Window;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  private static final Object a = new Object();
  private static volatile l b;
  private final Map<String, k> c = new HashMap();

  private l()
  {
    a("window_type_browser", new i());
  }

  public static l a()
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new l();
      return b;
    }
  }

  public final j a(Context paramContext, RelativeLayout paramRelativeLayout, ResultReceiver paramResultReceiver, m paramm, Intent paramIntent, Window paramWindow)
  {
    try
    {
      String str = paramIntent.getStringExtra("window_type");
      j localj1;
      if (str != null)
      {
        k localk = (k)this.c.get(str);
        if (localk != null)
          localj1 = localk.a(paramContext, paramRelativeLayout, paramResultReceiver, paramm, paramIntent, paramWindow);
      }
      for (j localj2 = localj1; ; localj2 = null)
        return localj2;
    }
    finally
    {
    }
  }

  public final void a(String paramString, k paramk)
  {
    try
    {
      if (!this.c.containsKey(paramString))
        this.c.put(paramString, paramk);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.l
 * JD-Core Version:    0.6.2
 */