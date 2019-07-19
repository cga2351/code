package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.impl.ba;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.impl.v;
import com.yandex.mobile.ads.nativeads.bi;
import com.yandex.mobile.ads.nativeads.bj;
import com.yandex.mobile.ads.nativeads.s;
import com.yandex.mobile.ads.nativeads.t;
import java.lang.ref.WeakReference;

public final class p
  implements o
{
  private final WeakReference<t> a;
  private final ba b;

  public p(t paramt)
  {
    this.a = new WeakReference(paramt);
    this.b = new ba();
  }

  public final void a(Context paramContext, v<lm> paramv)
  {
    t localt = (t)this.a.get();
    if (localt != null)
    {
      ba.a(paramContext, paramv);
      ba.b(paramContext, paramv);
      bj localbj = new bj();
      localt.a(paramv, new s(new bi(), localbj));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.p
 * JD-Core Version:    0.6.2
 */