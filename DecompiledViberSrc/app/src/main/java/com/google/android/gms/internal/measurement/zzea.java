package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class zzea
{
  private static volatile zzea zzadk;
  private final String zzadh;
  private final ExecutorService zzadl;
  private final AppMeasurementSdk zzadm;
  private Map<zzcy, zzd> zzadn;
  private int zzado;
  private boolean zzadp;
  private String zzadq;
  private zzdn zzadr;
  protected final Clock zzrz;

  private zzea(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Application localApplication;
    if ((paramString1 == null) || (!zze(paramString2, paramString3)))
    {
      this.zzadh = "FA";
      this.zzrz = DefaultClock.getInstance();
      this.zzadl = new ThreadPoolExecutor(0, i, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
      localApplication = (Application)paramContext.getApplicationContext();
      if (localApplication != null)
        break label148;
      Log.w(this.zzadh, "Unable to register lifecycle notifications. Application null.");
      label84: this.zzadm = new AppMeasurementSdk(this);
      if ((zzf(paramContext)) && (!zzgb()))
        break label164;
    }
    label148: label164: for (int j = i; ; j = 0)
    {
      if (j != 0)
        break label170;
      this.zzadq = null;
      this.zzadp = i;
      Log.w(this.zzadh, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
      return;
      this.zzadh = paramString1;
      break;
      localApplication.registerActivityLifecycleCallbacks(new zze());
      break label84;
    }
    label170: int k;
    if (!zze(paramString2, paramString3))
    {
      this.zzadq = "fa";
      if ((paramString2 != null) && (paramString3 != null))
      {
        Log.v(this.zzadh, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
        this.zzadp = i;
        return;
      }
      if (paramString2 == null)
      {
        k = i;
        if (paramString3 != null)
          break label267;
        label224: if ((k ^ i) != 0)
          Log.w(this.zzadh, "Specified origin or custom app id is null. Both parameters will be ignored.");
      }
    }
    while (true)
    {
      zza(new zzeb(this, paramContext, paramString2, paramString3, paramBundle));
      return;
      k = 0;
      break;
      label267: i = 0;
      break label224;
      this.zzadq = paramString2;
    }
  }

  public static zzea zza(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Preconditions.checkNotNull(paramContext);
    if (zzadk == null);
    try
    {
      if (zzadk == null)
        zzadk = new zzea(paramContext, paramString1, paramString2, paramString3, paramBundle);
      return zzadk;
    }
    finally
    {
    }
  }

  private final void zza(zzb paramzzb)
  {
    this.zzadl.execute(paramzzb);
  }

  private final void zza(Exception paramException, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzadp = (paramBoolean1 | this.zzadp);
    if (paramBoolean1)
    {
      Log.w(this.zzadh, "Data collection startup failed. No data will be collected.", paramException);
      return;
    }
    if (paramBoolean2)
      zzc(5, "Error with data collection. Data lost.", paramException, null, null);
    Log.w(this.zzadh, "Error with data collection. Data lost.", paramException);
  }

  private final void zza(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, Long paramLong)
  {
    zza(new zzeu(this, paramLong, paramString1, paramString2, paramBundle, true, paramBoolean2));
  }

  private static boolean zze(String paramString1, String paramString2)
  {
    return (paramString2 != null) && (paramString1 != null) && (!zzgb());
  }

  private static boolean zzf(Context paramContext)
  {
    try
    {
      GoogleServices.initialize(paramContext);
      String str = GoogleServices.getGoogleAppId();
      boolean bool = false;
      if (str != null)
        bool = true;
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
    return false;
  }

  private static boolean zzgb()
  {
    try
    {
      Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }

  private static int zzh(Context paramContext)
  {
    return DynamiteModule.getRemoteVersion(paramContext, "com.google.android.gms.measurement.dynamite");
  }

  private static int zzi(Context paramContext)
  {
    return DynamiteModule.getLocalVersion(paramContext, "com.google.android.gms.measurement.dynamite");
  }

  public final void beginAdUnitExposure(String paramString)
  {
    zza(new zzeg(this, paramString));
  }

  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    zza(new zzec(this, paramString1, paramString2, paramBundle));
  }

  public final void endAdUnitExposure(String paramString)
  {
    zza(new zzeh(this, paramString));
  }

  public final long generateEventId()
  {
    zza localzza = new zza();
    zza(new zzel(this, localzza));
    Long localLong = (Long)localzza.zza(localzza.zzl(500L), Long.class);
    if (localLong == null)
    {
      long l = new Random(System.nanoTime() ^ this.zzrz.currentTimeMillis()).nextLong();
      int i = 1 + this.zzado;
      this.zzado = i;
      return l + i;
    }
    return localLong.longValue();
  }

  public final String getAppIdOrigin()
  {
    return this.zzadq;
  }

  public final List<Bundle> getConditionalUserProperties(String paramString1, String paramString2)
  {
    zza localzza = new zza();
    zza(new zzed(this, paramString1, paramString2, localzza));
    List localList = (List)localzza.zza(localzza.zzl(5000L), List.class);
    if (localList == null)
      localList = Collections.emptyList();
    return localList;
  }

  public final String getCurrentScreenClass()
  {
    zza localzza = new zza();
    zza(new zzen(this, localzza));
    return localzza.zzk(500L);
  }

  public final String getCurrentScreenName()
  {
    zza localzza = new zza();
    zza(new zzem(this, localzza));
    return localzza.zzk(500L);
  }

  public final String getGmpAppId()
  {
    zza localzza = new zza();
    zza(new zzej(this, localzza));
    return localzza.zzk(500L);
  }

  public final int getMaxUserProperties(String paramString)
  {
    zza localzza = new zza();
    zza(new zzer(this, paramString, localzza));
    Integer localInteger = (Integer)localzza.zza(localzza.zzl(10000L), Integer.class);
    if (localInteger == null)
      return 25;
    return localInteger.intValue();
  }

  public final Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    zza localzza = new zza();
    zza(new zzeo(this, paramString1, paramString2, paramBoolean, localzza));
    Bundle localBundle = localzza.zzl(5000L);
    if ((localBundle == null) || (localBundle.size() == 0))
      return Collections.emptyMap();
    HashMap localHashMap = new HashMap(localBundle.size());
    Iterator localIterator = localBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = localBundle.get(str);
      if (((localObject instanceof Double)) || ((localObject instanceof Long)) || ((localObject instanceof String)))
        localHashMap.put(str, localObject);
    }
    return localHashMap;
  }

  public final void logEventInternal(String paramString1, String paramString2, Bundle paramBundle)
  {
    zza(paramString1, paramString2, paramBundle, true, true, null);
  }

  public final void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    zza(paramString1, paramString2, paramBundle, true, false, Long.valueOf(paramLong));
  }

  public final void setConditionalUserProperty(Bundle paramBundle)
  {
    zza(new zzew(this, paramBundle));
  }

  public final void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2)
  {
    zza(new zzee(this, paramActivity, paramString1, paramString2));
  }

  public final void setMeasurementEnabled(boolean paramBoolean)
  {
    zza(new zzef(this, paramBoolean));
  }

  public final Bundle zza(Bundle paramBundle, boolean paramBoolean)
  {
    zza localzza = new zza();
    zza(new zzeq(this, paramBundle, localzza));
    if (paramBoolean)
      return localzza.zzl(5000L);
    return null;
  }

  public final void zza(zzcx paramzzcx)
  {
    zza(new zzei(this, paramzzcx));
  }

  public final void zza(zzcy paramzzcy)
  {
    zza(new zzes(this, paramzzcy));
  }

  public final void zza(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    zza(new zzev(this, paramString1, paramString2, paramObject, true));
  }

  public final void zzb(zzcy paramzzcy)
  {
    zza(new zzet(this, paramzzcy));
  }

  public final void zzc(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zza(new zzep(this, false, 5, paramString, paramObject1, paramObject2, paramObject3));
  }

  protected final zzdn zzg(Context paramContext)
  {
    try
    {
      zzdn localzzdn = zzdo.asInterface(DynamiteModule.load(paramContext, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, "com.google.android.gms.measurement.dynamite").instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
      return localzzdn;
    }
    catch (DynamiteModule.LoadingException localLoadingException)
    {
      zza(localLoadingException, true, false);
    }
    return null;
  }

  public final AppMeasurementSdk zzga()
  {
    return this.zzadm;
  }

  public final String zzgc()
  {
    zza localzza = new zza();
    zza(new zzek(this, localzza));
    return localzza.zzk(50L);
  }

  final class zza extends zzdr
  {
    private final AtomicReference<Bundle> zzaet = new AtomicReference();
    private boolean zzaeu;

    zza()
    {
    }

    final <T> T zza(Bundle paramBundle, Class<T> paramClass)
    {
      Object localObject1 = null;
      Object localObject2;
      if (paramBundle != null)
      {
        localObject2 = paramBundle.get("r");
        localObject1 = null;
        if (localObject2 == null);
      }
      try
      {
        Object localObject3 = paramClass.cast(localObject2);
        localObject1 = localObject3;
        return localObject1;
      }
      catch (ClassCastException localClassCastException)
      {
        String str1 = paramClass.getCanonicalName();
        String str2 = localObject2.getClass().getCanonicalName();
        zzea.this.zzc(5, "Unexpected object type. Expected, Received", str1, str2, localClassCastException);
        Log.w(zzea.zzc(zzea.this), String.format(String.valueOf("Unexpected object type. Expected, Received").concat(": %s, %s"), new Object[] { str1, str2 }), localClassCastException);
        throw localClassCastException;
      }
    }

    // ERROR //
    public final void zzb(Bundle paramBundle)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 23	com/google/android/gms/internal/measurement/zzea$zza:zzaet	Ljava/util/concurrent/atomic/AtomicReference;
      //   4: astore_2
      //   5: aload_2
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 23	com/google/android/gms/internal/measurement/zzea$zza:zzaet	Ljava/util/concurrent/atomic/AtomicReference;
      //   11: aload_1
      //   12: invokevirtual 90	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
      //   15: aload_0
      //   16: iconst_1
      //   17: putfield 92	com/google/android/gms/internal/measurement/zzea$zza:zzaeu	Z
      //   20: aload_0
      //   21: getfield 23	com/google/android/gms/internal/measurement/zzea$zza:zzaet	Ljava/util/concurrent/atomic/AtomicReference;
      //   24: invokevirtual 95	java/lang/Object:notify	()V
      //   27: aload_2
      //   28: monitorexit
      //   29: return
      //   30: astore_3
      //   31: aload_0
      //   32: getfield 23	com/google/android/gms/internal/measurement/zzea$zza:zzaet	Ljava/util/concurrent/atomic/AtomicReference;
      //   35: invokevirtual 95	java/lang/Object:notify	()V
      //   38: aload_3
      //   39: athrow
      //   40: astore 4
      //   42: aload_2
      //   43: monitorexit
      //   44: aload 4
      //   46: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   7	20	30	finally
      //   20	29	40	finally
      //   31	40	40	finally
      //   42	44	40	finally
    }

    final String zzk(long paramLong)
    {
      return (String)zza(zzl(paramLong), String.class);
    }

    final Bundle zzl(long paramLong)
    {
      synchronized (this.zzaet)
      {
        boolean bool = this.zzaeu;
        if (!bool);
        try
        {
          this.zzaet.wait(paramLong);
          Bundle localBundle = (Bundle)this.zzaet.get();
          return localBundle;
        }
        catch (InterruptedException localInterruptedException)
        {
          return null;
        }
      }
    }
  }

  abstract class zzb
    implements Runnable
  {
    final long timestamp = zzea.this.zzrz.currentTimeMillis();
    final long zzaev = zzea.this.zzrz.elapsedRealtime();
    private final boolean zzaew;

    zzb()
    {
      this(true);
    }

    zzb(boolean arg2)
    {
      boolean bool;
      this.zzaew = bool;
    }

    public void run()
    {
      if (zzea.zza(zzea.this))
      {
        zzge();
        return;
      }
      try
      {
        zzgd();
        return;
      }
      catch (Exception localException)
      {
        zzea.zza(zzea.this, localException, false, this.zzaew);
        zzge();
      }
    }

    abstract void zzgd()
      throws RemoteException;

    protected void zzge()
    {
    }
  }

  static final class zzc extends zzdu
  {
    private final zzcx zzaex;

    zzc(zzcx paramzzcx)
    {
      this.zzaex = paramzzcx;
    }

    public final int id()
    {
      return this.zzaex.hashCode();
    }

    public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
    {
      this.zzaex.interceptEvent(paramString1, paramString2, paramBundle, paramLong);
    }
  }

  static final class zzd extends zzdu
  {
    private final zzcy zzaey;

    zzd(zzcy paramzzcy)
    {
      this.zzaey = paramzzcy;
    }

    public final int id()
    {
      return this.zzaey.hashCode();
    }

    public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
    {
      this.zzaey.onEvent(paramString1, paramString2, paramBundle, paramLong);
    }
  }

  final class zze
    implements Application.ActivityLifecycleCallbacks
  {
    zze()
    {
    }

    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      zzea.zza(zzea.this, new zzex(this, paramActivity, paramBundle));
    }

    public final void onActivityDestroyed(Activity paramActivity)
    {
      zzea.zza(zzea.this, new zzfd(this, paramActivity));
    }

    public final void onActivityPaused(Activity paramActivity)
    {
      zzea.zza(zzea.this, new zzfa(this, paramActivity));
    }

    public final void onActivityResumed(Activity paramActivity)
    {
      zzea.zza(zzea.this, new zzez(this, paramActivity));
    }

    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
      zzea.zza localzza = new zzea.zza(zzea.this);
      zzea.zza(zzea.this, new zzfc(this, paramActivity, localzza));
      Bundle localBundle = localzza.zzl(50L);
      if (localBundle != null)
        paramBundle.putAll(localBundle);
    }

    public final void onActivityStarted(Activity paramActivity)
    {
      zzea.zza(zzea.this, new zzey(this, paramActivity));
    }

    public final void onActivityStopped(Activity paramActivity)
    {
      zzea.zza(zzea.this, new zzfb(this, paramActivity));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzea
 * JD-Core Version:    0.6.2
 */