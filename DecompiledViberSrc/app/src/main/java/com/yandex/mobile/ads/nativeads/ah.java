package com.yandex.mobile.ads.nativeads;

import android.view.View;
import java.util.Map;
import java.util.WeakHashMap;

final class ah
{
  private static final Object a = new Object();
  private static volatile ah b;
  private final Map<View, aw> c = new WeakHashMap();

  static ah a()
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new ah();
      return b;
    }
  }

  final aw a(View paramView)
  {
    synchronized (a)
    {
      aw localaw = (aw)this.c.get(paramView);
      return localaw;
    }
  }

  final void a(View paramView, aw paramaw)
  {
    synchronized (a)
    {
      this.c.put(paramView, paramaw);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.ah
 * JD-Core Version:    0.6.2
 */