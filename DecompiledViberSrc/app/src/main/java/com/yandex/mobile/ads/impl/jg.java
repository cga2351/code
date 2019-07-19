package com.yandex.mobile.ads.impl;

import android.view.View;
import com.yandex.mobile.ads.nativeads.af;
import com.yandex.mobile.ads.nativeads.e;

public final class jg
  implements ji
{
  private final af a;
  private final e b;

  public jg(af paramaf, e parame)
  {
    this.a = paramaf;
    this.b = parame;
  }

  public final void a(le paramle, View paramView)
  {
  }

  public final void a(le paramle, jp paramjp)
  {
    li localli = paramle.d();
    this.b.a(paramle, localli, this.a, paramjp);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jg
 * JD-Core Version:    0.6.2
 */