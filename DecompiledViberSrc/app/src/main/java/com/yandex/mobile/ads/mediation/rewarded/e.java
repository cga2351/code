package com.yandex.mobile.ads.mediation.rewarded;

import android.content.Context;
import com.yandex.mobile.ads.impl.ba;
import com.yandex.mobile.ads.impl.ft;
import com.yandex.mobile.ads.impl.hs;
import com.yandex.mobile.ads.impl.v;
import java.lang.ref.WeakReference;

public final class e
  implements hs
{
  private final WeakReference<ft> a;
  private final ba b;

  public e(ft paramft)
  {
    this.a = new WeakReference(paramft);
    this.b = new ba();
  }

  public final void a(Context paramContext)
  {
  }

  public final void a(Context paramContext, v<String> paramv)
  {
    ft localft = (ft)this.a.get();
    if (localft != null)
    {
      ba.a(paramContext, paramv);
      ba.b(paramContext, paramv);
      localft.b(paramv);
    }
  }

  public final boolean a()
  {
    ft localft = (ft)this.a.get();
    return (localft != null) && (localft.j());
  }

  public final void b()
  {
    ft localft = (ft)this.a.get();
    if (localft != null)
      localft.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.rewarded.e
 * JD-Core Version:    0.6.2
 */