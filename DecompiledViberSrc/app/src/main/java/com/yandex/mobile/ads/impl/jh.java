package com.yandex.mobile.ads.impl;

import android.view.View;
import com.yandex.mobile.ads.nativeads.af;
import com.yandex.mobile.ads.nativeads.e;

public final class jh
  implements ji
{
  private final af a;
  private final e b;
  private final li c;
  private final dg d;

  public jh(af paramaf, e parame, li paramli)
  {
    this.a = paramaf;
    this.b = parame;
    this.c = paramli;
    this.d = new dg();
  }

  public final void a(le paramle, View paramView)
  {
    if (paramView.getTag() == null)
      paramView.setTag(dg.a(paramle.a()));
  }

  public final void a(le paramle, jp paramjp)
  {
    li localli = paramle.d();
    if (localli != null);
    while (true)
    {
      this.b.a(paramle, localli, this.a, paramjp);
      return;
      localli = this.c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jh
 * JD-Core Version:    0.6.2
 */