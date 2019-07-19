package com.yandex.metrica.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.yandex.metrica.impl.ob.fj;
import com.yandex.metrica.impl.ob.fy;
import com.yandex.metrica.impl.ob.hd;
import com.yandex.metrica.impl.ob.hd.a;
import com.yandex.metrica.impl.ob.ku;
import com.yandex.metrica.impl.ob.ku.a;
import com.yandex.metrica.impl.ob.li;
import com.yandex.metrica.impl.ob.ma;
import com.yandex.metrica.impl.ob.mg;
import com.yandex.metrica.impl.ob.mw;

public final class v
{

  @SuppressLint({"StaticFieldLeak"})
  private static volatile v a;
  private final Context b;
  private li c;
  private mg d;
  private ku e;
  private bt f;
  private a g;
  private ma h;
  private Handler i;

  private v(Context paramContext)
  {
    this.b = paramContext;
    HandlerThread localHandlerThread = new HandlerThread("YMM-RRT");
    localHandlerThread.start();
    this.i = new Handler(localHandlerThread.getLooper());
  }

  public static v a()
  {
    return a;
  }

  public static void a(Context paramContext)
  {
    try
    {
      if (a == null)
        a = new v(paramContext.getApplicationContext());
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
    if (this.h != null)
      this.h.b(parammw);
  }

  public Context b()
  {
    return this.b;
  }

  public li c()
  {
    try
    {
      if (this.c == null)
        this.c = new li(this.b);
      li localli = this.c;
      return localli;
    }
    finally
    {
    }
  }

  public mg d()
  {
    try
    {
      if (this.d == null)
        this.d = new mg(this.b);
      mg localmg = this.d;
      return localmg;
    }
    finally
    {
    }
  }

  public ku e()
  {
    try
    {
      if (this.e == null)
        this.e = new ku(this.b, hd.a.a(ku.a.class).a(this.b), a.g(), d(), this.i);
      ku localku = this.e;
      return localku;
    }
    finally
    {
    }
  }

  public ma f()
  {
    try
    {
      if (this.h == null)
        this.h = new ma(this.b, this.i);
      ma localma = this.h;
      return localma;
    }
    finally
    {
    }
  }

  public bt g()
  {
    try
    {
      if (this.f == null)
        this.f = new bt(new bt.b(new fy(fj.a(this.b).c())));
      bt localbt = this.f;
      return localbt;
    }
    finally
    {
    }
  }

  public a h()
  {
    try
    {
      if (this.g == null)
        this.g = new a();
      a locala = this.g;
      return locala;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.v
 * JD-Core Version:    0.6.2
 */