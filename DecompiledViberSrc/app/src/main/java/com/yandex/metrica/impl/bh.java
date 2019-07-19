package com.yandex.metrica.impl;

import android.content.Context;
import android.os.Handler;
import com.yandex.metrica.e;
import com.yandex.metrica.g;
import com.yandex.metrica.impl.ob.mr;
import com.yandex.metrica.impl.ob.of;
import com.yandex.metrica.impl.ob.og;
import com.yandex.metrica.impl.ob.pt;
import com.yandex.metrica.impl.ob.px;
import com.yandex.metrica.impl.ob.pz;
import com.yandex.metrica.impl.ob.u;
import java.util.HashMap;
import java.util.Map;

class bh
{
  private Context a;
  private u b;
  private bj c;
  private Handler d;
  private mr e;
  private Map<String, com.yandex.metrica.c> f = new HashMap();
  private final px<String> g = new pt(new pz(this.f));

  public bh(Context paramContext, u paramu, bj parambj, Handler paramHandler, mr parammr)
  {
    this.a = paramContext;
    this.b = paramu;
    this.c = parambj;
    this.d = paramHandler;
    this.e = parammr;
  }

  private void a(c paramc)
  {
    paramc.a(new aa(this.d, paramc));
    paramc.a(this.e);
  }

  ad a(g paramg, boolean paramBoolean)
  {
    this.g.a(paramg.apiKey);
    ad localad = new ad(this.a, this.b, paramg, this.c);
    a(localad);
    localad.a(paramg, paramBoolean);
    localad.a();
    this.c.a(localad);
    this.f.put(paramg.apiKey, localad);
    return localad;
  }

  void a(e parame)
  {
    try
    {
      if (this.f.containsKey(parame.apiKey))
      {
        of localof = og.a(parame.apiKey);
        if (localof.c())
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = parame.apiKey;
          localof.b("Reporter with apiKey=%s already exists.", arrayOfObject);
        }
      }
      while (true)
      {
        return;
        b(parame);
      }
    }
    finally
    {
    }
  }

  com.yandex.metrica.c b(e parame)
  {
    try
    {
      Object localObject2 = (com.yandex.metrica.c)this.f.get(parame.apiKey);
      if (localObject2 == null)
      {
        if (!"20799a27-fa80-4b36-b2db-0f8141f24180".equals(parame.apiKey))
          this.e.c();
        localObject2 = new ae(this.a, this.b, parame, this.c);
        a((c)localObject2);
        ((ae)localObject2).a();
        this.f.put(parame.apiKey, localObject2);
      }
      return localObject2;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bh
 * JD-Core Version:    0.6.2
 */