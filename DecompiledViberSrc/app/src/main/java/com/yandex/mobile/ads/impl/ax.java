package com.yandex.mobile.ads.impl;

import java.lang.ref.WeakReference;

public final class ax
{
  private final cv a;
  private final WeakReference<y> b;

  public ax(y paramy, bb parambb)
  {
    this.b = new WeakReference(paramy);
    this.a = new cu(parambb);
  }

  final void a()
  {
    y localy = (y)this.b.get();
    if ((localy != null) && (!localy.k()))
      localy.b(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ax
 * JD-Core Version:    0.6.2
 */