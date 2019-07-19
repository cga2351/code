package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

public final class ku
  implements cp
{
  private final WeakReference<Context> a;
  private final eo b;
  private final ResultReceiver c;

  public ku(Context paramContext, eo parameo, ResultReceiver paramResultReceiver)
  {
    this.a = new WeakReference(paramContext);
    this.b = parameo;
    this.c = paramResultReceiver;
  }

  public final void a(bz parambz, String paramString)
  {
    boolean bool = this.b.i();
    n.a((Context)this.a.get(), parambz, paramString, this.c, bool);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ku
 * JD-Core Version:    0.6.2
 */