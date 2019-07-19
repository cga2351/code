package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.nativeads.i;
import com.yandex.mobile.ads.nativeads.n;
import com.yandex.mobile.ads.nativeads.o;
import com.yandex.mobile.ads.nativeads.s;

final class kd
{
  private final eo a;
  private final n b;
  private final ka c;

  kd(eo parameo)
  {
    this.a = parameo;
    this.b = new n();
    this.c = new ka();
  }

  final void a(Context paramContext, o paramo, i parami, s params, kb paramkb)
  {
    jz localjz = ka.a(this.a.n());
    if (localjz != null)
    {
      localjz.a(paramContext, paramo, parami, params, paramkb);
      return;
    }
    paramkb.a(t.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.kd
 * JD-Core Version:    0.6.2
 */