package com.yandex.metrica.impl;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.impl.ob.h;
import com.yandex.metrica.impl.ob.k;
import com.yandex.metrica.impl.ob.l;
import com.yandex.metrica.impl.ob.l.a;
import com.yandex.metrica.impl.ob.od;
import com.yandex.metrica.impl.ob.u;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class bk
  implements ah.a
{
  private final x a;
  private final ah b;
  private final Object c = new Object();
  private final ExecutorService d = Executors.newSingleThreadExecutor(new od("YMM-RS"));

  public bk(x paramx)
  {
    this.a = paramx;
    this.b = paramx.a();
    this.b.a(this);
  }

  public Future<Void> a(d paramd)
  {
    ExecutorService localExecutorService = this.d;
    if (paramd.c());
    for (Object localObject = new a(paramd, (byte)0); ; localObject = new b(paramd, (byte)0))
      return localExecutorService.submit((Callable)localObject);
  }

  public void a()
  {
    synchronized (this.c)
    {
      this.c.notifyAll();
      return;
    }
  }

  private class a extends bk.b
  {
    private a(bk.d arg2)
    {
      super(locald, (byte)0);
    }

    public Void a()
    {
      bk.a(bk.this).b();
      return super.a();
    }

    boolean b()
    {
      bk.d locald = this.b;
      Context localContext = bk.b(bk.this).b();
      Intent localIntent = bp.a(localContext);
      localIntent.putExtras(bk.d.b(locald).a(bk.d.a(locald).c()));
      try
      {
        localContext.startService(localIntent);
        label48: return false;
      }
      catch (Exception localException)
      {
        break label48;
      }
    }
  }

  private class b
    implements Callable<Void>
  {
    final bk.d b;
    boolean c;

    private b(bk.d arg2)
    {
      Object localObject;
      this.b = localObject;
      h.a().a(this, ay.class, l.a(new k()
      {
        public void a()
        {
          bk.b.this.c = true;
        }
      }).a());
    }

    private boolean a(IMetricaService paramIMetricaService, bk.d paramd)
    {
      try
      {
        bk.b(bk.this).a(paramIMetricaService, paramd.b(), bk.d.a(paramd));
        return true;
      }
      catch (RemoteException localRemoteException)
      {
      }
      return false;
    }

    public Void a()
    {
      int i = 0;
      try
      {
        boolean bool3;
        do
        {
          IMetricaService localIMetricaService = bk.a(bk.this).e();
          if (localIMetricaService != null)
          {
            boolean bool1 = a(localIMetricaService, this.b);
            if (bool1)
              return null;
          }
          boolean bool2 = b();
          i++;
          if (!bool2)
            break;
          bool3 = this.c;
        }
        while ((!bool3) && (i < 20));
        return null;
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
      finally
      {
        h.a().a(this);
      }
    }

    boolean b()
    {
      bk.a(bk.this).a();
      synchronized (bk.c(bk.this))
      {
        boolean bool = bk.a(bk.this).d();
        if (!bool);
        try
        {
          bk.c(bk.this).wait(500L, 0);
          return true;
        }
        catch (InterruptedException localInterruptedException)
        {
          while (true)
          {
            bk.c(bk.this).notifyAll();
            bk.d(bk.this).shutdownNow();
          }
        }
      }
    }
  }

  public static abstract interface c
  {
    public abstract i a(i parami);
  }

  public static class d
  {
    private i a;
    private bg b;
    private boolean c = false;
    private bk.c d;

    d(i parami, bg parambg)
    {
      this.a = parami;
      this.b = new bg(new u(parambg.h()), new CounterConfiguration(parambg.b()));
    }

    bg a()
    {
      return this.b;
    }

    d a(bk.c paramc)
    {
      this.d = paramc;
      return this;
    }

    d a(boolean paramBoolean)
    {
      this.c = paramBoolean;
      return this;
    }

    i b()
    {
      if (this.d != null)
        return this.d.a(this.a);
      return this.a;
    }

    boolean c()
    {
      return this.c;
    }

    public String toString()
    {
      return "ReportToSend{mReport=" + this.a + ", mEnvironment=" + this.b + ", mCrash=" + this.c + ", mAction=" + this.d + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bk
 * JD-Core Version:    0.6.2
 */