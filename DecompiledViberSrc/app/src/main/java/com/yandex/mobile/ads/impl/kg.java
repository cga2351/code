package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.yandex.mobile.ads.nativeads.h;
import com.yandex.mobile.ads.nativeads.i;
import com.yandex.mobile.ads.nativeads.j;
import com.yandex.mobile.ads.nativeads.o;
import com.yandex.mobile.ads.nativeads.s;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class kg
{
  private final jy a;
  private final kd b;
  private final h c;

  kg(kd paramkd, h paramh)
  {
    this.b = paramkd;
    this.c = paramh;
    this.a = new jy();
  }

  final void a(final Context paramContext, final o paramo, final i parami, final s params, final kb paramkb)
  {
    List localList = paramo.c().c();
    Set localSet = this.c.a(localList);
    this.c.a(localSet, new j()
    {
      public final void a(Map<String, Bitmap> paramAnonymousMap)
      {
        jy.a(paramo, paramAnonymousMap);
        parami.a(paramAnonymousMap);
        kg.a(kg.this).a(paramContext, paramo, parami, params, paramkb);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.kg
 * JD-Core Version:    0.6.2
 */