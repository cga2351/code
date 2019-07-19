package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.IIdentifierCallback.Reason;
import com.yandex.metrica.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class eu
  implements IIdentifierCallback, ew
{
  private static final long a = ez.b;
  private static final Object b = new Object();
  private static volatile ew c;
  private final WeakHashMap<ev, Object> d = new WeakHashMap();
  private final Handler e = new Handler(Looper.getMainLooper());
  private final ey f = new ey();
  private Map<String, String> g;
  private boolean h;

  private eu(Context paramContext)
  {
    fb.a(paramContext);
  }

  public static ew a(Context paramContext)
  {
    if (c == null);
    synchronized (b)
    {
      if (c == null)
        c = new eu(paramContext.getApplicationContext());
      return c;
    }
  }

  private void a()
  {
    this.e.removeCallbacksAndMessages(null);
    this.h = false;
  }

  private void a(Map<String, String> paramMap)
  {
    synchronized (b)
    {
      a();
      Iterator localIterator = this.d.keySet().iterator();
      if (localIterator.hasNext())
        ((ev)localIterator.next()).a(paramMap);
    }
    this.d.clear();
  }

  public final void a(ev paramev)
  {
    synchronized (b)
    {
      if ((this.g != null) && (ey.a(this.g)))
        paramev.a(this.g);
      while (true)
      {
        return;
        this.d.put(paramev, null);
        try
        {
          if (this.h)
            continue;
          this.h = true;
          this.e.postDelayed(new Runnable()
          {
            public final void run()
            {
              eu.this.onRequestError(IIdentifierCallback.Reason.UNKNOWN);
            }
          }
          , a);
          p.a(this);
        }
        catch (Throwable localThrowable)
        {
          onRequestError(IIdentifierCallback.Reason.UNKNOWN);
        }
      }
    }
  }

  public final void b(ev paramev)
  {
    synchronized (b)
    {
      this.d.remove(paramev);
      return;
    }
  }

  public final void onReceive(Map<String, String> paramMap)
  {
    Object localObject1 = b;
    if (paramMap != null);
    try
    {
      if (ey.a(paramMap))
      {
        this.g = new HashMap(paramMap);
        a(this.g);
      }
      while (true)
      {
        return;
        onRequestError(IIdentifierCallback.Reason.INVALID_RESPONSE);
      }
    }
    finally
    {
    }
  }

  public final void onRequestError(IIdentifierCallback.Reason paramReason)
  {
    synchronized (b)
    {
      a();
      Iterator localIterator = this.d.keySet().iterator();
      if (localIterator.hasNext())
        ((ev)localIterator.next()).a();
    }
    this.d.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.eu
 * JD-Core Version:    0.6.2
 */