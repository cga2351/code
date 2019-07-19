package com.viber.common.app;

import android.arch.lifecycle.e;
import android.arch.lifecycle.g;
import android.arch.lifecycle.h;
import android.arch.lifecycle.p;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

public class c
{
  private static final Object a = new Object();
  private static c b;
  private final List<a> c = new ArrayList();
  private volatile boolean d;
  private volatile boolean e = true;
  private final g f = new AppLifecycleListener.1(this);

  private c()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
      throw new IllegalStateException("AppLifecycleListener can be created only on the main thread.");
    p.a().getLifecycle().a(this.f);
  }

  public static c a()
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new c();
      return b;
    }
  }

  private List<a> c()
  {
    synchronized (this.c)
    {
      ArrayList localArrayList = new ArrayList(this.c);
      return localArrayList;
    }
  }

  public void a(a parama)
  {
    synchronized (this.c)
    {
      this.c.add(parama);
      return;
    }
  }

  public boolean b()
  {
    return this.d;
  }

  public static abstract interface a
  {
    public abstract void onAppStopped();

    public abstract void onBackground();

    public abstract void onForeground();

    public abstract void onForegroundStateChanged(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.app.c
 * JD-Core Version:    0.6.2
 */