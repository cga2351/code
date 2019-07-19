package c.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import c.a.a.a.a.b.s;
import c.a.a.a.a.c.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
{
  static volatile c a;
  static final l b = new b();
  final l c;
  final boolean d;
  private final Context e;
  private final Map<Class<? extends i>, i> f;
  private final ExecutorService g;
  private final Handler h;
  private final f<c> i;
  private final f<?> j;
  private final s k;
  private a l;
  private WeakReference<Activity> m;
  private AtomicBoolean n;

  c(Context paramContext, Map<Class<? extends i>, i> paramMap, c.a.a.a.a.c.k paramk, Handler paramHandler, l paraml, boolean paramBoolean, f paramf, s params, Activity paramActivity)
  {
    this.e = paramContext;
    this.f = paramMap;
    this.g = paramk;
    this.h = paramHandler;
    this.c = paraml;
    this.d = paramBoolean;
    this.i = paramf;
    this.n = new AtomicBoolean(false);
    this.j = a(paramMap.size());
    this.k = params;
    a(paramActivity);
  }

  static c a()
  {
    if (a == null)
      throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    return a;
  }

  public static c a(Context paramContext, i[] paramArrayOfi)
  {
    if (a == null);
    try
    {
      if (a == null)
        c(new a(paramContext).a(paramArrayOfi).a());
      return a;
    }
    finally
    {
    }
  }

  public static <T extends i> T a(Class<T> paramClass)
  {
    return (i)a().f.get(paramClass);
  }

  private static void a(Map<Class<? extends i>, i> paramMap, Collection<? extends i> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      paramMap.put(locali.getClass(), locali);
      if ((locali instanceof j))
        a(paramMap, ((j)locali).c());
    }
  }

  private static Map<Class<? extends i>, i> b(Collection<? extends i> paramCollection)
  {
    HashMap localHashMap = new HashMap(paramCollection.size());
    a(localHashMap, paramCollection);
    return localHashMap;
  }

  private static void c(c paramc)
  {
    a = paramc;
    paramc.j();
  }

  private static Activity d(Context paramContext)
  {
    if ((paramContext instanceof Activity))
      return (Activity)paramContext;
    return null;
  }

  public static l g()
  {
    if (a == null)
      return b;
    return a.c;
  }

  public static boolean h()
  {
    if (a == null)
      return false;
    return a.d;
  }

  public static boolean i()
  {
    return (a != null) && (a.n.get());
  }

  private void j()
  {
    this.l = new a(this.e);
    this.l.a(new a.b()
    {
      public void a(Activity paramAnonymousActivity)
      {
        c.this.a(paramAnonymousActivity);
      }

      public void a(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        c.this.a(paramAnonymousActivity);
      }

      public void b(Activity paramAnonymousActivity)
      {
        c.this.a(paramAnonymousActivity);
      }
    });
    a(this.e);
  }

  public c a(Activity paramActivity)
  {
    this.m = new WeakReference(paramActivity);
    return this;
  }

  f<?> a(final int paramInt)
  {
    return new f()
    {
      final CountDownLatch a = new CountDownLatch(paramInt);

      public void a(Exception paramAnonymousException)
      {
        c.b(c.this).a(paramAnonymousException);
      }

      public void a(Object paramAnonymousObject)
      {
        this.a.countDown();
        if (this.a.getCount() == 0L)
        {
          c.a(c.this).set(true);
          c.b(c.this).a(c.this);
        }
      }
    };
  }

  void a(Context paramContext)
  {
    Future localFuture = b(paramContext);
    Collection localCollection = f();
    m localm = new m(localFuture, localCollection);
    ArrayList localArrayList = new ArrayList(localCollection);
    Collections.sort(localArrayList);
    localm.a(paramContext, this, f.d, this.k);
    Iterator localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
      ((i)localIterator1.next()).a(paramContext, this, this.j, this.k);
    localm.p();
    if (g().a("Fabric", 3));
    for (StringBuilder localStringBuilder = new StringBuilder("Initializing ").append(d()).append(" [Version: ").append(c()).append("], with the following kits:\n"); ; localStringBuilder = null)
    {
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        i locali = (i)localIterator2.next();
        locali.f.a(localm.f);
        a(this.f, locali);
        locali.p();
        if (localStringBuilder != null)
          localStringBuilder.append(locali.b()).append(" [Version: ").append(locali.a()).append("]\n");
      }
    }
    if (localStringBuilder != null)
      g().a("Fabric", localStringBuilder.toString());
  }

  void a(Map<Class<? extends i>, i> paramMap, i parami)
  {
    d locald = parami.j;
    if (locald != null)
      for (Class localClass : locald.a())
      {
        if (localClass.isInterface())
        {
          Iterator localIterator = paramMap.values().iterator();
          while (localIterator.hasNext())
          {
            i locali = (i)localIterator.next();
            if (localClass.isAssignableFrom(locali.getClass()))
              parami.f.a(locali.f);
          }
        }
        if ((i)paramMap.get(localClass) == null)
          throw new c.a.a.a.a.c.m("Referenced Kit was null, does the kit exist?");
        parami.f.a(((i)paramMap.get(localClass)).f);
      }
  }

  public Activity b()
  {
    if (this.m != null)
      return (Activity)this.m.get();
    return null;
  }

  Future<Map<String, k>> b(Context paramContext)
  {
    e locale = new e(paramContext.getPackageCodePath());
    return e().submit(locale);
  }

  public String c()
  {
    return "1.4.8.32";
  }

  public String d()
  {
    return "io.fabric.sdk.android:fabric";
  }

  public ExecutorService e()
  {
    return this.g;
  }

  public Collection<i> f()
  {
    return this.f.values();
  }

  public static class a
  {
    private final Context a;
    private i[] b;
    private c.a.a.a.a.c.k c;
    private Handler d;
    private l e;
    private boolean f;
    private String g;
    private String h;
    private f<c> i;

    public a(Context paramContext)
    {
      if (paramContext == null)
        throw new IllegalArgumentException("Context must not be null.");
      this.a = paramContext;
    }

    public a a(i[] paramArrayOfi)
    {
      if (this.b != null)
        throw new IllegalStateException("Kits already set.");
      ArrayList localArrayList;
      if (!c.a.a.a.a.b.l.a(this.a).a())
      {
        localArrayList = new ArrayList();
        int j = paramArrayOfi.length;
        int k = 0;
        int m = 0;
        if (k < j)
        {
          i locali = paramArrayOfi[k];
          String str = locali.b();
          int n = -1;
          switch (str.hashCode())
          {
          default:
            switch (n)
            {
            default:
              label100: if (m == 0)
              {
                c.g().d("Fabric", "Fabric will not initialize any kits when Firebase automatic data collection is disabled; to use Third-party kits with automatic data collection disabled, initialize these kits via non-Fabric means.");
                m = 1;
              }
              break;
            case 0:
            case 1:
            }
            break;
          case 1830452504:
          case 607220212:
          }
          while (true)
          {
            k++;
            break;
            if (!str.equals("com.crashlytics.sdk.android:crashlytics"))
              break label100;
            n = 0;
            break label100;
            if (!str.equals("com.crashlytics.sdk.android:answers"))
              break label100;
            n = 1;
            break label100;
            localArrayList.add(locali);
          }
        }
      }
      for (i[] arrayOfi = (i[])localArrayList.toArray(new i[0]); ; arrayOfi = paramArrayOfi)
      {
        this.b = arrayOfi;
        return this;
      }
    }

    public c a()
    {
      if (this.c == null)
        this.c = c.a.a.a.a.c.k.a();
      if (this.d == null)
        this.d = new Handler(Looper.getMainLooper());
      if (this.e == null)
      {
        if (this.f)
          this.e = new b(3);
      }
      else
      {
        if (this.h == null)
          this.h = this.a.getPackageName();
        if (this.i == null)
          this.i = f.d;
        if (this.b != null)
          break label191;
      }
      label191: for (Object localObject = new HashMap(); ; localObject = c.a(Arrays.asList(this.b)))
      {
        Context localContext = this.a.getApplicationContext();
        s locals = new s(localContext, this.h, this.g, ((Map)localObject).values());
        return new c(localContext, (Map)localObject, this.c, this.d, this.e, this.f, this.i, locals, c.c(this.a));
        this.e = new b();
        break;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.c
 * JD-Core Version:    0.6.2
 */