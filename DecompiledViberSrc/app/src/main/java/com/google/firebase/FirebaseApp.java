package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.a.c;
import com.google.firebase.c.a;
import com.google.firebase.components.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseApp
{

  @GuardedBy("LOCK")
  static final Map<String, FirebaseApp> a = new ArrayMap();
  private static final List<String> b = Arrays.asList(new String[] { "com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId" });
  private static final List<String> c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
  private static final List<String> d = Arrays.asList(new String[] { "com.google.android.gms.measurement.AppMeasurement" });
  private static final List<String> e = Arrays.asList(new String[0]);
  private static final Set<String> f = Collections.emptySet();
  private static final Object g = new Object();
  private static final Executor h = new d(null);
  private final Context i;
  private final String j;
  private final b k;
  private final i l;
  private final SharedPreferences m;
  private final c n;
  private final AtomicBoolean o = new AtomicBoolean(false);
  private final AtomicBoolean p = new AtomicBoolean();
  private final AtomicBoolean q;
  private final List<Object> r = new CopyOnWriteArrayList();
  private final List<a> s = new CopyOnWriteArrayList();
  private final List<Object> t = new CopyOnWriteArrayList();
  private c u;

  protected FirebaseApp(Context paramContext, String paramString, b paramb)
  {
    this.i = ((Context)Preconditions.checkNotNull(paramContext));
    this.j = Preconditions.checkNotEmpty(paramString);
    this.k = ((b)Preconditions.checkNotNull(paramb));
    this.u = new a();
    this.m = paramContext.getSharedPreferences(a(paramString), 0);
    this.q = new AtomicBoolean(f());
    List localList = com.google.firebase.components.f.a(paramContext).a();
    Executor localExecutor = h;
    com.google.firebase.components.b[] arrayOfb = new com.google.firebase.components.b[6];
    arrayOfb[0] = com.google.firebase.components.b.a(paramContext, Context.class, new Class[0]);
    arrayOfb[1] = com.google.firebase.components.b.a(this, FirebaseApp.class, new Class[0]);
    arrayOfb[2] = com.google.firebase.components.b.a(paramb, b.class, new Class[0]);
    arrayOfb[3] = com.google.firebase.d.f.a("fire-android", "");
    arrayOfb[4] = com.google.firebase.d.f.a("fire-core", "16.1.0");
    arrayOfb[5] = com.google.firebase.d.b.b();
    this.l = new i(localExecutor, localList, arrayOfb);
    this.n = ((c)this.l.a(c.class));
  }

  public static FirebaseApp a(Context paramContext)
  {
    b localb;
    synchronized (g)
    {
      if (a.containsKey("[DEFAULT]"))
      {
        FirebaseApp localFirebaseApp2 = getInstance();
        return localFirebaseApp2;
      }
      localb = b.a(paramContext);
      if (localb == null)
      {
        Log.d("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
        return null;
      }
    }
    FirebaseApp localFirebaseApp1 = a(paramContext, localb);
    return localFirebaseApp1;
  }

  public static FirebaseApp a(Context paramContext, b paramb)
  {
    return a(paramContext, paramb, "[DEFAULT]");
  }

  public static FirebaseApp a(Context paramContext, b paramb, String paramString)
  {
    b.a(paramContext);
    String str = b(paramString);
    if (paramContext.getApplicationContext() == null);
    synchronized (g)
    {
      while (!a.containsKey(str))
      {
        bool = true;
        Preconditions.checkState(bool, "FirebaseApp name " + str + " already exists!");
        Preconditions.checkNotNull(paramContext, "Application context cannot be null.");
        FirebaseApp localFirebaseApp = new FirebaseApp(paramContext, str, paramb);
        a.put(str, localFirebaseApp);
        localFirebaseApp.h();
        return localFirebaseApp;
        paramContext = paramContext.getApplicationContext();
      }
      boolean bool = false;
    }
  }

  private static String a(String paramString)
  {
    return "com.google.firebase.common.prefs:" + paramString;
  }

  private <T> void a(Class<T> paramClass, T paramT, Iterable<String> paramIterable, boolean paramBoolean)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramBoolean);
      try
      {
        if (e.contains(str))
        {
          Method localMethod = Class.forName(str).getMethod("getInstance", new Class[] { paramClass });
          int i1 = localMethod.getModifiers();
          if ((Modifier.isPublic(i1)) && (Modifier.isStatic(i1)))
            localMethod.invoke(null, new Object[] { paramT });
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (f.contains(str))
          throw new IllegalStateException(str + " is missing, but is required. Check if it has been removed by Proguard.");
        Log.d("FirebaseApp", str + " is not linked. Skipping initialization.");
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new IllegalStateException(str + "#getInstance has been removed by Proguard. Add keep rule to prevent it.");
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Log.wtf("FirebaseApp", "Firebase API initialization failure.", localInvocationTargetException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.wtf("FirebaseApp", "Failed to initialize " + str, localIllegalAccessException);
      }
    }
  }

  private void a(boolean paramBoolean)
  {
    Log.d("FirebaseApp", "Notifying background state change listeners.");
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).a(paramBoolean);
  }

  private static String b(String paramString)
  {
    return paramString.trim();
  }

  private boolean f()
  {
    boolean bool1 = true;
    if (this.m.contains("firebase_data_collection_default_enabled"))
      bool1 = this.m.getBoolean("firebase_data_collection_default_enabled", bool1);
    while (true)
    {
      return bool1;
      try
      {
        PackageManager localPackageManager = this.i.getPackageManager();
        if (localPackageManager != null)
        {
          ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(this.i.getPackageName(), 128);
          if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null) && (localApplicationInfo.metaData.containsKey("firebase_data_collection_default_enabled")))
          {
            boolean bool2 = localApplicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            return bool2;
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
      }
    }
    return bool1;
  }

  private void g()
  {
    if (!this.p.get());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "FirebaseApp was deleted");
      return;
    }
  }

  public static FirebaseApp getInstance()
  {
    FirebaseApp localFirebaseApp;
    synchronized (g)
    {
      localFirebaseApp = (FirebaseApp)a.get("[DEFAULT]");
      if (localFirebaseApp == null)
        throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
    }
    return localFirebaseApp;
  }

  private void h()
  {
    boolean bool = ContextCompat.isDeviceProtectedStorage(this.i);
    if (bool)
      e.a(this.i);
    while (true)
    {
      a(FirebaseApp.class, this, b, bool);
      if (d())
      {
        a(FirebaseApp.class, this, c, bool);
        a(Context.class, this.i, d, bool);
      }
      return;
      this.l.a(d());
    }
  }

  public Context a()
  {
    g();
    return this.i;
  }

  @KeepForSdk
  public <T> T a(Class<T> paramClass)
  {
    g();
    return this.l.a(paramClass);
  }

  public String b()
  {
    g();
    return this.j;
  }

  public b c()
  {
    g();
    return this.k;
  }

  @KeepForSdk
  public boolean d()
  {
    return "[DEFAULT]".equals(b());
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FirebaseApp))
      return false;
    return this.j.equals(((FirebaseApp)paramObject).b());
  }

  public int hashCode()
  {
    return this.j.hashCode();
  }

  @KeepForSdk
  public boolean isDataCollectionDefaultEnabled()
  {
    g();
    return this.q.get();
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("name", this.j).add("options", this.k).toString();
  }

  @KeepForSdk
  public static abstract interface a
  {
    @KeepForSdk
    public abstract void a(boolean paramBoolean);
  }

  @TargetApi(14)
  private static class b
    implements BackgroundDetector.BackgroundStateChangeListener
  {
    private static AtomicReference<b> a = new AtomicReference();

    private static void b(Context paramContext)
    {
      if ((!PlatformVersion.isAtLeastIceCreamSandwich()) || (!(paramContext.getApplicationContext() instanceof Application)));
      Application localApplication;
      b localb;
      do
      {
        do
        {
          return;
          localApplication = (Application)paramContext.getApplicationContext();
        }
        while (a.get() != null);
        localb = new b();
      }
      while (!a.compareAndSet(null, localb));
      BackgroundDetector.initialize(localApplication);
      BackgroundDetector.getInstance().addListener(localb);
    }

    public void onBackgroundStateChanged(boolean paramBoolean)
    {
      synchronized (FirebaseApp.e())
      {
        Iterator localIterator = new ArrayList(FirebaseApp.a.values()).iterator();
        while (localIterator.hasNext())
        {
          FirebaseApp localFirebaseApp = (FirebaseApp)localIterator.next();
          if (FirebaseApp.b(localFirebaseApp).get())
            FirebaseApp.a(localFirebaseApp, paramBoolean);
        }
      }
    }
  }

  @Deprecated
  @KeepForSdk
  public static abstract interface c
  {
  }

  private static class d
    implements Executor
  {
    private static final Handler a = new Handler(Looper.getMainLooper());

    public void execute(Runnable paramRunnable)
    {
      a.post(paramRunnable);
    }
  }

  @TargetApi(24)
  private static class e extends BroadcastReceiver
  {
    private static AtomicReference<e> a = new AtomicReference();
    private final Context b;

    public e(Context paramContext)
    {
      this.b = paramContext;
    }

    private static void b(Context paramContext)
    {
      if (a.get() == null)
      {
        e locale = new e(paramContext);
        if (a.compareAndSet(null, locale))
          paramContext.registerReceiver(locale, new IntentFilter("android.intent.action.USER_UNLOCKED"));
      }
    }

    public void a()
    {
      this.b.unregisterReceiver(this);
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      synchronized (FirebaseApp.e())
      {
        Iterator localIterator = FirebaseApp.a.values().iterator();
        if (localIterator.hasNext())
          FirebaseApp.a((FirebaseApp)localIterator.next());
      }
      a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.FirebaseApp
 * JD-Core Version:    0.6.2
 */