package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.b;

public final class eo
{
  private aj a;
  private final b b;
  private AdRequest c;
  private ad d;
  private ac e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String[] k;
  private int l;
  private String[] m;
  private String n;
  private boolean o;
  private boolean p;
  private int q = 1;
  private int r = ez.b;

  public eo(b paramb)
  {
    this.b = paramb;
  }

  public final b a()
  {
    return this.b;
  }

  public final void a(int paramInt)
  {
    this.l = paramInt;
  }

  public final void a(AdRequest paramAdRequest)
  {
    this.c = paramAdRequest;
  }

  public final void a(ac paramac)
  {
    this.e = paramac;
  }

  public final void a(ad paramad)
  {
    this.d = paramad;
  }

  public final void a(aj paramaj)
  {
    if (paramaj == null)
      throw new IllegalArgumentException("Ad size can't be null or empty.");
    if (this.a != null)
      throw new IllegalArgumentException("Ad size can't be set twice.");
    this.a = paramaj;
  }

  public final void a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
        this.f = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  public final void a(String[] paramArrayOfString)
  {
    this.k = paramArrayOfString;
  }

  public final aj b()
  {
    return this.a;
  }

  public final void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("Block ID can't be null or empty.");
    if (!TextUtils.isEmpty(this.g))
      throw new IllegalArgumentException("Block ID can't be set twice.");
    this.g = paramString;
  }

  public final void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public final void b(String[] paramArrayOfString)
  {
    this.m = paramArrayOfString;
  }

  public final AdRequest c()
  {
    return this.c;
  }

  public final void c(String paramString)
  {
    try
    {
      this.h = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String d()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void d(String paramString)
  {
    try
    {
      this.i = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String e()
  {
    return this.g;
  }

  public final void e(String paramString)
  {
    this.n = paramString;
  }

  public final String f()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String g()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String h()
  {
    return this.j;
  }

  public final boolean i()
  {
    return this.o;
  }

  public final int j()
  {
    return this.q;
  }

  public final int k()
  {
    return this.r;
  }

  public final boolean l()
  {
    return !TextUtils.isEmpty(this.g);
  }

  public final String[] m()
  {
    return this.k;
  }

  public final ac n()
  {
    return this.e;
  }

  public final ad o()
  {
    return this.d;
  }

  public final int p()
  {
    return this.l;
  }

  public final String[] q()
  {
    return this.m;
  }

  public final String r()
  {
    return this.n;
  }

  public final boolean s()
  {
    return this.p;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.eo
 * JD-Core Version:    0.6.2
 */