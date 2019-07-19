package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.PackageManager;

public class np extends nf
{
  private static final Object a = new Object();
  private static volatile np b;
  private int c;
  private nf d;

  np(Context paramContext)
  {
    if (paramContext.getPackageManager().hasSystemFeature("android.hardware.telephony"))
    {
      this.d = new nj(paramContext);
      return;
    }
    this.d = new nk();
  }

  public static np a(Context paramContext)
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new np(paramContext.getApplicationContext());
      return b;
    }
  }

  public void a()
  {
    try
    {
      this.c = (1 + this.c);
      if (this.c == 1)
        this.d.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(mw parammw)
  {
    this.d.a(parammw);
  }

  public void a(nh paramnh)
  {
    try
    {
      this.d.a(paramnh);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(ns paramns)
  {
    try
    {
      this.d.a(paramns);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }

  public void b()
  {
    try
    {
      this.c = (-1 + this.c);
      if (this.c == 0)
        this.d.b();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.np
 * JD-Core Version:    0.6.2
 */