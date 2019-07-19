package com.appboy;

import a.a.aa;
import a.a.ac;
import a.a.ad;
import a.a.aj;
import a.a.ak;
import a.a.al;
import a.a.am;
import a.a.ap;
import a.a.at;
import a.a.ay;
import a.a.az;
import a.a.ba;
import a.a.bf;
import a.a.bh;
import a.a.bj;
import a.a.bn.a;
import a.a.bp;
import a.a.bq;
import a.a.br;
import a.a.bs;
import a.a.bv;
import a.a.cr;
import a.a.ct;
import a.a.cx;
import a.a.dc;
import a.a.dd;
import a.a.dh;
import a.a.di;
import a.a.dx;
import a.a.ey;
import a.a.fd;
import a.a.fn;
import a.a.fo;
import a.a.gi;
import a.a.gj;
import a.a.gk;
import a.a.gn;
import a.a.gt;
import a.a.y;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import com.appboy.f.h;
import com.appboy.f.j;
import java.io.File;
import java.io.FilenameFilter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

public class a
{
  private static final Object A = new Object();
  private static volatile f B;
  private static volatile i C;
  private static volatile boolean D = false;
  private static volatile boolean E = false;
  private static volatile boolean F = false;
  private static volatile dc G;
  private static final String l = com.appboy.f.c.a(a.class);
  private static final Set<String> m = new HashSet(Arrays.asList(new String[] { "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTC", "BTN", "BWP", "BYR", "BZD", "CAD", "CDF", "CHF", "CLF", "CLP", "CNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EEK", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MTL", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLL", "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU", "XCD", "XDR", "XOF", "XPD", "XPF", "XPT", "YER", "ZAR", "ZMK", "ZMW", "ZWL" }));
  private static final Set<String> n = new HashSet(Collections.singletonList("calypso appcrawler"));
  private static final Set<String> o = new HashSet(Arrays.asList(new String[] { "android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET" }));
  private static volatile a p = null;
  volatile a.a.d a;
  volatile dx b;
  volatile cx c;
  volatile fo d;
  volatile am e;
  volatile dd f;
  volatile ap g;
  volatile ct h;
  final com.appboy.a.b i;
  final ay j;
  final ad k;
  private final Context q;
  private final a.a.c r;
  private final ba s;
  private volatile d t;
  private volatile ThreadPoolExecutor u;
  private final gi v;
  private final ak w;
  private final aa x;
  private g y;
  private volatile boolean z = false;

  a(final Context paramContext)
  {
    long l1 = System.nanoTime();
    com.appboy.f.c.b(l, "Braze SDK Initializing");
    y localy1 = new y("Appboy-External-Event-Manager-Thread");
    aa localaa = new aa();
    localy1.a(localaa);
    ac localac = new ac("singleton_event_manager_parallel_executor_identifier", localy1);
    localac.execute(new Runnable()
    {
      public void run()
      {
        com.appboy.f.c.a();
      }
    });
    this.q = paramContext.getApplicationContext();
    this.s = new ba();
    com.appboy.f.c.a(this.s);
    String str = Build.MODEL;
    if ((str != null) && (n.contains(str.toLowerCase(Locale.US))))
    {
      com.appboy.f.c.c(l, "Device build model matches a known crawler. Enabling mock network request mode. Device model: " + str);
      l();
    }
    this.y = new com.appboy.d.a(this.q);
    this.i = new com.appboy.a.b(this.q);
    if (!com.appboy.f.i.c(this.i.j()))
      f(this.i.j());
    this.v = new gi(this.q);
    this.w = new ak(this.q);
    this.r = new a.a.c(localac, G);
    this.j = new az(this.q, this.i);
    localac.execute(new Runnable()
    {
      public void run()
      {
        if (a.this.i.u())
          if (at.a(a.a(a.this), a.this.i))
          {
            com.appboy.f.c.c(a.n(), "Firebase Cloud Messaging found. Setting up Firebase Cloud Messaging.");
            new at(paramContext).a(a.this.i.w());
          }
        while (a.this.i.c())
          if (aj.a(a.a(a.this)))
          {
            com.appboy.f.c.c(a.n(), "Amazon Device Messaging found. Setting up Amazon Device Messaging");
            new aj(a.a(a.this), a.this.j).a();
            return;
            com.appboy.f.c.e(a.n(), "Firebase Cloud Messaging requirements not met. Braze will not register for Firebase Cloud Messaging.");
            continue;
            com.appboy.f.c.c(a.n(), "Automatic Firebase Cloud Messaging registration not enabled in configuration. Braze will not register for Firebase Cloud Messaging.");
          }
          else
          {
            com.appboy.f.c.e(a.n(), "ADM manifest requirements not met. Braze will not register for ADM.");
            return;
          }
        com.appboy.f.c.c(a.n(), "Automatic ADM registration not enabled in configuration. Braze will not register for ADM.");
      }
    });
    y localy2 = new y("Appboy-User-Dependency-Thread");
    this.x = new aa(this.r);
    localy2.a(this.x);
    localaa.a(this.r);
    this.k = new ad("singleton_user_dependency_serial_executor_identifier", localy2);
    this.k.execute(new Runnable()
    {
      public void run()
      {
        com.appboy.f.c.a(a.n(), "Starting up a new user dependency manager");
        dx localdx = new dx(a.a(a.this), a.b(a.this), a.this.i, a.c(a.this), a.d(a.this), a.this.j, a.o(), a.p(), a.e(a.this));
        a.a(a.this, localdx);
      }
    });
    localac.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          a.f(a.this);
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.d(a.n(), "Failed to verify proper SDK setup", localException);
        }
      }
    });
    long l2 = System.nanoTime();
    com.appboy.f.c.b(l, "Appboy loaded in " + TimeUnit.MILLISECONDS.convert(l2 - l1, TimeUnit.NANOSECONDS) + " ms.");
  }

  public static Uri a(Uri paramUri)
  {
    synchronized (A)
    {
      f localf = B;
      if (localf != null)
        try
        {
          Uri localUri = B.a(paramUri);
          if (localUri != null)
            return localUri;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.e(l, "Caught exception trying to get a Braze API endpoint from the AppboyEndpointProvider. Using the original URI");
        }
      return paramUri;
    }
  }

  public static a a(Context paramContext)
  {
    if ((p == null) || (p.z));
    try
    {
      if ((p == null) || (p.z))
      {
        b(e(paramContext).a());
        p = new a(paramContext);
        a locala = p;
        return locala;
      }
      return p;
    }
    finally
    {
    }
  }

  private void a(dx paramdx)
  {
    this.b = paramdx;
    this.g = paramdx.d();
    this.k.a(this.g);
    this.f = paramdx.a();
    this.d = paramdx.l();
    this.e = paramdx.m();
    this.h = paramdx.n();
    this.t = new d(paramdx.g(), this.g, this.v.a(), paramdx.j(), this.f);
    paramdx.c().a(paramdx.f());
    paramdx.e().a();
    this.a = paramdx.f();
    this.x.a(this.a);
    this.u = paramdx.h();
    this.c = paramdx.i();
    this.d = paramdx.l();
    paramdx.k().a(this.u, paramdx.e());
    this.s.a(this.g);
    this.s.a(this.f.k());
  }

  public static void a(f paramf)
  {
    synchronized (A)
    {
      B = paramf;
      return;
    }
  }

  public static void a(i parami)
  {
    com.appboy.f.c.b(l, "Custom Braze notification factory set");
    C = parami;
  }

  private void a(Throwable paramThrowable)
  {
    try
    {
      this.a.a(paramThrowable, Throwable.class);
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(l, "Failed to log throwable.", localException);
    }
  }

  public static boolean a(Context paramContext, com.appboy.a.a parama)
  {
    if (p == null)
      if (!F)
      {
        try
        {
          if ((p == null) && (!F))
          {
            gj localgj = new gj(paramContext.getApplicationContext());
            if (parama != null)
            {
              F = true;
              localgj.a(parama);
              return true;
            }
            com.appboy.f.c.c(l, "Appboy.configure() called with a null config; Clearing all configuration values.");
            localgj.a();
            return true;
          }
        }
        finally
        {
        }
        com.appboy.f.c.c(l, "Appboy.configure() can only be called once during the lifetime of the singleton.");
      }
    while (true)
    {
      return false;
      com.appboy.f.c.d(l, "Appboy.configure() can only be called once during the lifetime of the singleton.");
      continue;
      com.appboy.f.c.d(l, "Appboy.configure() must be called before the first call to Appboy.getInstance()");
    }
  }

  public static void b(Context paramContext)
  {
    e(paramContext).a(true);
    com.appboy.f.c.d(l, "Stopping the SDK instance.");
    s();
    com.appboy.f.c.d(l, "Disabling all network requests");
    b(true);
  }

  public static void b(boolean paramBoolean)
  {
    String str1 = l;
    StringBuilder localStringBuilder = new StringBuilder().append("Appboy outbound network requests are now ");
    String str2;
    if (paramBoolean)
      str2 = "disabled";
    while (true)
    {
      com.appboy.f.c.c(str1, str2);
      try
      {
        E = paramBoolean;
        if (p != null)
          p.d(paramBoolean);
        return;
        str2 = "enabled";
      }
      finally
      {
      }
    }
  }

  public static void c(Context paramContext)
  {
    com.appboy.f.c.d(l, "Setting SDK to enabled.");
    e(paramContext).a(false);
    com.appboy.f.c.d(l, "Enabling all network requests");
    b(false);
  }

  public static void d(Context paramContext)
  {
    s();
    try
    {
      fn.a(paramContext);
      com.appboy.d.a.a(paramContext);
    }
    catch (Exception localException2)
    {
      try
      {
        cr.a(paramContext);
      }
      catch (Exception localException2)
      {
        try
        {
          while (true)
          {
            File localFile1 = new File(paramContext.getApplicationInfo().dataDir, "shared_prefs");
            if ((!localFile1.exists()) || (!localFile1.isDirectory()))
              break;
            for (File localFile2 : localFile1.listFiles(new FilenameFilter()
            {
              public boolean accept(File paramAnonymousFile, String paramAnonymousString)
              {
                return paramAnonymousString.startsWith("com.appboy");
              }
            }))
            {
              com.appboy.f.c.a(l, "Deleting shared prefs file at: " + localFile2.getAbsolutePath());
              com.appboy.f.a.a(localFile2);
            }
            localException1 = localException1;
            com.appboy.f.c.c(l, "Failed to delete data from the internal storage cache.", localException1);
            continue;
            localException2 = localException2;
            com.appboy.f.c.c(l, "Failed to delete Braze database files for the Braze SDK.", localException2);
          }
        }
        catch (Exception localException3)
        {
          com.appboy.f.c.c(l, "Failed to delete shared preference data for the Braze SDK.", localException3);
        }
      }
    }
  }

  private void d(final boolean paramBoolean)
  {
    this.k.execute(new Runnable()
    {
      public void run()
      {
        a.this.g.a(paramBoolean);
        a.this.b.b().a(paramBoolean);
        if (a.h(a.this) != null)
        {
          com.appboy.f.c.b(a.n(), "Setting the image loader deny network downloads to " + paramBoolean);
          a.h(a.this).a(paramBoolean);
        }
      }
    });
  }

  private static dc e(Context paramContext)
  {
    if (G == null)
      G = new dc(paramContext);
    return G;
  }

  private void f(final String paramString)
  {
    synchronized (A)
    {
      a(new f()
      {
        public Uri a(Uri paramAnonymousUri)
        {
          return paramAnonymousUri.buildUpon().encodedAuthority(paramString).build();
        }
      });
      return;
    }
  }

  public static boolean j()
  {
    return E;
  }

  public static i k()
  {
    return C;
  }

  public static boolean l()
  {
    if (p == null)
      try
      {
        if (p == null)
        {
          if (D)
          {
            com.appboy.f.c.c(l, "Appboy network requests already being mocked. Note that events dispatched in this mode are dropped.");
            return true;
          }
          com.appboy.f.c.c(l, "Appboy network requests will be mocked. Events dispatched in this mode will be dropped.");
          D = true;
          return true;
        }
      }
      finally
      {
      }
    com.appboy.f.c.e(l, "Attempt to enable mocking Braze network requests had no effect since getInstance() has already been called.");
    return false;
  }

  private void r()
  {
    int i1 = 0;
    Iterator localIterator = o.iterator();
    int i2 = 1;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (h.a(this.q, str))
        break label137;
      com.appboy.f.c.e(l, "The Braze SDK requires the permission " + str + ". Check your AndroidManifest.");
    }
    label137: for (int i3 = 0; ; i3 = i2)
    {
      i2 = i3;
      break;
      if (this.i.b().toString().equals(""))
        com.appboy.f.c.e(l, "The Braze SDK requires a non-empty API key. Check your appboy.xml or AppboyConfig.");
      while (true)
      {
        if (i1 == 0)
          com.appboy.f.c.e(l, "The Braze SDK is not integrated correctly. Please visit https://www.braze.com/documentation/Android");
        return;
        i1 = i2;
      }
    }
  }

  private static void s()
  {
    try
    {
      com.appboy.f.c.c(l, "Shutting down all queued work on the Braze SDK");
      try
      {
        if (p != null)
        {
          if (p.k != null)
          {
            com.appboy.f.c.b(l, "Shutting down the user dependency executor");
            p.k.shutdownNow();
          }
          dx localdx = p.b;
          if (localdx != null)
          {
            if (localdx.b() != null)
              localdx.b().a(true);
            if (localdx.k() != null)
              localdx.k().a();
            if (localdx.m() != null)
              localdx.m().b();
          }
          p.z = true;
        }
        return;
      }
      finally
      {
      }
    }
    catch (Exception localException)
    {
      com.appboy.f.c.c(l, "Failed to shutdown queued work on the Braze SDK.", localException);
    }
  }

  private static boolean t()
  {
    boolean bool;
    if (G == null)
    {
      com.appboy.f.c.b(l, "SDK enablement provider was null. Returning SDK as enabled.");
      bool = false;
    }
    do
    {
      return bool;
      bool = G.a();
    }
    while (!bool);
    com.appboy.f.c.d(l, "SDK is disabled. Not performing action on SDK.");
    return bool;
  }

  public void a()
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          a.this.g.a(bp.i());
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to log that Content Cards was displayed.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  void a(final bf parambf)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (a.this.e != null)
          {
            a.this.e.a(parambf);
            return;
          }
          com.appboy.f.c.b(a.n(), "Geofence manager was null. Not requesting geofence refresh.");
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to request geofence refresh.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void a(final Activity paramActivity)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (paramActivity == null)
          {
            com.appboy.f.c.d(a.n(), "Cannot open session with null activity.");
            return;
          }
          a.this.g.a(paramActivity);
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.d(a.n(), "Failed to open session.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void a(final Intent paramIntent)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = paramIntent.getStringExtra("cid");
          if (!com.appboy.f.i.c(str))
          {
            com.appboy.f.c.c(a.n(), "Logging push click to Appboy. Campaign Id: " + str);
            a.this.b(str);
          }
          while ((paramIntent.hasExtra("ab_push_fetch_test_triggers_key")) && (paramIntent.getStringExtra("ab_push_fetch_test_triggers_key").equals("true")))
          {
            com.appboy.f.c.c(a.n(), "Push contained key for fetching test triggers, fetching triggers.");
            a.this.g.a(new bn.a().b());
            return;
            com.appboy.f.c.c(a.n(), "No campaign Id associated with this notification. Not logging push click to Appboy.");
          }
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Error logging push notification", localException);
        }
      }
    });
  }

  public void a(com.appboy.c.c<com.appboy.c.d> paramc)
  {
    try
    {
      this.r.a(paramc, com.appboy.c.d.class);
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.c(l, "Failed to add subscriber to new in-app messages.", localException);
      a(localException);
    }
  }

  public <T> void a(com.appboy.c.c<T> paramc, Class<T> paramClass)
  {
    try
    {
      this.r.c(paramc, paramClass);
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.c(l, "Failed to remove " + paramClass.getName() + " subscriber.", localException);
      a(localException);
    }
  }

  public void a(String paramString)
  {
    a(paramString, null);
  }

  void a(final String paramString, final gt paramgt)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (a.this.e != null)
          {
            a.this.e.b(paramString, paramgt);
            return;
          }
          com.appboy.f.c.b(a.n(), "Geofence manager was null. Not posting geofence report");
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to post geofence report.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void a(final String paramString, final com.appboy.e.b.a parama)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        String str = paramString;
        try
        {
          if (!j.a(str, a.this.f))
          {
            com.appboy.f.c.d(a.n(), "Log custom event input " + str + " was invalid. Not logging custom event to Appboy.");
            return;
          }
          str = j.c(str);
          bp localbp = bp.a(str, parama);
          if (a.this.g.a(localbp))
          {
            a.this.d.a(new ey(str, parama, localbp));
            return;
          }
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to log custom event: " + str, localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void a(final String paramString1, final String paramString2)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (!j.a(paramString1, paramString2))
          {
            com.appboy.f.c.d(a.n(), "Push story page click input was invalid. Not logging in-app purchase to Appboy.");
            return;
          }
          a.this.g.a(bs.e(paramString1, paramString2));
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to log push story page clicked for page id: " + paramString2 + " cid: " + paramString1, localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void a(final String paramString1, final String paramString2, final String paramString3)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (com.appboy.f.i.c(paramString1))
          {
            com.appboy.f.c.d(a.n(), "Campaign ID cannot be null or blank. Not logging push notification action clicked.");
            return;
          }
          if (com.appboy.f.i.c(paramString2))
          {
            com.appboy.f.c.d(a.n(), "Action ID cannot be null or blank");
            return;
          }
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to log push notification action clicked.", localException);
          a.a(a.this, localException);
          return;
        }
        a.this.g.a(bq.e(paramString1, paramString2, paramString3));
      }
    });
  }

  public void a(final String paramString1, final String paramString2, final BigDecimal paramBigDecimal, final int paramInt, final com.appboy.e.b.a parama)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        String str1 = paramString1;
        String str2 = paramString2;
        if (str2 == null);
        while (true)
        {
          String str3;
          Object localObject;
          try
          {
            com.appboy.f.c.d(a.n(), "The currencyCode is null. Expected one of " + a.q() + ". Not logging in-app purchase to Appboy.");
            return;
            str3 = str2.trim().toUpperCase(Locale.US);
            if (!j.a(str1, str3, paramBigDecimal, paramInt, a.this.f, a.q()))
            {
              com.appboy.f.c.d(a.n(), "Log purchase input was invalid. Not logging in-app purchase to Appboy.");
              return;
            }
          }
          catch (Exception localException1)
          {
            localObject = str1;
            Exception localException2 = localException1;
            com.appboy.f.c.c(a.n(), "Failed to log purchase event of " + (String)localObject, localException2);
            a.a(a.this, localException2);
            return;
          }
          String str4 = j.c(str1);
          try
          {
            bp localbp = bp.a(str4, str3, paramBigDecimal, paramInt, parama);
            if (!a.this.g.a(localbp))
              break;
            a.this.d.a(new fd(str4, parama, localbp));
            return;
          }
          catch (Exception localException3)
          {
            localObject = str4;
          }
        }
      }
    });
  }

  public void a(final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          a.this.g.a(paramString1, paramString2, paramBoolean);
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to submit feedback: " + paramString2, localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void a(final boolean paramBoolean)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (paramBoolean)
          {
            a.c(a.this).a(a.this.h.a(), com.appboy.c.a.class);
            return;
          }
          a.this.g.a(a.this.h.b(), a.this.h.c());
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to request Content Cards refresh. Requesting from cache: " + paramBoolean, localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void b()
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          a.this.g.a(bp.j());
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to log that the feed was displayed.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void b(final Activity paramActivity)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (paramActivity == null)
          {
            com.appboy.f.c.d(a.n(), "Cannot close session with null activity.");
            return;
          }
          bh localbh = a.this.g.b(paramActivity);
          if (localbh != null)
          {
            com.appboy.f.c.c(a.n(), "Closed session with ID: " + localbh.a());
            return;
          }
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to close session.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void b(com.appboy.c.c<com.appboy.c.a> paramc)
  {
    try
    {
      this.r.a(paramc, com.appboy.c.a.class);
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.c(l, "Failed to add subscriber for Content Cards updates.", localException);
      a(localException);
    }
  }

  public void b(final String paramString)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (com.appboy.f.i.c(paramString))
          {
            com.appboy.f.c.d(a.n(), "Campaign ID cannot be null or blank. Not logging push notification opened.");
            return;
          }
          a.this.g.a(br.j(paramString));
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to log opened push.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  void b(final String paramString1, final String paramString2)
  {
    if (t())
      return;
    if (com.appboy.f.i.c(paramString1))
    {
      com.appboy.f.c.d(l, "Cannot add null or blank card json to storage. Returning. User id: " + paramString2 + " Serialized json: " + paramString1);
      return;
    }
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          bv localbv = new bv(paramString1);
          a.this.h.a(localbv, paramString2);
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.d(a.n(), "Failed to update ContentCard storage provider with single card update. User id: " + paramString2 + " Serialized json: " + paramString1, localException);
        }
      }
    });
  }

  public void c()
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          a.this.g.a(bp.k());
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to log that feedback was displayed.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void c(com.appboy.c.c<com.appboy.c.b> paramc)
  {
    try
    {
      this.r.a(paramc, com.appboy.c.b.class);
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.c(l, "Failed to add subscriber for feed updates.", localException);
      a(localException);
    }
  }

  public void c(final String paramString)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (com.appboy.f.i.c(paramString))
          {
            com.appboy.f.c.d(a.n(), "Campaign ID cannot be null or blank for push delivery event.");
            return;
          }
          a.this.g.a(bp.i(paramString));
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to log push delivery event.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  void c(final boolean paramBoolean)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (a.this.e != null)
          {
            a.this.e.b(paramBoolean);
            return;
          }
          com.appboy.f.c.b(a.n(), "Geofence manager was null. Not requesting geofence refresh.");
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to request geofence refresh with rate limit ignore: " + paramBoolean, localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void d()
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          a.c(a.this).a(a.this.c.a(), com.appboy.c.b.class);
          return;
        }
        catch (JSONException localJSONException)
        {
          com.appboy.f.c.c(a.n(), "Failed to retrieve and publish feed from offline cache.", localJSONException);
        }
      }
    });
  }

  public void d(final String paramString)
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        String str;
        try
        {
          if (com.appboy.f.i.b(paramString))
          {
            com.appboy.f.c.e(a.n(), "ArgumentException: userId passed to changeUser was null or empty. The current user will remain the active user.");
            return;
          }
          str = a.g(a.this).a();
          if (str.equals(paramString))
          {
            com.appboy.f.c.c(a.n(), "Received request to change current user " + paramString + " to the same user id. Doing nothing.");
            return;
          }
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to set external id to: " + paramString, localException);
          a.a(a.this, localException);
          return;
        }
        if (str.equals(""))
        {
          com.appboy.f.c.c(a.n(), "Changing anonymous user to " + paramString);
          a.b(a.this).a(paramString);
          a.g(a.this).i(paramString);
        }
        while (true)
        {
          a.this.g.c();
          a.b(a.this).a(paramString);
          dx localdx1 = a.this.b;
          dx localdx2 = new dx(a.a(a.this), a.b(a.this), a.this.i, a.c(a.this), a.d(a.this), a.this.j, a.o(), a.p(), a.e(a.this));
          a.a(a.this, localdx2);
          a.this.b.g().d();
          a.this.g.a();
          a.this.g.a(new bn.a().a());
          a.this.a(false);
          localdx1.o();
          return;
          com.appboy.f.c.c(a.n(), "Changing current user " + str + " to new user " + paramString + ".");
          com.appboy.c.b localb = new com.appboy.c.b(new ArrayList(), paramString, false, di.a());
          a.c(a.this).a(localb, com.appboy.c.b.class);
        }
      }
    });
  }

  public void e()
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          a.this.g.a(new bn.a().a());
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to request refresh of feed.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public void e(String paramString)
  {
    if (t())
      return;
    try
    {
      if (com.appboy.f.i.c(paramString))
      {
        com.appboy.f.c.d(l, "Push registration ID must not be null or blank. Not registering for push messages from Appboy.");
        return;
      }
    }
    catch (Exception localException)
    {
      com.appboy.f.c.c(l, "Failed to set the registration ID.", localException);
      a(localException);
      return;
    }
    com.appboy.f.c.c(l, "Push token " + paramString + " registered and immediately being flushed.");
    this.j.a(paramString);
    f();
  }

  public void f()
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          a.this.g.d();
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to request data flush.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }

  public d g()
  {
    try
    {
      d locald = (d)this.k.submit(new Callable()
      {
        public d a()
        {
          return a.g(a.this);
        }
      }).get();
      return locald;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.c(l, "Failed to retrieve the current user.", localException);
      a(localException);
    }
    return null;
  }

  public g h()
  {
    if (this.y == null)
    {
      com.appboy.f.c.b(l, "The Image Loader was null. Creating a new Image Loader and returning it.");
      this.y = new com.appboy.d.a(this.q);
    }
    return this.y;
  }

  public String i()
  {
    return this.w.a();
  }

  void m()
  {
    if (t())
      return;
    this.k.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (a.this.e != null)
          {
            a.this.e.a();
            return;
          }
          com.appboy.f.c.b(a.n(), "Geofence manager was null. Not initializing geofences.");
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a.n(), "Failed to initialize geofences with the geofence manager.", localException);
          a.a(a.this, localException);
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.a
 * JD-Core Version:    0.6.2
 */