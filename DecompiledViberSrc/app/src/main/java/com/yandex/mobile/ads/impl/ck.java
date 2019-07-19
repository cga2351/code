package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.b;
import java.util.HashMap;
import java.util.Map;

public final class ck
{
  private final cj a;
  private final fb b;
  private final eo c;
  private final cn d;
  private a e;
  private fd.a f;
  private long g;

  ck(Context paramContext, eo parameo, cn paramcn)
  {
    this.c = parameo;
    this.d = paramcn;
    this.a = new cj(paramContext);
    this.b = fb.a(paramContext);
  }

  final void a(a parama)
  {
    new StringBuilder("startActivityInteraction, type = ").append(parama);
    this.g = System.currentTimeMillis();
    this.e = parama;
  }

  public final void a(fd.a parama)
  {
    this.f = parama;
  }

  final void b(a parama)
  {
    new StringBuilder("finishActivityInteraction, type = ").append(parama);
    long l;
    String str1;
    if ((this.g != 0L) && (this.e == parama))
    {
      l = System.currentTimeMillis() - this.g;
      if (l >= 1000L)
        break label231;
      str1 = "<1";
    }
    while (true)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", parama.c);
      localHashMap.put("ad_type", this.c.a().a());
      localHashMap.put("block_id", this.c.e());
      localHashMap.put("interval", str1);
      if (this.f != null)
        localHashMap.putAll(this.f.a());
      fd localfd = new fd(fd.b.A, localHashMap);
      this.b.a(localfd);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = parama.c;
      arrayOfObject[1] = str1;
      if (l <= this.d.b())
      {
        String str2 = this.d.a();
        this.a.a(str2);
      }
      this.g = 0L;
      this.e = null;
      return;
      label231: if ((l > 1000L) && (l <= 2000L))
        str1 = "1-2";
      else if ((l > 2000L) && (l <= 3000L))
        str1 = "2-3";
      else if ((l > 3000L) && (l <= 5000L))
        str1 = "3-5";
      else if ((l > 5000L) && (l <= 10000L))
        str1 = "5-10";
      else if ((l > 10000L) && (l <= 15000L))
        str1 = "10-15";
      else if ((l > 15000L) && (l <= 20000L))
        str1 = "15-20";
      else
        str1 = ">20";
    }
  }

  public static enum a
  {
    final String c;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }

    private a(String paramString)
    {
      this.c = paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ck
 * JD-Core Version:    0.6.2
 */