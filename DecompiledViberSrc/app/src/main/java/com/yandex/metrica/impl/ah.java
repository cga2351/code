package com.yandex.metrica.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.IMetricaService.Stub;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class ah
{
  public static final long a = TimeUnit.SECONDS.toMillis(10L);
  private final Context b;
  private final Handler c;
  private boolean d;
  private final List<a> e = new CopyOnWriteArrayList();
  private volatile IMetricaService f = null;
  private final Object g = new Object();
  private final Runnable h = new Runnable()
  {
    public void run()
    {
      ah.a(ah.this);
    }
  };
  private final ServiceConnection i = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      ah.a(ah.this, IMetricaService.Stub.asInterface(paramAnonymousIBinder));
      ah.b(ah.this);
    }

    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      ah.a(ah.this, null);
      ah.c(ah.this);
    }
  };

  public ah(Context paramContext, Handler paramHandler)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramHandler;
    this.d = false;
  }

  // ERROR //
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/yandex/metrica/impl/ah:b	Landroid/content/Context;
    //   6: ifnull +28 -> 34
    //   9: aload_0
    //   10: invokevirtual 105	com/yandex/metrica/impl/ah:d	()Z
    //   13: istore_2
    //   14: iload_2
    //   15: ifeq +19 -> 34
    //   18: aload_0
    //   19: getfield 72	com/yandex/metrica/impl/ah:b	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 64	com/yandex/metrica/impl/ah:i	Landroid/content/ServiceConnection;
    //   26: invokevirtual 109	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 50	com/yandex/metrica/impl/ah:f	Lcom/yandex/metrica/IMetricaService;
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 50	com/yandex/metrica/impl/ah:f	Lcom/yandex/metrica/IMetricaService;
    //   39: aload_0
    //   40: invokespecial 101	com/yandex/metrica/impl/ah:i	()V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_3
    //   52: goto -18 -> 34
    //
    // Exception table:
    //   from	to	target	type
    //   2	14	46	finally
    //   18	34	46	finally
    //   34	43	46	finally
    //   18	34	51	java/lang/Exception
  }

  private void i()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      localIterator.next();
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/yandex/metrica/impl/ah:f	Lcom/yandex/metrica/IMetricaService;
    //   6: ifnonnull +25 -> 31
    //   9: aload_0
    //   10: getfield 72	com/yandex/metrica/impl/ah:b	Landroid/content/Context;
    //   13: invokestatic 114	com/yandex/metrica/impl/bp:a	(Landroid/content/Context;)Landroid/content/Intent;
    //   16: astore_2
    //   17: aload_0
    //   18: getfield 72	com/yandex/metrica/impl/ah:b	Landroid/content/Context;
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 64	com/yandex/metrica/impl/ah:i	Landroid/content/ServiceConnection;
    //   26: iconst_1
    //   27: invokevirtual 118	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: astore_3
    //   40: goto -9 -> 31
    //
    // Exception table:
    //   from	to	target	type
    //   2	17	34	finally
    //   17	31	34	finally
    //   17	31	39	java/lang/Exception
  }

  void a(Handler paramHandler)
  {
    synchronized (this.g)
    {
      paramHandler.removeCallbacks(this.h);
      if (!this.d)
        paramHandler.postDelayed(this.h, a);
      return;
    }
  }

  public void a(a parama)
  {
    this.e.add(parama);
  }

  public void b()
  {
    a(this.c);
  }

  void c()
  {
    try
    {
      this.c.removeCallbacks(this.h);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean d()
  {
    return this.f != null;
  }

  public IMetricaService e()
  {
    return this.f;
  }

  public void f()
  {
    synchronized (this.g)
    {
      this.d = true;
      c();
      return;
    }
  }

  public void g()
  {
    this.d = false;
    b();
  }

  static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ah
 * JD-Core Version:    0.6.2
 */