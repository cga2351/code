package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.MobileAds;

public final class cf
  implements ce<et>
{
  private final Context a;
  private final cd b;
  private final cg c;
  private final ci d;
  private final bs<et> e;

  public cf(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.e = new bu();
    this.b = new cd();
    this.c = new cg();
    this.d = new ci();
  }

  public final boolean a()
  {
    et localet = es.a().a(this.a);
    int i;
    int j;
    if (localet != null)
    {
      if (System.currentTimeMillis() < localet.a())
        break label80;
      i = 1;
      if (i == 0)
      {
        if (MobileAds.getLibraryVersion().equals(localet.h()))
          break label85;
        j = 1;
        label48: if (j == 0)
          if (es.a().e() == localet.d())
            break label91;
      }
    }
    label80: label85: label91: for (int k = 1; ; k = 0)
    {
      boolean bool = false;
      if (k != 0)
        bool = true;
      return bool;
      i = 0;
      break;
      j = 0;
      break label48;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cf
 * JD-Core Version:    0.6.2
 */