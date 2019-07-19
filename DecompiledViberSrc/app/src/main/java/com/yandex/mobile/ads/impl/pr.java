package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.rewarded.a;

public final class pr
{
  private final a a;

  public pr(a parama)
  {
    this.a = parama;
  }

  public final pq a(Context paramContext, v<String> paramv)
  {
    bf localbf;
    ps localps;
    if (paramv != null)
    {
      localbf = paramv.p();
      localps = null;
      if (localbf != null)
      {
        if (!localbf.c())
          break label57;
        bg localbg = localbf.b();
        localps = null;
        if (localbg != null)
          localps = new ps(paramContext, localbg);
      }
    }
    label57: be localbe;
    do
    {
      return localps;
      localbf = null;
      break;
      localbe = localbf.a();
      localps = null;
    }
    while (localbe == null);
    return new pp(localbe, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.pr
 * JD-Core Version:    0.6.2
 */