package com.yandex.metrica.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.yandex.metrica.AppMetricaDeviceIDListener;
import com.yandex.metrica.AppMetricaDeviceIDListener.Reason;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.IIdentifierCallback.Reason;
import com.yandex.metrica.c;
import com.yandex.metrica.e;
import com.yandex.metrica.e.a;
import com.yandex.metrica.g;
import com.yandex.metrica.impl.ac.GoogleAdvertisingIdGetter;
import com.yandex.metrica.impl.ob.fj;
import com.yandex.metrica.impl.ob.fk;
import com.yandex.metrica.impl.ob.fv;
import com.yandex.metrica.impl.ob.mr;
import com.yandex.metrica.impl.ob.ob.a;
import com.yandex.metrica.impl.ob.od;
import com.yandex.metrica.impl.ob.of;
import com.yandex.metrica.impl.ob.og;
import com.yandex.metrica.impl.ob.u;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class bz
  implements k.a
{

  @SuppressLint({"StaticFieldLeak"})
  private static bz a;
  private static o b = new o();
  private static volatile boolean c;
  private static final EnumMap<IIdentifierCallback.Reason, AppMetricaDeviceIDListener.Reason> d = new EnumMap(IIdentifierCallback.Reason.class);
  private static final Executor e = Executors.newSingleThreadExecutor(new od("YMM-APT"));
  private final Context f;
  private final bh g;
  private ad h;
  private an i;
  private final ExecutorService j = Executors.newSingleThreadExecutor(new od("YMM-RH"));
  private final mr k;
  private final bb l;
  private j m;
  private final u n;
  private Executor o = Executors.newSingleThreadExecutor(new od("YMM-YM"));
  private IIdentifierCallback p;
  private bj q;

  static
  {
    d.put(IIdentifierCallback.Reason.UNKNOWN, AppMetricaDeviceIDListener.Reason.UNKNOWN);
    d.put(IIdentifierCallback.Reason.INVALID_RESPONSE, AppMetricaDeviceIDListener.Reason.INVALID_RESPONSE);
    d.put(IIdentifierCallback.Reason.NETWORK, AppMetricaDeviceIDListener.Reason.NETWORK);
  }

  private bz(Context paramContext, String paramString)
  {
    this.f = paramContext.getApplicationContext();
    fk localfk = fj.a(this.f).f();
    of.a(paramContext.getApplicationContext());
    of localof = og.a(paramString);
    StringBuilder localStringBuilder = new StringBuilder("Initializing of Metrica");
    localStringBuilder.append(", Release type");
    localStringBuilder.append(", Version 3.4.0");
    localStringBuilder.append(", API Level 72");
    localStringBuilder.append(", Dated 05.11.2018.");
    Log.i(localof.e(), localof.f() + localStringBuilder.toString());
    this.n = new u(this.f);
    GoogleAdvertisingIdGetter.b().a(this.f);
    Handler localHandler = new Handler(Looper.getMainLooper());
    k localk = new k(localHandler);
    localk.a(this);
    this.q = new bj(this.n, this.j, this.f, localHandler, localk);
    b.a(this.q);
    fv localfv = new fv(localfk);
    new f(localfv).a(this.f);
    this.k = new mr(this.q, localfv);
    this.q.a(this.k);
    this.l = new bb(this.q, localfv, this.o);
    this.g = new bh(this.f, this.n, this.q, localHandler, this.k);
  }

  public static Executor a()
  {
    return e;
  }

  public static void a(Context paramContext)
  {
    try
    {
      b(paramContext, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void a(Context paramContext, g paramg)
  {
    while (true)
    {
      of localof;
      try
      {
        boolean bool1 = b.d();
        g localg = b.a(paramg);
        b(paramContext, localg);
        localof = og.a(localg.apiKey);
        if (a.h != null)
          break label228;
        bz localbz = a;
        localbz.q.a(localg.locationTracking, localg.statisticsSending);
        localbz.k.c();
        localbz.h = localbz.g.a(localg, bool1);
        boolean bool2 = localbz.h.f();
        if (bool2)
        {
          if (localbz.m == null)
            localbz.m = new bf(localbz.h, new j.a()
            {
              public boolean a(Throwable paramAnonymousThrowable)
              {
                return bz.a(bz.this).f();
              }
            });
          localbz.i.a(localbz.m);
          localbz.h.b(bool2);
          if (Boolean.TRUE.equals(localg.logs))
          {
            localof.a();
            og.a().a();
          }
        }
        else
        {
          localbz.i.b(localbz.m);
          continue;
        }
      }
      finally
      {
      }
      localof.b();
      og.a().b();
      continue;
      label228: if (localof.c())
        localof.b("Appmetrica already has been activated!");
    }
  }

  public static void a(Location paramLocation)
  {
    i().a(paramLocation);
  }

  public static void a(boolean paramBoolean)
  {
    i().a(paramBoolean);
  }

  public static bz b(Context paramContext)
  {
    a(paramContext.getApplicationContext());
    return e();
  }

  public static void b(Context paramContext, g paramg)
  {
    try
    {
      Context localContext;
      if (a == null)
      {
        localContext = paramContext.getApplicationContext();
        if (paramg != null)
          break label129;
      }
      label129: for (String str = ""; ; str = paramg.apiKey)
      {
        bz localbz = new bz(localContext, str);
        a = localbz;
        z.a(localbz.f);
        if (paramg != null)
        {
          localbz.k.a(paramg.d);
          localbz.k.a(paramg.b);
          localbz.k.a(paramg.c);
        }
        localbz.n.a(paramg);
        localbz.j.execute(new ob.a(localbz.f));
        a.b();
        return;
      }
    }
    finally
    {
    }
  }

  public static void c()
  {
    c = true;
  }

  public static boolean d()
  {
    return c;
  }

  public static bz e()
  {
    try
    {
      bz localbz = a;
      return localbz;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static bz f()
  {
    return e();
  }

  public static ad g()
  {
    try
    {
      ad localad = e().h;
      return localad;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  static boolean h()
  {
    try
    {
      if (a != null)
      {
        ad localad = a.h;
        if (localad != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  static ag i()
  {
    if (h())
      return e().h;
    return b;
  }

  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      this.k.a(paramBundle);
      return;
    case 2:
    }
    this.k.b(paramBundle);
  }

  public void a(final AppMetricaDeviceIDListener paramAppMetricaDeviceIDListener)
  {
    this.p = new IIdentifierCallback()
    {
      public void onReceive(final Map<String, String> paramAnonymousMap)
      {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            bz.a(bz.this, null);
            bz.3.this.a.onLoaded((String)paramAnonymousMap.get("appmetrica_device_id_hash"));
          }
        });
      }

      public void onRequestError(IIdentifierCallback.Reason paramAnonymousReason)
      {
        bz.a(bz.this, null);
        paramAppMetricaDeviceIDListener.onError((AppMetricaDeviceIDListener.Reason)bz.l().get(paramAnonymousReason));
      }
    };
    this.k.a(this.p);
  }

  public void a(DeferredDeeplinkParametersListener paramDeferredDeeplinkParametersListener)
  {
    this.l.a(paramDeferredDeeplinkParametersListener);
  }

  public void a(IIdentifierCallback paramIIdentifierCallback)
  {
    this.k.a(paramIIdentifierCallback);
  }

  public void a(e parame)
  {
    this.g.a(parame);
  }

  public void a(String paramString)
  {
    this.l.a(paramString);
  }

  public c b(e parame)
  {
    return this.g.b(parame);
  }

  void b()
  {
    an localan = new an(Thread.getDefaultUncaughtExceptionHandler());
    localan.a(new bf(this.g.b(e.a("20799a27-fa80-4b36-b2db-0f8141f24180").a()), new j.a()
    {
      public boolean a(Throwable paramAnonymousThrowable)
      {
        String str = bw.a(paramAnonymousThrowable);
        return (!TextUtils.isEmpty(str)) && (str.contains("at " + "com.yandex.metrica" + "."));
      }
    }));
    this.i = localan;
    Thread.setDefaultUncaughtExceptionHandler(this.i);
  }

  public void b(boolean paramBoolean)
  {
    i().a(paramBoolean);
  }

  public void c(boolean paramBoolean)
  {
    i().setStatisticsSending(paramBoolean);
  }

  public String j()
  {
    return this.k.b();
  }

  public String k()
  {
    return this.k.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bz
 * JD-Core Version:    0.6.2
 */