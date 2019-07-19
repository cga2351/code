package com.yandex.metrica.impl;

import android.os.Handler;
import java.lang.ref.WeakReference;

class ab
  implements Runnable
{
  private final WeakReference<Handler> a;
  private final WeakReference<c> b;

  ab(Handler paramHandler, c paramc)
  {
    this.a = new WeakReference(paramHandler);
    this.b = new WeakReference(paramc);
  }

  public void run()
  {
    Handler localHandler = (Handler)this.a.get();
    c localc = (c)this.b.get();
    if ((localHandler != null) && (localc != null) && (localc.c()))
      aa.a(localHandler, localc, this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ab
 * JD-Core Version:    0.6.2
 */