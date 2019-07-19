package com.yandex.mobile.ads.impl;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class nl
{
  private final int a;

  public nl(Context paramContext)
  {
    this.a = a(paramContext);
  }

  private static int a(Context paramContext)
  {
    int i = Math.round(paramContext.getResources().getDimension(17104896));
    try
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        int j = ((ActivityManager)paramContext.getSystemService("activity")).getLauncherLargeIconSize();
        return j;
      }
    }
    catch (Exception localException)
    {
    }
    return i;
  }

  private List<lh> a(li paramli, List<lh> paramList)
  {
    if (paramli != null)
    {
      List localList = paramli.a();
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          lo locallo = (lo)localIterator.next();
          if ((locallo instanceof lr))
            paramList.add(a(((lr)locallo).b()));
        }
      }
    }
    return paramList;
  }

  final lh a(String paramString)
  {
    lh locallh = new lh();
    locallh.a(paramString);
    locallh.b(this.a);
    locallh.a(this.a);
    return locallh;
  }

  public final List<lh> a(ll paramll)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramll.a(), localArrayList);
    List localList = paramll.c();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        a(((le)localIterator.next()).d(), localArrayList);
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.nl
 * JD-Core Version:    0.6.2
 */