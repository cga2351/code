package com.yandex.mobile.ads.nativeads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.yandex.mobile.ads.impl.w;
import com.yandex.mobile.ads.impl.w.a;
import java.lang.ref.WeakReference;

public final class b
  implements w.a
{
  private final w a;
  private final WeakReference<q> b;

  public b(q paramq)
  {
    this.b = new WeakReference(paramq);
    this.a = new w(new Handler(Looper.getMainLooper()));
    this.a.a(this);
  }

  public final w a()
  {
    return this.a;
  }

  public final void a(int paramInt, Bundle paramBundle)
  {
    q localq = (q)this.b.get();
    if (localq != null);
    switch (paramInt)
    {
    default:
      return;
    case 9:
      localq.b();
      return;
    case 8:
      localq.c();
      return;
    case 7:
      localq.e();
      return;
    case 6:
    }
    localq.f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.b
 * JD-Core Version:    0.6.2
 */