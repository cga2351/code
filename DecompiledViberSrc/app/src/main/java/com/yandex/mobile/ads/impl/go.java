package com.yandex.mobile.ads.impl;

import java.lang.ref.WeakReference;

public class go extends gd
{
  final ea a;

  public go(ds paramds, dn paramdn)
  {
    super(paramds);
    this.a = new ea(paramds);
    this.a.a(new a(paramdn));
  }

  public final void a(dn paramdn)
  {
    super.a(new gn(this.a, paramdn));
  }

  public final void a(String paramString)
  {
    this.a.a(paramString);
  }

  public final void b()
  {
    super.b();
    this.a.c();
  }

  static final class a
    implements ed
  {
    private final WeakReference<dn> a;

    a(dn paramdn)
    {
      this.a = new WeakReference(paramdn);
    }

    public final void a()
    {
      dn localdn = (dn)this.a.get();
      if (localdn != null)
        localdn.onAdLoaded();
    }

    public final void a(String paramString)
    {
      dn localdn = (dn)this.a.get();
      if (localdn != null)
        localdn.a(paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.go
 * JD-Core Version:    0.6.2
 */