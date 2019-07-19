package com.yandex.mobile.ads.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

@TargetApi(14)
final class jm
  implements jk
{
  private static final Object a = new Object();
  private static volatile jm b;
  private final Object c = new Object();
  private boolean d;
  private final Map<jn, Void> e = new WeakHashMap();
  private final Application.ActivityLifecycleCallbacks f = new Application.ActivityLifecycleCallbacks()
  {
    public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
    {
    }

    public final void onActivityDestroyed(Activity paramAnonymousActivity)
    {
    }

    public final void onActivityPaused(Activity paramAnonymousActivity)
    {
      synchronized (jm.a(jm.this))
      {
        Iterator localIterator = new HashSet(jm.b(jm.this).keySet()).iterator();
        if (localIterator.hasNext())
          ((jn)localIterator.next()).b(paramAnonymousActivity);
      }
    }

    public final void onActivityResumed(Activity paramAnonymousActivity)
    {
      synchronized (jm.a(jm.this))
      {
        Iterator localIterator = new HashSet(jm.b(jm.this).keySet()).iterator();
        if (localIterator.hasNext())
          ((jn)localIterator.next()).a(paramAnonymousActivity);
      }
    }

    public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
    {
    }

    public final void onActivityStarted(Activity paramAnonymousActivity)
    {
    }

    public final void onActivityStopped(Activity paramAnonymousActivity)
    {
      synchronized (jm.a(jm.this))
      {
        if (jm.b(jm.this).isEmpty())
          jm.this.a(paramAnonymousActivity);
        return;
      }
    }
  };

  public static jm a()
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new jm();
      return b;
    }
  }

  private boolean b()
  {
    synchronized (this.c)
    {
      boolean bool = this.d;
      return bool;
    }
  }

  final void a(Context paramContext)
  {
    try
    {
      if (b())
      {
        ((Application)paramContext.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f);
        this.d = false;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void a(Context paramContext, jn paramjn)
  {
    synchronized (this.c)
    {
      this.e.put(paramjn, null);
      boolean bool = b();
      if (bool);
    }
    try
    {
      ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(this.f);
      this.d = true;
      label49: return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Throwable localThrowable)
    {
      break label49;
    }
  }

  public final void b(Context paramContext, jn paramjn)
  {
    synchronized (this.c)
    {
      this.e.remove(paramjn);
      if (this.e.isEmpty())
        a(paramContext);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jm
 * JD-Core Version:    0.6.2
 */