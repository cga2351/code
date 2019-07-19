package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

public final class co
  implements cp
{
  private final WeakReference<Context> a;
  private final ResultReceiver b;
  private final boolean c;

  public co(Context paramContext, boolean paramBoolean, ResultReceiver paramResultReceiver)
  {
    this.a = new WeakReference(paramContext);
    this.c = paramBoolean;
    this.b = paramResultReceiver;
  }

  public final void a(bz parambz, String paramString)
  {
    n.a((Context)this.a.get(), parambz, paramString, this.b, this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.co
 * JD-Core Version:    0.6.2
 */