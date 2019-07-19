package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.nativeads.af;
import com.yandex.mobile.ads.nativeads.q;
import java.util.Iterator;
import java.util.List;

public final class kz
{
  private final ky a;

  public kz(bz parambz, kv paramkv, af paramaf, q paramq)
  {
    this.a = new ky(parambz, paramkv, paramaf, paramq);
  }

  public final void a(Context paramContext, List<lo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        lo locallo = (lo)localIterator.next();
        kx localkx = this.a.a(paramContext, locallo);
        if (localkx != null)
          localkx.a(paramContext, locallo);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.kz
 * JD-Core Version:    0.6.2
 */