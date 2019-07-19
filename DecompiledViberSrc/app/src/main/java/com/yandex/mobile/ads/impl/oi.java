package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class oi<T>
  implements Comparable<oi<T>>
{
  private final fp.a a = null;
  private final int b;
  private final String c;
  private final int d;
  private final ok.a e;
  private Integer f;
  private oj g;
  private boolean h = true;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private om l;
  private ob.a m = null;
  private Object n;

  public oi(int paramInt, String paramString, ok.a parama)
  {
    this.b = paramInt;
    this.c = paramString;
    this.e = parama;
    this.l = new od();
    boolean bool = TextUtils.isEmpty(paramString);
    int i1 = 0;
    if (!bool)
    {
      Uri localUri = Uri.parse(paramString);
      i1 = 0;
      if (localUri != null)
      {
        String str = localUri.getHost();
        i1 = 0;
        if (str != null)
          i1 = str.hashCode();
      }
    }
    this.d = i1;
  }

  public static String k()
  {
    return "application/x-www-form-urlencoded; charset=UTF-8";
  }

  public final oi<?> a(ob.a parama)
  {
    this.m = parama;
    return this;
  }

  public final oi<?> a(oj paramoj)
  {
    this.g = paramoj;
    return this;
  }

  public final oi<?> a(om paramom)
  {
    this.l = paramom;
    return this;
  }

  public final oi<?> a(Object paramObject)
  {
    this.n = paramObject;
    return this;
  }

  protected abstract ok<T> a(oh paramoh);

  protected ov a(ov paramov)
  {
    return paramov;
  }

  public Map<String, String> a()
    throws oo
  {
    return Collections.emptyMap();
  }

  public String b()
  {
    return this.c;
  }

  public final void b(ov paramov)
  {
    if (this.e != null)
      this.e.a(paramov);
  }

  protected abstract void b(T paramT);

  public final oi<?> c(int paramInt)
  {
    this.f = Integer.valueOf(paramInt);
    return this;
  }

  public byte[] c()
    throws oo
  {
    return null;
  }

  public final int d()
  {
    return this.b;
  }

  public final Object e()
  {
    return this.n;
  }

  public final int f()
  {
    return this.d;
  }

  final void g()
  {
    if (this.g != null)
      this.g.b(this);
  }

  public final ob.a h()
  {
    return this.m;
  }

  public final void i()
  {
    this.i = true;
  }

  public final boolean j()
  {
    return this.i;
  }

  public final oi<?> l()
  {
    this.h = false;
    return this;
  }

  public final boolean m()
  {
    return this.h;
  }

  public final boolean n()
  {
    return this.k;
  }

  public a o()
  {
    return a.b;
  }

  public final int p()
  {
    return this.l.a();
  }

  public final om q()
  {
    return this.l;
  }

  public final void r()
  {
    this.j = true;
  }

  public final boolean s()
  {
    return this.j;
  }

  public String toString()
  {
    String str1 = "0x" + Integer.toHexString(this.d);
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.i);
    for (String str2 = "[X] "; ; str2 = "[ ] ")
      return str2 + b() + " " + str1 + " " + o() + " " + this.f;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.oi
 * JD-Core Version:    0.6.2
 */