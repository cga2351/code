package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.in;
import com.yandex.mobile.ads.impl.ip;
import com.yandex.mobile.ads.impl.jh;
import com.yandex.mobile.ads.impl.le;
import com.yandex.mobile.ads.impl.ll;
import java.util.Iterator;
import java.util.List;

public final class ak
  implements bb
{
  private final ll a;
  private af b;

  ak(ll paramll)
  {
    this.a = paramll;
  }

  public final void a()
  {
    if (this.b != null)
    {
      Iterator localIterator = this.a.c().iterator();
      while (localIterator.hasNext())
      {
        le localle = (le)localIterator.next();
        in localin = this.b.a(localle);
        if ((localin instanceof ip))
          ((ip)localin).c(localle.c());
      }
    }
  }

  public final void a(af paramaf)
  {
    paramaf.a();
  }

  public final void a(af paramaf, e parame)
  {
    this.b = paramaf;
    jh localjh = new jh(paramaf, parame, this.a.a());
    Iterator localIterator = this.a.c().iterator();
    while (localIterator.hasNext())
    {
      le localle = (le)localIterator.next();
      in localin = paramaf.a(localle);
      if (localin != null)
      {
        localin.a(localle.c());
        localin.a(localle, localjh);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.ak
 * JD-Core Version:    0.6.2
 */