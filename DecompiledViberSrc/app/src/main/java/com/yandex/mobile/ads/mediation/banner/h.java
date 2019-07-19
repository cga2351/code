package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import com.yandex.mobile.ads.impl.a;
import com.yandex.mobile.ads.impl.ba;
import com.yandex.mobile.ads.impl.v;
import java.lang.ref.WeakReference;

public final class h
  implements b
{
  private final WeakReference<a> a;
  private final ba b;

  public h(a parama)
  {
    this.a = new WeakReference(parama);
    this.b = new ba();
  }

  public final void a(Context paramContext)
  {
  }

  public final void a(Context paramContext, v<String> paramv)
  {
    a locala = (a)this.a.get();
    if (locala != null)
    {
      ba.a(paramContext, paramv);
      ba.b(paramContext, paramv);
      locala.b(paramv);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.banner.h
 * JD-Core Version:    0.6.2
 */