package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.yandex.metrica.impl.d;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class hw
  implements d
{
  public static final long a = TimeUnit.MINUTES.toMillis(1L);

  @SuppressLint({"StaticFieldLeak"})
  private static volatile hw b;
  private static final Object c = new Object();
  private final Context d;
  private hx e;
  private final WeakHashMap<Object, Object> f;
  private boolean g = false;
  private hp h;
  private mw i;
  private ie j;
  private a k;
  private Runnable l;
  private fm m;
  private fl n;
  private final iv o;
  private final jb p = new jb();
  private boolean q = false;

  private hw(Context paramContext)
  {
    this(paramContext, new hx(), new a(), fj.a(paramContext).g(), fj.a(paramContext).h(), (mw)hd.a.a(mw.class).a(paramContext).a());
  }

  hw(Context paramContext, hx paramhx, a parama, fm paramfm, fl paramfl, mw parammw)
  {
    this.d = paramContext;
    this.e = paramhx;
    this.f = new WeakHashMap();
    this.k = parama;
    this.m = paramfm;
    this.n = paramfl;
    this.i = parammw;
    this.o = new iv(this.p.a());
  }

  // ERROR //
  public static Location a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +55 -> 56
    //   4: invokestatic 145	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: iconst_0
    //   11: aload_0
    //   12: arraylength
    //   13: invokevirtual 149	android/os/Parcel:unmarshall	([BII)V
    //   16: aload_1
    //   17: iconst_0
    //   18: invokevirtual 153	android/os/Parcel:setDataPosition	(I)V
    //   21: aload_1
    //   22: ldc 155
    //   24: invokevirtual 161	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   27: invokevirtual 165	android/os/Parcel:readValue	(Ljava/lang/ClassLoader;)Ljava/lang/Object;
    //   30: checkcast 155	android/location/Location
    //   33: astore 4
    //   35: aload_1
    //   36: invokevirtual 168	android/os/Parcel:recycle	()V
    //   39: aload 4
    //   41: areturn
    //   42: astore_3
    //   43: aload_1
    //   44: invokevirtual 168	android/os/Parcel:recycle	()V
    //   47: aconst_null
    //   48: areturn
    //   49: astore_2
    //   50: aload_1
    //   51: invokevirtual 168	android/os/Parcel:recycle	()V
    //   54: aload_2
    //   55: athrow
    //   56: aconst_null
    //   57: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   8	35	42	java/lang/Exception
    //   8	35	49	finally
  }

  public static hw a(Context paramContext)
  {
    if (b == null);
    synchronized (c)
    {
      if (b == null)
        b = new hw(paramContext.getApplicationContext());
      return b;
    }
  }

  // ERROR //
  public static byte[] a(Location paramLocation)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +25 -> 28
    //   6: invokestatic 145	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_2
    //   10: aload_2
    //   11: aload_0
    //   12: invokevirtual 187	android/os/Parcel:writeValue	(Ljava/lang/Object;)V
    //   15: aload_2
    //   16: invokevirtual 191	android/os/Parcel:marshall	()[B
    //   19: astore 5
    //   21: aload 5
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 168	android/os/Parcel:recycle	()V
    //   28: aload_1
    //   29: areturn
    //   30: astore 4
    //   32: aload_2
    //   33: invokevirtual 168	android/os/Parcel:recycle	()V
    //   36: aconst_null
    //   37: areturn
    //   38: astore_3
    //   39: aload_2
    //   40: invokevirtual 168	android/os/Parcel:recycle	()V
    //   43: aload_3
    //   44: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   10	21	30	java/lang/Exception
    //   10	21	38	finally
  }

  private void c()
  {
    this.e.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          synchronized (hw.this)
          {
            if (hw.a(hw.this) != null)
              hw.a(hw.this).a();
            return;
          }
        }
        catch (Exception localException)
        {
        }
      }
    });
  }

  private void d()
  {
    if (this.q)
      if ((!this.g) || (this.f.isEmpty()))
      {
        e();
        this.q = false;
      }
    while ((!this.g) || (this.f.isEmpty()))
      return;
    f();
    this.q = true;
  }

  private void e()
  {
    if (this.j != null)
      this.j.f();
    h();
  }

  private void f()
  {
    if (this.j == null)
      this.j = this.k.a(this.d, this.e.a(), this.i, this.h, this.m, this.n, this.o);
    this.j.e();
    g();
    c();
  }

  private void g()
  {
    if (this.l == null)
    {
      this.l = new Runnable()
      {
        public void run()
        {
          ie localie = hw.a(hw.this);
          if (localie != null)
            localie.d();
          hw.b(hw.this);
        }
      };
      i();
    }
  }

  private void h()
  {
    if (this.l != null)
      this.e.a(this.l);
  }

  private void i()
  {
    this.e.a(this.l, a);
  }

  public Location a()
  {
    ie localie = this.j;
    if (localie == null)
      return null;
    return localie.b();
  }

  public void a(mw parammw, hp paramhp)
  {
    this.i = parammw;
    this.h = paramhp;
    this.p.a(parammw);
    this.o.a(this.p.a());
    this.e.execute(new Runnable()
    {
      public void run()
      {
        synchronized (hw.this)
        {
          if (hw.a(hw.this) != null)
            hw.a(hw.this).a(hw.c(hw.this), hw.d(hw.this));
          return;
        }
      }
    });
  }

  public void a(Object paramObject)
  {
    try
    {
      this.f.put(paramObject, null);
      d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.g != paramBoolean)
      {
        this.g = paramBoolean;
        this.p.a(paramBoolean);
        this.o.a(this.p.a());
        d();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Location b()
  {
    ie localie = this.j;
    if (localie == null)
      return null;
    return localie.c();
  }

  public void b(Object paramObject)
  {
    try
    {
      this.f.remove(paramObject);
      d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  static class a
  {
    public ie a(Context paramContext, Looper paramLooper, mw parammw, hp paramhp, fm paramfm, fl paramfl, iv paramiv)
    {
      return new ie(paramContext, parammw, paramLooper, paramhp, paramfm, paramfl, paramiv);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hw
 * JD-Core Version:    0.6.2
 */