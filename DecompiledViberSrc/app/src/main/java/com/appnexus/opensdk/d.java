package com.appnexus.opensdk;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.appnexus.opensdk.ut.UTAdRequester;
import com.appnexus.opensdk.utils.Clog;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class d
{
  private ScheduledExecutorService a;
  private int b = -1;
  private final b c;
  private long d = -1L;
  private long e = -1L;
  private final b f;
  private UTAdRequester g;
  private c h = c.a;

  d(b paramb)
  {
    this.f = paramb;
    this.c = new b(this);
  }

  private void e()
  {
    if (this.a == null)
      this.a = Executors.newScheduledThreadPool(4);
  }

  // ERROR //
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/appnexus/opensdk/d:a	Ljava/util/concurrent/ScheduledExecutorService;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 57	com/appnexus/opensdk/d:a	Ljava/util/concurrent/ScheduledExecutorService;
    //   12: invokeinterface 71 1 0
    //   17: pop
    //   18: aload_0
    //   19: getfield 57	com/appnexus/opensdk/d:a	Ljava/util/concurrent/ScheduledExecutorService;
    //   22: aload_0
    //   23: getfield 26	com/appnexus/opensdk/d:b	I
    //   26: i2l
    //   27: getstatic 77	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   30: invokeinterface 81 4 0
    //   35: pop
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 57	com/appnexus/opensdk/d:a	Ljava/util/concurrent/ScheduledExecutorService;
    //   41: return
    //   42: astore_3
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 57	com/appnexus/opensdk/d:a	Ljava/util/concurrent/ScheduledExecutorService;
    //   48: return
    //   49: astore_2
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 57	com/appnexus/opensdk/d:a	Ljava/util/concurrent/ScheduledExecutorService;
    //   55: aload_2
    //   56: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   18	36	42	java/lang/InterruptedException
    //   18	36	49	finally
  }

  void a()
  {
    if (this.g != null)
    {
      this.g.cancel();
      this.g = null;
    }
    f();
    Clog.d(Clog.baseLogTag, Clog.getString(R.string.stop));
    this.e = System.currentTimeMillis();
    this.h = c.a;
  }

  void a(int paramInt)
  {
    if (this.b != paramInt);
    for (int i = 1; ; i = 0)
    {
      this.b = paramInt;
      if ((i != 0) && (!this.h.equals(c.a)))
      {
        Clog.d(Clog.baseLogTag, "AdFetcher refresh period changed to " + this.b);
        Clog.d(Clog.baseLogTag, "Resetting AdFetcher");
        a();
        b();
      }
      return;
    }
  }

  void b()
  {
    long l = 0L;
    Clog.d(Clog.baseLogTag, Clog.getString(R.string.start));
    e();
    switch (1.a[this.h.ordinal()])
    {
    default:
      return;
    case 1:
      if (this.b <= 0)
      {
        Clog.v(Clog.baseLogTag, Clog.getString(R.string.fetcher_start_single));
        this.a.schedule(new a(null), l, TimeUnit.SECONDS);
        this.h = c.b;
        return;
      }
      Clog.v(Clog.baseLogTag, Clog.getString(R.string.fetcher_start_auto));
      int i = this.b;
      if ((this.e != -1L) && (this.d != -1L))
        l = Math.min(i, Math.max(l, i - (this.e - this.d)));
      Clog.v(Clog.baseLogTag, Clog.getString(R.string.request_delayed_by_x_ms, l));
      this.a.scheduleAtFixedRate(new a(null), l, i, TimeUnit.MILLISECONDS);
      this.h = c.c;
      return;
    case 2:
    }
    Clog.v(Clog.baseLogTag, Clog.getString(R.string.fetcher_start_single));
    this.a.schedule(new a(null), l, TimeUnit.SECONDS);
  }

  void c()
  {
    this.d = -1L;
    this.e = -1L;
  }

  c d()
  {
    return this.h;
  }

  private class a
    implements Runnable
  {
    private a()
    {
    }

    public void run()
    {
      Clog.v(Clog.baseLogTag, Clog.getString(R.string.handler_message_pass));
      d.a(d.this).sendEmptyMessage(0);
    }
  }

  private static class b extends Handler
  {
    private final d a;

    b(d paramd)
    {
      this.a = paramd;
    }

    @SuppressLint({"NewApi"})
    public void handleMessage(Message paramMessage)
    {
      while (true)
      {
        d locald;
        try
        {
          locald = this.a;
          if (locald != null)
          {
            boolean bool = d.b(locald).isReadyToStart();
            if (bool);
          }
          else
          {
            return;
          }
          if (d.c(locald) != -1L)
            Clog.d(Clog.baseLogTag, Clog.getString(R.string.new_ad_since, Math.max(0, (int)(System.currentTimeMillis() - d.c(locald)))));
          d.a(locald, System.currentTimeMillis());
          MediaType localMediaType = d.b(locald).getMediaType();
          if ((localMediaType.equals(MediaType.NATIVE)) || (localMediaType.equals(MediaType.INTERSTITIAL)) || (localMediaType.equals(MediaType.BANNER)))
          {
            d.a(locald, new e(d.b(locald)));
            d.d(locald).execute();
            continue;
          }
        }
        finally
        {
        }
        d.b(locald).getAdDispatcher().a(ResultCode.INVALID_REQUEST);
      }
    }
  }

  static enum c
  {
    static
    {
      c[] arrayOfc = new c[3];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.d
 * JD-Core Version:    0.6.2
 */