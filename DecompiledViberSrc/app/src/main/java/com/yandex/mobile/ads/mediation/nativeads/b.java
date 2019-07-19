package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.impl.dh;

final class b
{
  private final Context a;

  b(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }

  final String a(int paramInt1, int paramInt2)
  {
    int i = dh.a(this.a, paramInt1);
    int j = dh.a(this.a, paramInt2);
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(j);
    if ((i >= 320) || (j >= 240))
      return "large";
    if ((i >= 160) || (j >= 160))
      return "medium";
    return "small";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.b
 * JD-Core Version:    0.6.2
 */