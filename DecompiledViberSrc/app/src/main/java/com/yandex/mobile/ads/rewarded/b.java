package com.yandex.mobile.ads.rewarded;

import android.content.Context;
import android.os.Bundle;
import com.yandex.mobile.ads.impl.bf;
import com.yandex.mobile.ads.impl.di;
import com.yandex.mobile.ads.impl.eo;
import com.yandex.mobile.ads.impl.ft;
import com.yandex.mobile.ads.impl.hs;
import com.yandex.mobile.ads.impl.ht;
import com.yandex.mobile.ads.impl.pq;
import com.yandex.mobile.ads.impl.pr;
import com.yandex.mobile.ads.impl.t;
import com.yandex.mobile.ads.impl.v;

public final class b extends ft
{
  private final a h;
  private final di i;
  private final pr j;
  private pq k;

  public b(Context paramContext, a parama)
  {
    super(paramContext, com.yandex.mobile.ads.b.c, parama);
    this.h = parama;
    this.i = new di();
    this.j = new pr(parama);
  }

  public final void B()
  {
    if (this.k != null)
      this.k.a();
  }

  protected final hs a(ht paramht)
  {
    return paramht.a(this);
  }

  public final void a()
  {
    this.k = this.j.a(this.b, this.g);
    super.a();
  }

  public final void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default:
      super.a(paramInt, paramBundle);
      return;
    case 13:
    }
    B();
  }

  public final void a(v<String> paramv)
  {
    int m = 1;
    bf localbf = paramv.p();
    if (localbf != null)
      if (localbf.c())
        if (localbf.b() == null);
    while (m != 0)
    {
      super.a(paramv);
      return;
      m = 0;
      continue;
      if (localbf.a() == null)
      {
        m = 0;
        continue;
        m = 0;
      }
    }
    onAdFailedToLoad(t.e);
  }

  final void a(RewardedAdEventListener paramRewardedAdEventListener)
  {
    this.h.a(paramRewardedAdEventListener);
  }

  final void c(String paramString)
  {
    this.f.e(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.rewarded.b
 * JD-Core Version:    0.6.2
 */