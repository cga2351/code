package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.nativeads.af;
import com.yandex.mobile.ads.nativeads.q;

final class ky
{
  private final bz a;
  private final kv b;
  private final q c;
  private final af d;

  ky(bz parambz, kv paramkv, af paramaf, q paramq)
  {
    this.a = parambz;
    this.b = paramkv;
    this.d = paramaf;
    this.c = paramq;
  }

  final kx a(Context paramContext, lo paramlo)
  {
    String str = paramlo.a();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 94756344:
    case 629233382:
    case -191501435:
    case -342500282:
    }
    while (true)
      switch (i)
      {
      default:
        return null;
        if (str.equals("close"))
        {
          i = 0;
          continue;
          if (str.equals("deeplink"))
          {
            i = 1;
            continue;
            if (str.equals("feedback"))
            {
              i = 2;
              continue;
              if (str.equals("shortcut"))
                i = 3;
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    return new la(this.a, this.c);
    return new lb(new ne(paramContext, this.a, this.b));
    return new lc(new nj(this.a, this.d, this.c));
    return new ld(new nm(paramContext, this.a, this.d));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ky
 * JD-Core Version:    0.6.2
 */