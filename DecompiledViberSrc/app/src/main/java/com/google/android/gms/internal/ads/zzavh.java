package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzare
@ParametersAreNonnullByDefault
public final class zzavh
{
  private final AtomicReference<ThreadPoolExecutor> zzdsf = new AtomicReference(null);
  private final Object zzdsg = new Object();

  @GuardedBy("gmpAppIdLock")
  private String zzdsh = null;

  @GuardedBy("gmpAppIdLock")
  private String zzdsi = null;

  @VisibleForTesting
  private final AtomicBoolean zzdsj = new AtomicBoolean(false);

  @VisibleForTesting
  private final AtomicInteger zzdsk = new AtomicInteger(-1);
  private final AtomicReference<Object> zzdsl = new AtomicReference(null);
  private final AtomicReference<Object> zzdsm = new AtomicReference(null);
  private final ConcurrentMap<String, Method> zzdsn = new ConcurrentHashMap(9);
  private final AtomicReference<zzbjg> zzdso = new AtomicReference(null);

  @GuardedBy("proxyReference")
  private final List<FutureTask> zzdsp = new ArrayList();

  private final Object zza(String paramString, Context paramContext)
  {
    if (!zza(paramContext, "com.google.android.gms.measurement.AppMeasurement", this.zzdsl, true))
      return null;
    Method localMethod = zzl(paramContext, paramString);
    try
    {
      Object localObject = localMethod.invoke(this.zzdsl.get(), new Object[0]);
      return localObject;
    }
    catch (Exception localException)
    {
      zza(localException, paramString, true);
    }
    return null;
  }

  private final <T> T zza(String paramString, T paramT, zzavw<T> paramzzavw)
  {
    synchronized (this.zzdso)
    {
      zzbjg localzzbjg = (zzbjg)this.zzdso.get();
      if (localzzbjg != null)
        try
        {
          Object localObject2 = paramzzavw.zzb((zzbjg)this.zzdso.get());
          return localObject2;
        }
        catch (Exception localException)
        {
          zza(localException, paramString, false);
        }
      return paramT;
    }
  }

  private final <T> Future<T> zza(String paramString, zzavw<T> paramzzavw)
  {
    synchronized (this.zzdso)
    {
      FutureTask localFutureTask = new FutureTask(new zzavm(this, paramzzavw, paramString));
      if (this.zzdso.get() != null)
      {
        zzui().submit(localFutureTask);
        return localFutureTask;
      }
      this.zzdsp.add(localFutureTask);
    }
  }

  private final void zza(Context paramContext, String paramString1, String paramString2)
  {
    if (!zza(paramContext, "com.google.android.gms.measurement.AppMeasurement", this.zzdsl, true))
      return;
    Method localMethod = zzk(paramContext, paramString2);
    try
    {
      localMethod.invoke(this.zzdsl.get(), new Object[] { paramString1 });
      zzaxa.zzds(37 + String.valueOf(paramString2).length() + String.valueOf(paramString1).length() + "Invoke Firebase method " + paramString2 + ", Ad Unit Id: " + paramString1);
      return;
    }
    catch (Exception localException)
    {
      zza(localException, paramString2, false);
    }
  }

  private final void zza(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (!zzx(paramContext));
    Bundle localBundle;
    do
    {
      return;
      localBundle = zzj(paramString2, paramString1);
      if (paramBundle != null)
        localBundle.putAll(paramBundle);
      if (zzy(paramContext))
      {
        zza("logEventInternal", new zzavk(paramString1, localBundle));
        return;
      }
    }
    while (!zza(paramContext, "com.google.android.gms.measurement.AppMeasurement", this.zzdsl, true));
    Method localMethod = zzae(paramContext);
    try
    {
      localMethod.invoke(this.zzdsl.get(), new Object[] { "am", paramString1, localBundle });
      return;
    }
    catch (Exception localException)
    {
      zza(localException, "logEventInternal", true);
    }
  }

  private final void zza(Exception paramException, String paramString, boolean paramBoolean)
  {
    if (!this.zzdsj.get())
    {
      zzaxa.zzep(30 + String.valueOf(paramString).length() + "Invoke Firebase method " + paramString + " error.");
      if (paramBoolean)
      {
        zzaxa.zzep("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
        this.zzdsj.set(true);
      }
    }
  }

  private final void zza(String paramString, zzavx paramzzavx)
  {
    synchronized (this.zzdso)
    {
      FutureTask localFutureTask = new FutureTask(new zzavl(this, paramzzavx, paramString), null);
      if (this.zzdso.get() != null)
      {
        localFutureTask.run();
        return;
      }
      this.zzdsp.add(localFutureTask);
    }
  }

  private final boolean zza(Context paramContext, String paramString, AtomicReference<Object> paramAtomicReference, boolean paramBoolean)
  {
    if (paramAtomicReference.get() == null);
    try
    {
      paramAtomicReference.compareAndSet(null, paramContext.getClassLoader().loadClass(paramString).getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { paramContext }));
      return true;
    }
    catch (Exception localException)
    {
      zza(localException, "getInstance", paramBoolean);
    }
    return false;
  }

  private final Method zzae(Context paramContext)
  {
    Method localMethod1 = (Method)this.zzdsn.get("logEventInternal");
    if (localMethod1 != null)
      return localMethod1;
    try
    {
      Method localMethod2 = paramContext.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", new Class[] { String.class, String.class, Bundle.class });
      this.zzdsn.put("logEventInternal", localMethod2);
      return localMethod2;
    }
    catch (Exception localException)
    {
      zza(localException, "logEventInternal", true);
    }
    return null;
  }

  private static Bundle zzj(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putLong("_aeid", Long.parseLong(paramString1));
      if ("_ac".equals(paramString2))
        localBundle.putInt("_r", 1);
      return localBundle;
    }
    catch (NullPointerException localNullPointerException)
    {
      String str1 = String.valueOf(paramString1);
      if (str1.length() != 0);
      for (String str2 = "Invalid event ID: ".concat(str1); ; str2 = new String("Invalid event ID: "))
      {
        zzaxa.zzc(str2, localNullPointerException);
        break;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label40: break label40;
    }
  }

  private final Method zzk(Context paramContext, String paramString)
  {
    Method localMethod1 = (Method)this.zzdsn.get(paramString);
    if (localMethod1 != null)
      return localMethod1;
    try
    {
      Method localMethod2 = paramContext.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(paramString, new Class[] { String.class });
      this.zzdsn.put(paramString, localMethod2);
      return localMethod2;
    }
    catch (Exception localException)
    {
      zza(localException, paramString, false);
    }
    return null;
  }

  private final Method zzl(Context paramContext, String paramString)
  {
    Method localMethod1 = (Method)this.zzdsn.get(paramString);
    if (localMethod1 != null)
      return localMethod1;
    try
    {
      Method localMethod2 = paramContext.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(paramString, new Class[0]);
      this.zzdsn.put(paramString, localMethod2);
      return localMethod2;
    }
    catch (Exception localException)
    {
      zza(localException, paramString, false);
    }
    return null;
  }

  private final Method zzm(Context paramContext, String paramString)
  {
    Method localMethod1 = (Method)this.zzdsn.get(paramString);
    if (localMethod1 != null)
      return localMethod1;
    try
    {
      Method localMethod2 = paramContext.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(paramString, new Class[] { Activity.class, String.class, String.class });
      this.zzdsn.put(paramString, localMethod2);
      return localMethod2;
    }
    catch (Exception localException)
    {
      zza(localException, paramString, false);
    }
    return null;
  }

  private final ThreadPoolExecutor zzui()
  {
    if (this.zzdsf.get() == null)
    {
      AtomicReference localAtomicReference = this.zzdsf;
      zzaci localzzaci1 = zzact.zzcnz;
      int i = ((Integer)zzyr.zzpe().zzd(localzzaci1)).intValue();
      zzaci localzzaci2 = zzact.zzcnz;
      localAtomicReference.compareAndSet(null, new ThreadPoolExecutor(i, ((Integer)zzyr.zzpe().zzd(localzzaci2)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzavv(this)));
    }
    return (ThreadPoolExecutor)this.zzdsf.get();
  }

  @VisibleForTesting
  private static boolean zzy(Context paramContext)
  {
    zzaci localzzaci1 = zzact.zzcoa;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
    {
      zzaci localzzaci3 = zzact.zzcob;
      if (!((Boolean)zzyr.zzpe().zzd(localzzaci3)).booleanValue())
        return false;
    }
    zzaci localzzaci2 = zzact.zzcoc;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
      try
      {
        paramContext.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
        return false;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        return true;
      }
    return true;
  }

  public final void zza(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (!zzx(paramContext))
      return;
    Bundle localBundle = new Bundle();
    localBundle.putString("_ai", paramString2);
    localBundle.putString("type", paramString3);
    localBundle.putInt("value", paramInt);
    zza(paramContext, "_ar", paramString1, localBundle);
    zzaxa.zzds(75 + String.valueOf(paramString3).length() + "Log a Firebase reward video event, reward type: " + paramString3 + ", reward value: " + paramInt);
  }

  public final String zzaa(Context paramContext)
  {
    if (!zzx(paramContext))
      return null;
    synchronized (this.zzdsg)
    {
      if (this.zzdsh != null)
      {
        String str2 = this.zzdsh;
        return str2;
      }
    }
    if (zzy(paramContext));
    for (this.zzdsh = ((String)zza("getGmpAppId", this.zzdsh, zzavp.zzdsv)); ; this.zzdsh = ((String)zza("getGmpAppId", paramContext)))
    {
      String str1 = this.zzdsh;
      return str1;
    }
  }

  public final String zzab(Context paramContext)
  {
    if (!zzx(paramContext))
      return null;
    zzaci localzzaci = zzact.zzcny;
    long l = ((Long)zzyr.zzpe().zzd(localzzaci)).longValue();
    if (zzy(paramContext))
    {
      if (l < 0L);
      try
      {
        return (String)zza("getAppInstanceId", zzavq.zzdsv).get();
        String str2 = (String)zza("getAppInstanceId", zzavr.zzdsv).get(l, TimeUnit.MILLISECONDS);
        return str2;
      }
      catch (Exception localException2)
      {
        if ((localException2 instanceof TimeoutException))
          return "TIME_OUT";
        return null;
      }
    }
    if (l < 0L)
      return (String)zza("getAppInstanceId", paramContext);
    Future localFuture = zzui().submit(new zzavs(this, paramContext));
    try
    {
      String str1 = (String)localFuture.get(l, TimeUnit.MILLISECONDS);
      return str1;
    }
    catch (Exception localException1)
    {
      localFuture.cancel(true);
      if ((localException1 instanceof TimeoutException))
        return "TIME_OUT";
    }
    return null;
  }

  public final String zzac(Context paramContext)
  {
    if (!zzx(paramContext))
      return null;
    if (zzy(paramContext))
    {
      Long localLong = (Long)zza("getAdEventId", null, zzavt.zzdsv);
      if (localLong != null)
        return Long.toString(localLong.longValue());
      return null;
    }
    Object localObject = zza("generateEventId", paramContext);
    if (localObject != null)
      return localObject.toString();
    return null;
  }

  public final String zzad(Context paramContext)
  {
    if (!zzx(paramContext))
      return null;
    synchronized (this.zzdsg)
    {
      if (this.zzdsi != null)
      {
        String str2 = this.zzdsi;
        return str2;
      }
    }
    if (zzy(paramContext));
    for (this.zzdsi = ((String)zza("getAppIdOrigin", this.zzdsi, zzavu.zzdsv)); ; this.zzdsi = "fa")
    {
      String str1 = this.zzdsi;
      return str1;
    }
  }

  public final void zzd(Context paramContext, String paramString)
  {
    if (!zzx(paramContext))
      return;
    if (zzy(paramContext))
    {
      zza("beginAdUnitExposure", new zzavi(paramString));
      return;
    }
    zza(paramContext, paramString, "beginAdUnitExposure");
  }

  public final void zze(Context paramContext, String paramString)
  {
    if (!zzx(paramContext))
      return;
    if (zzy(paramContext))
    {
      zza("endAdUnitExposure", new zzavj(paramString));
      return;
    }
    zza(paramContext, paramString, "endAdUnitExposure");
  }

  public final void zzf(Context paramContext, String paramString)
  {
    if (!zzx(paramContext));
    do
    {
      do
        return;
      while (!(paramContext instanceof Activity));
      if (zzy(paramContext))
      {
        zza("setScreenName", new zzavo(paramContext, paramString));
        return;
      }
    }
    while (!zza(paramContext, "com.google.firebase.analytics.FirebaseAnalytics", this.zzdsm, false));
    Method localMethod = zzm(paramContext, "setCurrentScreen");
    try
    {
      Activity localActivity = (Activity)paramContext;
      Object localObject = this.zzdsm.get();
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = localActivity;
      arrayOfObject[1] = paramString;
      arrayOfObject[2] = paramContext.getPackageName();
      localMethod.invoke(localObject, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      zza(localException, "setCurrentScreen", false);
    }
  }

  public final void zzg(Context paramContext, String paramString)
  {
    zza(paramContext, "_ac", paramString, null);
  }

  public final void zzh(Context paramContext, String paramString)
  {
    zza(paramContext, "_ai", paramString, null);
  }

  public final void zzi(Context paramContext, String paramString)
  {
    zza(paramContext, "_aq", paramString, null);
  }

  public final void zzj(Context paramContext, String paramString)
  {
    zza(paramContext, "_aa", paramString, null);
  }

  public final boolean zzx(Context paramContext)
  {
    zzaci localzzaci1 = zzact.zzcnt;
    if ((!((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue()) || (this.zzdsj.get()))
      return false;
    zzaci localzzaci2 = zzact.zzcod;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
      return true;
    if (this.zzdsk.get() == -1)
    {
      zzyr.zzpa();
      if (zzazu.zzc(paramContext, 12451000))
        break label117;
      zzyr.zzpa();
      if (!zzazu.zzbg(paramContext))
        break label117;
      zzaxa.zzep("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
      this.zzdsk.set(0);
    }
    while (this.zzdsk.get() == 1)
    {
      return true;
      label117: this.zzdsk.set(1);
    }
    return false;
  }

  public final String zzz(Context paramContext)
  {
    String str;
    if (!zzx(paramContext))
      str = "";
    while (true)
    {
      return str;
      if (zzy(paramContext))
        return (String)zza("getCurrentScreenNameOrScreenClass", "", zzavn.zzdsv);
      if (!zza(paramContext, "com.google.android.gms.measurement.AppMeasurement", this.zzdsl, true))
        return "";
      try
      {
        str = (String)zzl(paramContext, "getCurrentScreenName").invoke(this.zzdsl.get(), new Object[0]);
        if (str == null)
          str = (String)zzl(paramContext, "getCurrentScreenClass").invoke(this.zzdsl.get(), new Object[0]);
        if (str == null)
          return "";
      }
      catch (Exception localException)
      {
        zza(localException, "getCurrentScreenName", false);
      }
    }
    return "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzavh
 * JD-Core Version:    0.6.2
 */