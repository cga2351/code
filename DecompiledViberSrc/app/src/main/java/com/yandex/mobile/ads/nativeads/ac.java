package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.in;
import com.yandex.mobile.ads.impl.jg;
import com.yandex.mobile.ads.impl.le;
import java.util.Iterator;
import java.util.List;

final class ac
  implements bb
{
  private final List<le> a;

  ac(List<le> paramList)
  {
    this.a = paramList;
  }

  public final void a()
  {
  }

  public final void a(af paramaf)
  {
  }

  public final void a(af paramaf, e parame)
  {
    if (this.a != null)
    {
      jg localjg = new jg(paramaf, parame);
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        le localle = (le)localIterator.next();
        in localin = paramaf.a(localle);
        if (localin != null)
        {
          localin.a(localle.c());
          localin.a(localle, localjg);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.ac
 * JD-Core Version:    0.6.2
 */