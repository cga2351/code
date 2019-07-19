package com.yandex.mobile.ads.impl;

import android.content.Context;

public final class es
{
  private static final Object a = new Object();
  private static volatile es b;
  private et c;
  private pi d = new pk();
  private Boolean e;
  private boolean f = true;
  private boolean g;

  public static es a()
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new es();
      return b;
    }
  }

  public final et a(Context paramContext)
  {
    synchronized (a)
    {
      if (this.c == null)
        this.c = fl.b(paramContext);
      et localet = this.c;
      return localet;
    }
  }

  public final void a(Context paramContext, et paramet)
  {
    synchronized (a)
    {
      this.c = paramet;
      fl.a(paramContext, paramet);
      return;
    }
  }

  public final void a(boolean paramBoolean)
  {
    synchronized (a)
    {
      this.g = paramBoolean;
      return;
    }
  }

  public final void b(boolean paramBoolean)
  {
    synchronized (a)
    {
      this.e = Boolean.valueOf(paramBoolean);
      return;
    }
  }

  public final boolean b()
  {
    synchronized (a)
    {
      boolean bool = this.f;
      return bool;
    }
  }

  public final pi c()
  {
    try
    {
      synchronized (a)
      {
        pi localpi = this.d;
        return localpi;
      }
    }
    finally
    {
    }
  }

  public final boolean d()
  {
    synchronized (a)
    {
      boolean bool = this.g;
      return bool;
    }
  }

  public final Boolean e()
  {
    synchronized (a)
    {
      Boolean localBoolean = this.e;
      return localBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.es
 * JD-Core Version:    0.6.2
 */