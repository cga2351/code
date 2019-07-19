package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.s.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class bl
{
  public static final Map<Integer, Integer> a = Collections.unmodifiableMap(new HashMap()
  {
  });
  private final i b;
  private final bm c;
  private final bo d;
  private final pm e;
  private final pm f;
  private final on g;

  public bl(i parami, bm parambm, bo parambo)
  {
    this(parami, parambm, parambo, new pm(1024, "diagnostic event name"), new pm(204800, "diagnostic event value"), new om());
  }

  public bl(i parami, bm parambm, bo parambo, pm parampm1, pm parampm2, on paramon)
  {
    this.b = parami;
    this.c = parambm;
    this.d = parambo;
    this.f = parampm1;
    this.e = parampm2;
    this.g = paramon;
  }

  public byte[] a()
  {
    kk.c localc = new kk.c();
    kk.c.e locale = new kk.c.e();
    localc.b = new kk.c.e[] { locale };
    bo.a locala = this.d.a();
    locale.b = locala.a;
    locale.c = new kk.c.e.b();
    locale.c.d = 2;
    locale.c.b = new kk.c.g();
    locale.c.b.b = locala.b;
    locale.c.b.c = oo.a(locala.b);
    locale.c.c = this.c.y();
    kk.c.e.a locala1 = new kk.c.e.a();
    locale.d = new kk.c.e.a[] { locala1 };
    locala1.b = locala.c;
    locala1.c = (this.g.b() - locala.b);
    locala1.d = ((Integer)a.get(Integer.valueOf(this.b.e()))).intValue();
    if (!TextUtils.isEmpty(this.b.b()))
      locala1.e = this.f.a(this.b.b());
    int i;
    if (!TextUtils.isEmpty(this.b.c()))
    {
      String str1 = this.b.c();
      String str2 = this.e.a(str1);
      if (!TextUtils.isEmpty(str2))
        locala1.f = str2.getBytes();
      i = str1.getBytes().length;
      if (locala1.f != null)
        break label319;
    }
    label319: for (int j = 0; ; j = locala1.f.length)
    {
      locala1.k = (i - j);
      return e.a(localc);
    }
  }

  public static class a
  {
    public bl a(i parami, bm parambm, bo parambo)
    {
      return new bl(parami, parambm, parambo);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.bl
 * JD-Core Version:    0.6.2
 */