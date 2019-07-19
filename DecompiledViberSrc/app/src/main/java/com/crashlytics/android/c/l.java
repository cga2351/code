package com.crashlytics.android.c;

import android.content.Context;
import android.util.Log;
import c.a.a.a.a.b.s;
import c.a.a.a.a.g.t;
import c.a.a.a.c;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@c.a.a.a.a.c.d(a={"Lcom/crashlytics/android/c/q;"})
public class l extends c.a.a.a.i<Void>
{
  private final long a;
  private final ConcurrentHashMap<String, String> b;
  private m c;
  private m d;
  private o k;
  private k l;
  private String m = null;
  private String n = null;
  private String o = null;
  private float p;
  private boolean q;
  private final aj r;
  private c.a.a.a.a.e.e s;
  private j t;
  private q u;

  public l()
  {
    this(1.0F, null, null, false);
  }

  l(float paramFloat, o paramo, aj paramaj, boolean paramBoolean)
  {
    this(paramFloat, paramo, paramaj, paramBoolean, c.a.a.a.a.b.o.a("Crashlytics Exception Handler"));
  }

  l(float paramFloat, o paramo, aj paramaj, boolean paramBoolean, ExecutorService paramExecutorService)
  {
    this.p = paramFloat;
    if (paramo != null);
    while (true)
    {
      this.k = paramo;
      this.r = paramaj;
      this.q = paramBoolean;
      this.t = new j(paramExecutorService);
      this.b = new ConcurrentHashMap();
      this.a = System.currentTimeMillis();
      return;
      paramo = new b(null);
    }
  }

  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.q);
    while (!b("prior to logging messages."))
      return;
    long l1 = System.currentTimeMillis() - this.a;
    this.l.a(l1, b(paramInt, paramString1, paramString2));
  }

  static boolean a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      c.g().a("CrashlyticsCore", "Configured not to require a build ID.");
    while (!c.a.a.a.a.b.i.d(paramString))
      return true;
    Log.e("CrashlyticsCore", ".");
    Log.e("CrashlyticsCore", ".     |  | ");
    Log.e("CrashlyticsCore", ".     |  |");
    Log.e("CrashlyticsCore", ".     |  |");
    Log.e("CrashlyticsCore", ".   \\ |  | /");
    Log.e("CrashlyticsCore", ".    \\    /");
    Log.e("CrashlyticsCore", ".     \\  /");
    Log.e("CrashlyticsCore", ".      \\/");
    Log.e("CrashlyticsCore", ".");
    Log.e("CrashlyticsCore", "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
    Log.e("CrashlyticsCore", ".");
    Log.e("CrashlyticsCore", ".      /\\");
    Log.e("CrashlyticsCore", ".     /  \\");
    Log.e("CrashlyticsCore", ".    /    \\");
    Log.e("CrashlyticsCore", ".   / |  | \\");
    Log.e("CrashlyticsCore", ".     |  |");
    Log.e("CrashlyticsCore", ".     |  |");
    Log.e("CrashlyticsCore", ".     |  |");
    Log.e("CrashlyticsCore", ".");
    return false;
  }

  private static String b(int paramInt, String paramString1, String paramString2)
  {
    return c.a.a.a.a.b.i.b(paramInt) + "/" + paramString1 + " " + paramString2;
  }

  private static boolean b(String paramString)
  {
    l locall = e();
    if ((locall == null) || (locall.l == null))
    {
      c.g().e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + paramString, null);
      return false;
    }
    return true;
  }

  private static String c(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (paramString.length() > 1024)
        paramString = paramString.substring(0, 1024);
    }
    return paramString;
  }

  public static l e()
  {
    return (l)c.a(l.class);
  }

  private void w()
  {
    c.a.a.a.a.c.g local1 = new c.a.a.a.a.c.g()
    {
      public Void a()
        throws Exception
      {
        return l.this.c();
      }

      public c.a.a.a.a.c.e b()
      {
        return c.a.a.a.a.c.e.d;
      }
    };
    Iterator localIterator = v().iterator();
    while (localIterator.hasNext())
      local1.a((c.a.a.a.a.c.l)localIterator.next());
    Future localFuture = s().e().submit(local1);
    c.g().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
    try
    {
      localFuture.get(4L, TimeUnit.SECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      c.g().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", localInterruptedException);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      c.g().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", localExecutionException);
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      c.g().e("CrashlyticsCore", "Crashlytics timed out during initialization.", localTimeoutException);
    }
  }

  private void x()
  {
    Boolean localBoolean = (Boolean)this.t.a(new a(this.d));
    if (!Boolean.TRUE.equals(localBoolean))
      return;
    try
    {
      this.k.a();
      return;
    }
    catch (Exception localException)
    {
      c.g().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", localException);
    }
  }

  public String a()
  {
    return "2.6.8.32";
  }

  void a(q paramq)
  {
    this.u = paramq;
  }

  public void a(String paramString)
  {
    a(3, "CrashlyticsCore", paramString);
  }

  public void a(String paramString, int paramInt)
  {
    a(paramString, Integer.toString(paramInt));
  }

  public void a(String paramString1, String paramString2)
  {
    if (this.q);
    while (!b("prior to setting keys."))
      return;
    if (paramString1 == null)
    {
      Context localContext = r();
      if ((localContext != null) && (c.a.a.a.a.b.i.i(localContext)))
        throw new IllegalArgumentException("Custom attribute key must not be null.");
      c.g().e("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", null);
      return;
    }
    String str1 = c(paramString1);
    if ((this.b.size() >= 64) && (!this.b.containsKey(str1)))
    {
      c.g().a("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
      return;
    }
    if (paramString2 == null);
    for (String str2 = ""; ; str2 = c(paramString2))
    {
      this.b.put(str1, str2);
      this.l.a(this.b);
      return;
    }
  }

  public void a(Throwable paramThrowable)
  {
    if (this.q);
    while (!b("prior to logging exceptions."))
      return;
    if (paramThrowable == null)
    {
      c.g().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
      return;
    }
    this.l.a(Thread.currentThread(), paramThrowable);
  }

  boolean a(Context paramContext)
  {
    if (!c.a.a.a.a.b.l.a(paramContext).a())
    {
      c.g().a("CrashlyticsCore", "Crashlytics is disabled, because data collection is disabled by Firebase.");
      this.q = true;
    }
    if (this.q)
      return false;
    String str1 = new c.a.a.a.a.b.g().a(paramContext);
    if (str1 == null)
      return false;
    String str2 = c.a.a.a.a.b.i.m(paramContext);
    if (!a(str2, c.a.a.a.a.b.i.a(paramContext, "com.crashlytics.RequireBuildId", true)))
      throw new c.a.a.a.a.c.m("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
    try
    {
      c.g().c("CrashlyticsCore", "Initializing Crashlytics " + a());
      c.a.a.a.a.f.b localb = new c.a.a.a.a.f.b(this);
      this.d = new m("crash_marker", localb);
      this.c = new m("initialization_marker", localb);
      ak localak = ak.a(new c.a.a.a.a.f.d(r(), "com.crashlytics.android.core.CrashlyticsCore"), this);
      if (this.r != null);
      for (r localr = new r(this.r); ; localr = null)
      {
        this.s = new c.a.a.a.a.e.b(c.g());
        this.s.a(localr);
        s locals = q();
        a locala = a.a(paramContext, locals, str1, str2);
        ar localar = new ar(paramContext, new ac(paramContext, locala.d));
        v localv = new v(this);
        com.crashlytics.android.a.q localq = com.crashlytics.android.a.k.a(paramContext);
        c.g().a("CrashlyticsCore", "Installer package name is: " + locala.c);
        this.l = new k(this, this.t, this.s, locals, localak, localb, locala, localar, localv, localq);
        boolean bool1 = m();
        x();
        boolean bool2 = new c.a.a.a.a.b.r().b(paramContext);
        this.l.a(Thread.getDefaultUncaughtExceptionHandler(), bool2);
        if ((!bool1) || (!c.a.a.a.a.b.i.o(paramContext)))
          break;
        c.g().a("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
        w();
        return false;
      }
    }
    catch (Exception localException)
    {
      c.g().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", localException);
      this.l = null;
      return false;
    }
    c.g().a("CrashlyticsCore", "Exception handling initialization successful");
    return true;
  }

  public String b()
  {
    return "com.crashlytics.sdk.android.crashlytics-core";
  }

  protected Void c()
  {
    k();
    this.l.e();
    try
    {
      this.l.k();
      t localt = c.a.a.a.a.g.q.a().b();
      if (localt == null)
      {
        c.g().d("CrashlyticsCore", "Received null settings, skipping report submission!");
        return null;
      }
      this.l.a(localt);
      if (!localt.d.c)
      {
        c.g().a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
        return null;
      }
      if (!c.a.a.a.a.b.l.a(r()).a())
      {
        c.g().a("CrashlyticsCore", "Automatic collection of crash reports disabled by Firebase settings.");
        return null;
      }
      p localp = n();
      if ((localp != null) && (!this.l.a(localp)))
        c.g().a("CrashlyticsCore", "Could not finalize previous NDK sessions.");
      if (!this.l.a(localt.b))
        c.g().a("CrashlyticsCore", "Could not finalize previous sessions.");
      this.l.a(this.p, localt);
      return null;
    }
    catch (Exception localException)
    {
      c.g().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", localException);
      return null;
    }
    finally
    {
      l();
    }
  }

  protected boolean f_()
  {
    return a(super.r());
  }

  Map<String, String> g()
  {
    return Collections.unmodifiableMap(this.b);
  }

  String h()
  {
    if (q().a())
      return this.m;
    return null;
  }

  String i()
  {
    if (q().a())
      return this.n;
    return null;
  }

  String j()
  {
    if (q().a())
      return this.o;
    return null;
  }

  void k()
  {
    this.t.a(new Callable()
    {
      public Void a()
        throws Exception
      {
        l.a(l.this).a();
        c.g().a("CrashlyticsCore", "Initialization marker file created.");
        return null;
      }
    });
  }

  void l()
  {
    this.t.b(new Callable()
    {
      public Boolean a()
        throws Exception
      {
        try
        {
          boolean bool = l.a(l.this).c();
          c.g().a("CrashlyticsCore", "Initialization marker file removed: " + bool);
          Boolean localBoolean = Boolean.valueOf(bool);
          return localBoolean;
        }
        catch (Exception localException)
        {
          c.g().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", localException);
        }
        return Boolean.valueOf(false);
      }
    });
  }

  boolean m()
  {
    return this.c.b();
  }

  p n()
  {
    if (this.u != null)
      return this.u.c();
    return null;
  }

  void o()
  {
    this.d.a();
  }

  private static final class a
    implements Callable<Boolean>
  {
    private final m a;

    public a(m paramm)
    {
      this.a = paramm;
    }

    public Boolean a()
      throws Exception
    {
      if (!this.a.b())
        return Boolean.FALSE;
      c.g().a("CrashlyticsCore", "Found previous crash marker.");
      this.a.c();
      return Boolean.TRUE;
    }
  }

  private static final class b
    implements o
  {
    public void a()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.l
 * JD-Core Version:    0.6.2
 */