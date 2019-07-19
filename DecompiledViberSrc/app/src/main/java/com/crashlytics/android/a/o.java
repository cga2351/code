package com.crashlytics.android.a;

import android.content.Context;
import c.a.a.a.a.b.g;
import c.a.a.a.a.d.f;
import c.a.a.a.a.e.e;
import c.a.a.a.a.g.b;
import c.a.a.a.c;
import c.a.a.a.l;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class o
  implements ac
{
  final ae a;
  f b;
  g c = new g();
  p d = new u();
  boolean e = true;
  boolean f = true;
  volatile int g = -1;
  boolean h = false;
  boolean i = false;
  private final c.a.a.a.i j;
  private final e k;
  private final Context l;
  private final z m;
  private final ScheduledExecutorService n;
  private final AtomicReference<ScheduledFuture<?>> o = new AtomicReference();
  private final r p;

  public o(c.a.a.a.i parami, Context paramContext, ScheduledExecutorService paramScheduledExecutorService, z paramz, e parame, ae paramae, r paramr)
  {
    this.j = parami;
    this.l = paramContext;
    this.n = paramScheduledExecutorService;
    this.m = paramz;
    this.k = parame;
    this.a = paramae;
    this.p = paramr;
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 84	com/crashlytics/android/a/o:b	Lc/a/a/a/a/d/f;
    //   4: ifnonnull +13 -> 17
    //   7: aload_0
    //   8: getfield 70	com/crashlytics/android/a/o:l	Landroid/content/Context;
    //   11: ldc 86
    //   13: invokestatic 91	c/a/a/a/a/b/i:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   16: return
    //   17: aload_0
    //   18: getfield 70	com/crashlytics/android/a/o:l	Landroid/content/Context;
    //   21: ldc 93
    //   23: invokestatic 91	c/a/a/a/a/b/i:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 74	com/crashlytics/android/a/o:m	Lcom/crashlytics/android/a/z;
    //   30: invokevirtual 98	com/crashlytics/android/a/z:e	()Ljava/util/List;
    //   33: astore_1
    //   34: iconst_0
    //   35: istore_2
    //   36: aload_1
    //   37: invokeinterface 104 1 0
    //   42: ifle +94 -> 136
    //   45: aload_0
    //   46: getfield 70	com/crashlytics/android/a/o:l	Landroid/content/Context;
    //   49: astore 6
    //   51: getstatic 110	java/util/Locale:US	Ljava/util/Locale;
    //   54: astore 7
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: astore 8
    //   62: aload 8
    //   64: iconst_0
    //   65: aload_1
    //   66: invokeinterface 104 1 0
    //   71: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: aload 6
    //   77: aload 7
    //   79: ldc 118
    //   81: aload 8
    //   83: invokestatic 124	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokestatic 91	c/a/a/a/a/b/i:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   89: aload_0
    //   90: getfield 84	com/crashlytics/android/a/o:b	Lc/a/a/a/a/d/f;
    //   93: aload_1
    //   94: invokeinterface 129 2 0
    //   99: istore 9
    //   101: iload 9
    //   103: ifeq +28 -> 131
    //   106: aload_1
    //   107: invokeinterface 104 1 0
    //   112: istore 10
    //   114: iload 10
    //   116: iload_2
    //   117: iadd
    //   118: istore 4
    //   120: aload_0
    //   121: getfield 74	com/crashlytics/android/a/o:m	Lcom/crashlytics/android/a/z;
    //   124: aload_1
    //   125: invokevirtual 132	com/crashlytics/android/a/z:a	(Ljava/util/List;)V
    //   128: iload 4
    //   130: istore_2
    //   131: iload 9
    //   133: ifne +15 -> 148
    //   136: iload_2
    //   137: ifne -121 -> 16
    //   140: aload_0
    //   141: getfield 74	com/crashlytics/android/a/o:m	Lcom/crashlytics/android/a/z;
    //   144: invokevirtual 134	com/crashlytics/android/a/z:g	()V
    //   147: return
    //   148: aload_0
    //   149: getfield 74	com/crashlytics/android/a/o:m	Lcom/crashlytics/android/a/z;
    //   152: invokevirtual 98	com/crashlytics/android/a/z:e	()Ljava/util/List;
    //   155: astore 11
    //   157: aload 11
    //   159: astore_1
    //   160: goto -124 -> 36
    //   163: astore_3
    //   164: iload_2
    //   165: istore 4
    //   167: aload_3
    //   168: astore 5
    //   170: aload_0
    //   171: getfield 70	com/crashlytics/android/a/o:l	Landroid/content/Context;
    //   174: new 136	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   181: ldc 139
    //   183: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 5
    //   188: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: aload 5
    //   199: invokestatic 153	c/a/a/a/a/b/i:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   202: iload 4
    //   204: istore_2
    //   205: goto -69 -> 136
    //   208: astore 5
    //   210: goto -40 -> 170
    //
    // Exception table:
    //   from	to	target	type
    //   36	101	163	java/lang/Exception
    //   106	114	163	java/lang/Exception
    //   148	157	163	java/lang/Exception
    //   120	128	208	java/lang/Exception
  }

  void a(long paramLong1, long paramLong2)
  {
    int i1;
    if (this.o.get() == null)
      i1 = 1;
    while (true)
    {
      c.a.a.a.a.d.i locali;
      if (i1 != 0)
      {
        locali = new c.a.a.a.a.d.i(this.l, this);
        c.a.a.a.a.b.i.a(this.l, "Scheduling time based file roll over every " + paramLong2 + " seconds");
      }
      try
      {
        this.o.set(this.n.scheduleAtFixedRate(locali, paramLong1, paramLong2, TimeUnit.SECONDS));
        return;
        i1 = 0;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        c.a.a.a.a.b.i.a(this.l, "Failed to schedule time based file roll over", localRejectedExecutionException);
      }
    }
  }

  public void a(b paramb, String paramString)
  {
    this.b = j.a(new aa(this.j, paramString, paramb.a, this.k, this.c.a(this.l)));
    this.m.a(paramb);
    this.h = paramb.f;
    this.i = paramb.g;
    l locall1 = c.g();
    StringBuilder localStringBuilder1 = new StringBuilder().append("Firebase analytics forwarding ");
    String str1;
    String str2;
    label139: String str3;
    label196: l locall4;
    StringBuilder localStringBuilder4;
    if (this.h)
    {
      str1 = "enabled";
      locall1.a("Answers", str1);
      l locall2 = c.g();
      StringBuilder localStringBuilder2 = new StringBuilder().append("Firebase analytics including purchase events ");
      if (!this.i)
        break label333;
      str2 = "enabled";
      locall2.a("Answers", str2);
      this.e = paramb.h;
      l locall3 = c.g();
      StringBuilder localStringBuilder3 = new StringBuilder().append("Custom event tracking ");
      if (!this.e)
        break label340;
      str3 = "enabled";
      locall3.a("Answers", str3);
      this.f = paramb.i;
      locall4 = c.g();
      localStringBuilder4 = new StringBuilder().append("Predefined event tracking ");
      if (!this.f)
        break label347;
    }
    label333: label340: label347: for (String str4 = "enabled"; ; str4 = "disabled")
    {
      locall4.a("Answers", str4);
      if (paramb.k > 1)
      {
        c.g().a("Answers", "Event sampling enabled");
        this.d = new y(paramb.k);
      }
      this.g = paramb.b;
      a(0L, this.g);
      return;
      str1 = "disabled";
      break;
      str2 = "disabled";
      break label139;
      str3 = "disabled";
      break label196;
    }
  }

  public void a(ad.a parama)
  {
    ad localad = parama.a(this.a);
    if ((!this.e) && (ad.b.g.equals(localad.c)))
      c.g().a("Answers", "Custom events tracking disabled - skipping event: " + localad);
    while (true)
    {
      return;
      if ((!this.f) && (ad.b.h.equals(localad.c)))
      {
        c.g().a("Answers", "Predefined events tracking disabled - skipping event: " + localad);
        return;
      }
      if (this.d.a(localad))
      {
        c.g().a("Answers", "Skipping filtered event: " + localad);
        return;
      }
      try
      {
        this.m.a(localad);
        e();
        if ((ad.b.g.equals(localad.c)) || (ad.b.h.equals(localad.c)))
        {
          i1 = 1;
          boolean bool = "purchase".equals(localad.g);
          if ((!this.h) || (i1 == 0) || ((bool) && (!this.i)))
            continue;
          try
          {
            this.p.a(localad);
            return;
          }
          catch (Exception localException)
          {
            c.g().e("Answers", "Failed to map event to Firebase: " + localad, localException);
            return;
          }
        }
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          c.g().e("Answers", "Failed to write event: " + localad, localIOException);
          continue;
          int i1 = 0;
        }
      }
    }
  }

  public void b()
  {
    this.m.f();
  }

  public boolean c()
  {
    try
    {
      boolean bool = this.m.d();
      return bool;
    }
    catch (IOException localIOException)
    {
      c.a.a.a.a.b.i.a(this.l, "Failed to roll file over.", localIOException);
    }
    return false;
  }

  public void d()
  {
    if (this.o.get() != null)
    {
      c.a.a.a.a.b.i.a(this.l, "Cancelling time-based rollover because no events are currently being generated.");
      ((ScheduledFuture)this.o.get()).cancel(false);
      this.o.set(null);
    }
  }

  public void e()
  {
    if (this.g != -1);
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
        a(this.g, this.g);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.o
 * JD-Core Version:    0.6.2
 */