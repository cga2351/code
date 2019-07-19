package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.nativeads.NativeGenericAd;
import com.yandex.mobile.ads.nativeads.bb;
import com.yandex.mobile.ads.nativeads.bc;
import com.yandex.mobile.ads.nativeads.c;
import com.yandex.mobile.ads.nativeads.i;
import com.yandex.mobile.ads.nativeads.n;
import com.yandex.mobile.ads.nativeads.o;
import com.yandex.mobile.ads.nativeads.r;
import com.yandex.mobile.ads.nativeads.s;
import com.yandex.mobile.ads.nativeads.u;
import java.util.List;

final class kf
  implements jz
{
  private final kl a = new kl();

  public final void a(Context paramContext, o paramo, i parami, s params, kb paramkb)
  {
    List localList = paramo.c().c();
    ll localll;
    kk localkk;
    bb localbb;
    c localc;
    if ((localList != null) && (!localList.isEmpty()))
    {
      localll = (ll)localList.get(0);
      if (localll != null)
      {
        localkk = kl.a(localll.b());
        if (localkk != null)
        {
          localbb = params.b().a(localll);
          r localr = params.a();
          localc = n.a(paramo, n.a(paramo, localll), localbb, localr);
        }
      }
    }
    for (NativeGenericAd localNativeGenericAd = localkk.a(paramContext, localll, new u(paramContext, localll, parami, localbb), parami, localc); ; localNativeGenericAd = null)
    {
      if (localNativeGenericAd != null)
      {
        paramkb.a(localNativeGenericAd);
        return;
      }
      paramkb.a(t.a);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.kf
 * JD-Core Version:    0.6.2
 */