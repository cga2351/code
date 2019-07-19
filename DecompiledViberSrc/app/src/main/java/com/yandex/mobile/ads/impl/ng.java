package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.List;

final class ng
{
  private final nr a;
  private final nf b;

  ng(Context paramContext)
  {
    this.a = new nr(paramContext);
    this.b = new nf();
  }

  final Intent a(List<lt> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Intent localIntent = nf.a((lt)localIterator.next());
      if (this.a.a(localIntent))
        return localIntent;
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ng
 * JD-Core Version:    0.6.2
 */