package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

public class eb
{
  private final ab a;
  private final ei b;
  private final ed c;
  private long d;
  private long e;
  private AtomicLong f;
  private boolean g;
  private volatile a h;
  private long i;
  private long j;
  private om k;

  eb(ab paramab, ei paramei, ed paramed)
  {
    this(paramab, paramei, paramed, new om());
  }

  eb(ab paramab, ei paramei, ed paramed, om paramom)
  {
    this.a = paramab;
    this.b = paramei;
    this.c = paramed;
    this.k = paramom;
    this.e = this.c.b(this.k.c());
    this.d = this.c.a(-1L);
    this.f = new AtomicLong(this.c.c(0L));
    this.g = this.c.a(true);
    this.i = this.c.d(0L);
    this.j = this.c.e(this.i - this.e);
  }

  private long d(long paramLong)
  {
    return TimeUnit.MILLISECONDS.toSeconds(paramLong - this.e);
  }

  // ERROR //
  private a h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/yandex/metrica/impl/ob/eb:h	Lcom/yandex/metrica/impl/ob/eb$a;
    //   4: ifnonnull +69 -> 73
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 94	com/yandex/metrica/impl/ob/eb:h	Lcom/yandex/metrica/impl/ob/eb$a;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +56 -> 71
    //   18: aload_0
    //   19: getfield 36	com/yandex/metrica/impl/ob/eb:a	Lcom/yandex/metrica/impl/ob/ab;
    //   22: invokevirtual 100	com/yandex/metrica/impl/ob/ab:m	()Lcom/yandex/metrica/impl/ob/fh;
    //   25: aload_0
    //   26: invokevirtual 101	com/yandex/metrica/impl/ob/eb:c	()J
    //   29: aload_0
    //   30: invokevirtual 104	com/yandex/metrica/impl/ob/eb:a	()Lcom/yandex/metrica/impl/ob/ek;
    //   33: invokevirtual 109	com/yandex/metrica/impl/ob/fh:b	(JLcom/yandex/metrica/impl/ob/ek;)Landroid/content/ContentValues;
    //   36: ldc 111
    //   38: invokevirtual 117	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 4
    //   43: aload 4
    //   45: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifne +23 -> 71
    //   51: aload_0
    //   52: new 125	com/yandex/metrica/impl/ob/eb$a
    //   55: dup
    //   56: new 127	org/json/JSONObject
    //   59: dup
    //   60: aload 4
    //   62: invokespecial 130	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   65: invokespecial 133	com/yandex/metrica/impl/ob/eb$a:<init>	(Lorg/json/JSONObject;)V
    //   68: putfield 94	com/yandex/metrica/impl/ob/eb:h	Lcom/yandex/metrica/impl/ob/eb$a;
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_0
    //   74: getfield 94	com/yandex/metrica/impl/ob/eb:h	Lcom/yandex/metrica/impl/ob/eb$a;
    //   77: areturn
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_3
    //   84: goto -13 -> 71
    //
    // Exception table:
    //   from	to	target	type
    //   9	14	78	finally
    //   18	71	78	finally
    //   71	73	78	finally
    //   79	81	78	finally
    //   18	71	83	java/lang/Exception
  }

  protected ek a()
  {
    return this.c.a();
  }

  public void a(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      this.b.a(this.g).h();
    }
  }

  boolean a(long paramLong)
  {
    int m;
    a locala;
    if (this.d >= 0L)
    {
      m = 1;
      locala = h();
      if (locala == null)
        break label83;
    }
    label81: label83: for (boolean bool = locala.a(this.a.l()); ; bool = false)
    {
      if (!a(paramLong, this.k.c()));
      for (int n = 1; ; n = 0)
      {
        if ((m == 0) || (!bool) || (n == 0))
          break label81;
        return true;
        m = 0;
        break;
      }
      return false;
    }
  }

  boolean a(long paramLong1, long paramLong2)
  {
    long l1 = this.i;
    if (TimeUnit.MILLISECONDS.toSeconds(paramLong2) < l1);
    for (int m = 1; ; m = 0)
    {
      long l2 = TimeUnit.MILLISECONDS.toSeconds(paramLong1) - l1;
      long l3 = d(paramLong1);
      boolean bool1;
      if ((m == 0) && (l2 < b()))
      {
        boolean bool2 = l3 < ee.c;
        bool1 = false;
        if (bool2);
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }

  protected int b()
  {
    return this.c.a(this.a.l().O());
  }

  void b(long paramLong)
  {
    ei localei = this.b;
    long l = TimeUnit.MILLISECONDS.toSeconds(paramLong);
    this.i = l;
    localei.b(l).h();
  }

  public long c()
  {
    return this.d;
  }

  long c(long paramLong)
  {
    ei localei = this.b;
    long l = d(paramLong);
    this.j = l;
    localei.c(l);
    return this.j;
  }

  long d()
  {
    return Math.max(this.i - TimeUnit.MILLISECONDS.toSeconds(this.e), this.j);
  }

  void e()
  {
    try
    {
      this.b.a();
      this.h = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long f()
  {
    long l = this.f.getAndIncrement();
    this.b.a(this.f.get()).h();
    return l;
  }

  boolean g()
  {
    return (this.g) && (c() > 0L);
  }

  public String toString()
  {
    return "Session{mId=" + this.d + ", mInitTime=" + this.e + ", mCurrentReportId=" + this.f + ", mSessionRequestParams=" + this.h + ", mSleepStartSeconds=" + this.i + '}';
  }

  static class a
  {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final int g;

    a(JSONObject paramJSONObject)
    {
      this.a = paramJSONObject.optString("analyticsSdkVersionName", null);
      this.b = paramJSONObject.optString("kitBuildNumber", null);
      this.c = paramJSONObject.optString("appVer", null);
      this.d = paramJSONObject.optString("appBuild", null);
      this.e = paramJSONObject.optString("osVer", null);
      this.f = paramJSONObject.optInt("osApiLev", -1);
      this.g = paramJSONObject.optInt("attribution_id", 0);
    }

    boolean a(lr paramlr)
    {
      return (TextUtils.equals(paramlr.h(), this.a)) && (TextUtils.equals(paramlr.i(), this.b)) && (TextUtils.equals(paramlr.p(), this.c)) && (TextUtils.equals(paramlr.o(), this.d)) && (TextUtils.equals(paramlr.m(), this.e)) && (this.f == paramlr.n()) && (this.g == paramlr.R());
    }

    public String toString()
    {
      return "SessionRequestParams{mKitVersionName='" + this.a + '\'' + ", mKitBuildNumber='" + this.b + '\'' + ", mAppVersion='" + this.c + '\'' + ", mAppBuild='" + this.d + '\'' + ", mOsVersion='" + this.e + '\'' + ", mApiLevel=" + this.f + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.eb
 * JD-Core Version:    0.6.2
 */