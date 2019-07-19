package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.g.a;
import java.util.ArrayDeque;

public abstract class g<I extends e, O extends f, E extends Exception>
  implements c<I, O, E>
{
  private final Thread a;
  private final Object b = new Object();
  private final ArrayDeque<I> c = new ArrayDeque();
  private final ArrayDeque<O> d = new ArrayDeque();
  private final I[] e;
  private final O[] f;
  private int g;
  private int h;
  private I i;
  private E j;
  private boolean k;
  private boolean l;
  private int m;

  protected g(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.e = paramArrayOfI;
    this.g = paramArrayOfI.length;
    for (int i1 = 0; i1 < this.g; i1++)
      this.e[i1] = g();
    this.f = paramArrayOfO;
    this.h = paramArrayOfO.length;
    while (n < this.h)
    {
      this.f[n] = h();
      n++;
    }
    this.a = new Thread()
    {
      public void run()
      {
        g.a(g.this);
      }
    };
    this.a.start();
  }

  private void b(I paramI)
  {
    paramI.a();
    e[] arrayOfe = this.e;
    int n = this.g;
    this.g = (n + 1);
    arrayOfe[n] = paramI;
  }

  private void b(O paramO)
  {
    paramO.a();
    f[] arrayOff = this.f;
    int n = this.h;
    this.h = (n + 1);
    arrayOff[n] = paramO;
  }

  private void i()
    throws Exception
  {
    if (this.j != null)
      throw this.j;
  }

  private void j()
  {
    if (m())
      this.b.notify();
  }

  private void k()
  {
    try
    {
      boolean bool;
      do
        bool = l();
      while (bool);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IllegalStateException(localInterruptedException);
    }
  }

  // ERROR //
  private boolean l()
    throws InterruptedException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/google/android/exoplayer2/c/g:b	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 111	com/google/android/exoplayer2/c/g:l	Z
    //   11: ifne +25 -> 36
    //   14: aload_0
    //   15: invokespecial 93	com/google/android/exoplayer2/c/g:m	()Z
    //   18: ifne +18 -> 36
    //   21: aload_0
    //   22: getfield 42	com/google/android/exoplayer2/c/g:b	Ljava/lang/Object;
    //   25: invokevirtual 114	java/lang/Object:wait	()V
    //   28: goto -21 -> 7
    //   31: astore_2
    //   32: aload_1
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    //   36: aload_0
    //   37: getfield 111	com/google/android/exoplayer2/c/g:l	Z
    //   40: ifeq +7 -> 47
    //   43: aload_1
    //   44: monitorexit
    //   45: iconst_0
    //   46: ireturn
    //   47: aload_0
    //   48: getfield 47	com/google/android/exoplayer2/c/g:c	Ljava/util/ArrayDeque;
    //   51: invokevirtual 118	java/util/ArrayDeque:removeFirst	()Ljava/lang/Object;
    //   54: checkcast 80	com/google/android/exoplayer2/c/e
    //   57: astore_3
    //   58: aload_0
    //   59: getfield 58	com/google/android/exoplayer2/c/g:f	[Lcom/google/android/exoplayer2/c/f;
    //   62: astore 4
    //   64: iconst_m1
    //   65: aload_0
    //   66: getfield 60	com/google/android/exoplayer2/c/g:h	I
    //   69: iadd
    //   70: istore 5
    //   72: aload_0
    //   73: iload 5
    //   75: putfield 60	com/google/android/exoplayer2/c/g:h	I
    //   78: aload 4
    //   80: iload 5
    //   82: aaload
    //   83: astore 6
    //   85: aload_0
    //   86: getfield 120	com/google/android/exoplayer2/c/g:k	Z
    //   89: istore 7
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 120	com/google/android/exoplayer2/c/g:k	Z
    //   96: aload_1
    //   97: monitorexit
    //   98: aload_3
    //   99: invokevirtual 122	com/google/android/exoplayer2/c/e:c	()Z
    //   102: ifeq +40 -> 142
    //   105: aload 6
    //   107: iconst_4
    //   108: invokevirtual 125	com/google/android/exoplayer2/c/f:b	(I)V
    //   111: aload_0
    //   112: getfield 42	com/google/android/exoplayer2/c/g:b	Ljava/lang/Object;
    //   115: astore 11
    //   117: aload 11
    //   119: monitorenter
    //   120: aload_0
    //   121: getfield 120	com/google/android/exoplayer2/c/g:k	Z
    //   124: ifeq +104 -> 228
    //   127: aload 6
    //   129: invokevirtual 127	com/google/android/exoplayer2/c/f:e	()V
    //   132: aload_0
    //   133: aload_3
    //   134: invokespecial 129	com/google/android/exoplayer2/c/g:b	(Lcom/google/android/exoplayer2/c/e;)V
    //   137: aload 11
    //   139: monitorexit
    //   140: iconst_1
    //   141: ireturn
    //   142: aload_3
    //   143: invokevirtual 132	com/google/android/exoplayer2/c/e:j_	()Z
    //   146: ifeq +10 -> 156
    //   149: aload 6
    //   151: ldc 133
    //   153: invokevirtual 125	com/google/android/exoplayer2/c/f:b	(I)V
    //   156: aload_0
    //   157: aload_0
    //   158: aload_3
    //   159: aload 6
    //   161: iload 7
    //   163: invokevirtual 136	com/google/android/exoplayer2/c/g:a	(Lcom/google/android/exoplayer2/c/e;Lcom/google/android/exoplayer2/c/f;Z)Ljava/lang/Exception;
    //   166: putfield 90	com/google/android/exoplayer2/c/g:j	Ljava/lang/Exception;
    //   169: aload_0
    //   170: getfield 90	com/google/android/exoplayer2/c/g:j	Ljava/lang/Exception;
    //   173: ifnull -62 -> 111
    //   176: aload_0
    //   177: getfield 42	com/google/android/exoplayer2/c/g:b	Ljava/lang/Object;
    //   180: astore 9
    //   182: aload 9
    //   184: monitorenter
    //   185: aload 9
    //   187: monitorexit
    //   188: iconst_0
    //   189: ireturn
    //   190: astore 13
    //   192: aload_0
    //   193: aload_0
    //   194: aload 13
    //   196: invokevirtual 139	com/google/android/exoplayer2/c/g:a	(Ljava/lang/Throwable;)Ljava/lang/Exception;
    //   199: putfield 90	com/google/android/exoplayer2/c/g:j	Ljava/lang/Exception;
    //   202: goto -33 -> 169
    //   205: astore 8
    //   207: aload_0
    //   208: aload_0
    //   209: aload 8
    //   211: invokevirtual 139	com/google/android/exoplayer2/c/g:a	(Ljava/lang/Throwable;)Ljava/lang/Exception;
    //   214: putfield 90	com/google/android/exoplayer2/c/g:j	Ljava/lang/Exception;
    //   217: goto -48 -> 169
    //   220: astore 10
    //   222: aload 9
    //   224: monitorexit
    //   225: aload 10
    //   227: athrow
    //   228: aload 6
    //   230: invokevirtual 140	com/google/android/exoplayer2/c/f:j_	()Z
    //   233: ifeq +29 -> 262
    //   236: aload_0
    //   237: iconst_1
    //   238: aload_0
    //   239: getfield 142	com/google/android/exoplayer2/c/g:m	I
    //   242: iadd
    //   243: putfield 142	com/google/android/exoplayer2/c/g:m	I
    //   246: aload 6
    //   248: invokevirtual 127	com/google/android/exoplayer2/c/f:e	()V
    //   251: goto -119 -> 132
    //   254: astore 12
    //   256: aload 11
    //   258: monitorexit
    //   259: aload 12
    //   261: athrow
    //   262: aload 6
    //   264: aload_0
    //   265: getfield 142	com/google/android/exoplayer2/c/g:m	I
    //   268: putfield 144	com/google/android/exoplayer2/c/f:b	I
    //   271: aload_0
    //   272: iconst_0
    //   273: putfield 142	com/google/android/exoplayer2/c/g:m	I
    //   276: aload_0
    //   277: getfield 49	com/google/android/exoplayer2/c/g:d	Ljava/util/ArrayDeque;
    //   280: aload 6
    //   282: invokevirtual 148	java/util/ArrayDeque:addLast	(Ljava/lang/Object;)V
    //   285: goto -153 -> 132
    //
    // Exception table:
    //   from	to	target	type
    //   7	28	31	finally
    //   32	34	31	finally
    //   36	45	31	finally
    //   47	98	31	finally
    //   156	169	190	java/lang/RuntimeException
    //   156	169	205	java/lang/OutOfMemoryError
    //   185	188	220	finally
    //   222	225	220	finally
    //   120	132	254	finally
    //   132	140	254	finally
    //   228	251	254	finally
    //   256	259	254	finally
    //   262	285	254	finally
  }

  private boolean m()
  {
    return (!this.c.isEmpty()) && (this.h > 0);
  }

  protected abstract E a(I paramI, O paramO, boolean paramBoolean);

  protected abstract E a(Throwable paramThrowable);

  protected final void a(int paramInt)
  {
    int n = 0;
    if (this.g == this.e.length);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      e[] arrayOfe = this.e;
      int i1 = arrayOfe.length;
      while (n < i1)
      {
        arrayOfe[n].e(paramInt);
        n++;
      }
    }
  }

  public final void a(I paramI)
    throws Exception
  {
    while (true)
    {
      synchronized (this.b)
      {
        i();
        if (paramI == this.i)
        {
          bool = true;
          a.a(bool);
          this.c.addLast(paramI);
          j();
          this.i = null;
          return;
        }
      }
      boolean bool = false;
    }
  }

  protected void a(O paramO)
  {
    synchronized (this.b)
    {
      b(paramO);
      j();
      return;
    }
  }

  public final void c()
  {
    synchronized (this.b)
    {
      this.k = true;
      this.m = 0;
      if (this.i != null)
      {
        b(this.i);
        this.i = null;
      }
      if (!this.c.isEmpty())
        b((e)this.c.removeFirst());
    }
    while (!this.d.isEmpty())
      ((f)this.d.removeFirst()).e();
  }

  public void d()
  {
    synchronized (this.b)
    {
      this.l = true;
      this.b.notify();
    }
    try
    {
      this.a.join();
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
    }
  }

  public final I e()
    throws Exception
  {
    while (true)
    {
      synchronized (this.b)
      {
        i();
        if (this.i == null)
        {
          bool = true;
          a.b(bool);
          if (this.g == 0)
          {
            localObject3 = null;
            this.i = localObject3;
            e locale = this.i;
            return locale;
          }
          e[] arrayOfe = this.e;
          int n = -1 + this.g;
          this.g = n;
          Object localObject3 = arrayOfe[n];
        }
      }
      boolean bool = false;
    }
  }

  public final O f()
    throws Exception
  {
    synchronized (this.b)
    {
      i();
      if (this.d.isEmpty())
        return null;
      f localf = (f)this.d.removeFirst();
      return localf;
    }
  }

  protected abstract I g();

  protected abstract O h();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g
 * JD-Core Version:    0.6.2
 */