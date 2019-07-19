package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.ao;
import com.yandex.mobile.ads.impl.jp;
import com.yandex.mobile.ads.impl.jq;
import com.yandex.mobile.ads.impl.le;
import com.yandex.mobile.ads.impl.li;

public final class e
{
  private final a a;
  private final ao b;

  e(a parama, ao paramao)
  {
    this.a = parama;
    this.b = paramao;
  }

  public final void a(le paramle, li paramli, af paramaf, jp paramjp)
  {
    if ((paramle.e()) && (paramli != null))
      paramjp.a(paramli, new jq(paramle, this.a, paramaf, this.b));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.e
 * JD-Core Version:    0.6.2
 */