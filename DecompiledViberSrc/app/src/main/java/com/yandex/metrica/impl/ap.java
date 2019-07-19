package com.yandex.metrica.impl;

import android.content.Context;
import com.yandex.metrica.impl.ob.il;
import com.yandex.metrica.impl.ob.im;
import com.yandex.metrica.impl.ob.io;
import com.yandex.metrica.impl.ob.lx;
import com.yandex.metrica.impl.ob.y;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class ap extends Thread
{
  private final Executor a;
  private Executor b;
  private final BlockingQueue<b> c = new LinkedBlockingQueue();
  private final Object d = new Object();
  private final Object e = new Object();
  private volatile b f;
  private au g;
  private im h;
  private String i;
  private volatile boolean j = true;

  public ap(Context paramContext, y paramy, Executor paramExecutor)
  {
    this.a = paramExecutor;
    this.b = new il();
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "NetworkTaskQueue";
    arrayOfObject[1] = paramy.toString();
    this.i = String.format(localLocale, "[%s:%s]", arrayOfObject);
    this.g = new au();
    this.h = new im(paramContext);
  }

  public void a()
  {
    synchronized (this.e)
    {
      this.j = false;
      b localb = this.f;
      if (localb != null)
        localb.a.z();
      this.c.clear();
      interrupt();
      return;
    }
  }

  public void a(as paramas)
  {
    while (true)
    {
      synchronized (this.d)
      {
        b localb = new b(paramas, (byte)0);
        if (!this.c.contains(localb))
        {
          boolean bool = localb.equals(this.f);
          k = 0;
          if (!bool)
          {
            if (k == 0)
              this.c.offer(localb);
            return;
          }
        }
      }
      int k = 1;
    }
  }

  Executor b(as paramas)
  {
    if (paramas.q())
      return this.a;
    return this.b;
  }

  void c(as paramas)
    throws InterruptedException
  {
    lx locallx = paramas.d();
    int k = 0;
    boolean bool2;
    boolean bool1;
    if (this.h.a())
    {
      bool2 = paramas.b();
      io localio = paramas.e();
      if ((!bool2) || (localio.b()))
        break label168;
      bool2 = false;
      bool1 = false;
    }
    while (true)
      if ((this.j) && (bool2))
      {
        this.g.a(paramas);
        bool1 = paramas.c();
        paramas.a(bool1);
        if ((!bool1) && (paramas.w()));
        for (bool2 = true; ; bool2 = false)
        {
          if (!bool2)
            break label114;
          Thread.sleep(paramas.s());
          break;
        }
      }
      else
      {
        label114: paramas.h();
        k = 1;
        while ((!this.j) || (bool1) || (!locallx.b()))
        {
          if (k == 0)
          {
            paramas.j();
            paramas.h();
          }
          return;
          locallx.c();
          bool1 = false;
        }
        break;
        label168: bool1 = false;
      }
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/yandex/metrica/impl/ap:j	Z
    //   4: ifeq +156 -> 160
    //   7: aload_0
    //   8: getfield 40	com/yandex/metrica/impl/ap:e	Ljava/lang/Object;
    //   11: astore 7
    //   13: aload 7
    //   15: monitorenter
    //   16: aload 7
    //   18: monitorexit
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 33	com/yandex/metrica/impl/ap:c	Ljava/util/concurrent/BlockingQueue;
    //   24: invokeinterface 171 1 0
    //   29: checkcast 89	com/yandex/metrica/impl/ap$b
    //   32: putfield 87	com/yandex/metrica/impl/ap:f	Lcom/yandex/metrica/impl/ap$b;
    //   35: aload_0
    //   36: getfield 87	com/yandex/metrica/impl/ap:f	Lcom/yandex/metrica/impl/ap$b;
    //   39: getfield 92	com/yandex/metrica/impl/ap$b:a	Lcom/yandex/metrica/impl/as;
    //   42: astore 9
    //   44: aload_0
    //   45: aload 9
    //   47: invokevirtual 173	com/yandex/metrica/impl/ap:b	(Lcom/yandex/metrica/impl/as;)Ljava/util/concurrent/Executor;
    //   50: new 175	com/yandex/metrica/impl/ap$a
    //   53: dup
    //   54: aload_0
    //   55: aload 9
    //   57: iconst_0
    //   58: invokespecial 178	com/yandex/metrica/impl/ap$a:<init>	(Lcom/yandex/metrica/impl/ap;Lcom/yandex/metrica/impl/as;B)V
    //   61: invokeinterface 184 2 0
    //   66: aload_0
    //   67: getfield 40	com/yandex/metrica/impl/ap:e	Ljava/lang/Object;
    //   70: astore 10
    //   72: aload 10
    //   74: monitorenter
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 87	com/yandex/metrica/impl/ap:f	Lcom/yandex/metrica/impl/ap$b;
    //   80: aload 10
    //   82: monitorexit
    //   83: goto -83 -> 0
    //   86: astore 11
    //   88: aload 10
    //   90: monitorexit
    //   91: aload 11
    //   93: athrow
    //   94: astore 8
    //   96: aload 7
    //   98: monitorexit
    //   99: aload 8
    //   101: athrow
    //   102: astore 4
    //   104: invokestatic 188	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   107: invokevirtual 189	java/lang/Thread:interrupt	()V
    //   110: aload_0
    //   111: getfield 40	com/yandex/metrica/impl/ap:e	Ljava/lang/Object;
    //   114: astore 5
    //   116: aload 5
    //   118: monitorenter
    //   119: aload_0
    //   120: aconst_null
    //   121: putfield 87	com/yandex/metrica/impl/ap:f	Lcom/yandex/metrica/impl/ap$b;
    //   124: aload 5
    //   126: monitorexit
    //   127: goto -127 -> 0
    //   130: astore 6
    //   132: aload 5
    //   134: monitorexit
    //   135: aload 6
    //   137: athrow
    //   138: astore_1
    //   139: aload_0
    //   140: getfield 40	com/yandex/metrica/impl/ap:e	Ljava/lang/Object;
    //   143: astore_2
    //   144: aload_2
    //   145: monitorenter
    //   146: aload_0
    //   147: aconst_null
    //   148: putfield 87	com/yandex/metrica/impl/ap:f	Lcom/yandex/metrica/impl/ap$b;
    //   151: aload_2
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    //   155: astore_3
    //   156: aload_2
    //   157: monitorexit
    //   158: aload_3
    //   159: athrow
    //   160: return
    //
    // Exception table:
    //   from	to	target	type
    //   75	83	86	finally
    //   88	91	86	finally
    //   16	19	94	finally
    //   96	99	94	finally
    //   7	16	102	java/lang/InterruptedException
    //   19	66	102	java/lang/InterruptedException
    //   99	102	102	java/lang/InterruptedException
    //   119	127	130	finally
    //   132	135	130	finally
    //   7	16	138	finally
    //   19	66	138	finally
    //   99	102	138	finally
    //   104	110	138	finally
    //   146	153	155	finally
    //   156	158	155	finally
  }

  private class a
    implements Runnable
  {
    private final as b;

    private a(as arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void run()
    {
      try
      {
        ap.this.c(this.b);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
      }
    }
  }

  private static class b
  {
    final as a;
    private final String b;

    private b(as paramas)
    {
      this.a = paramas;
      this.b = paramas.a();
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject)
        return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      b localb = (b)paramObject;
      return this.b.equals(localb.b);
    }

    public int hashCode()
    {
      return this.b.hashCode();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ap
 * JD-Core Version:    0.6.2
 */