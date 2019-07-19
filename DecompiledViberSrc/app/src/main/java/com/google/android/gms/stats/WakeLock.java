package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory;
import com.google.android.gms.common.stats.StatsUtils;
import com.google.android.gms.common.stats.WakeLockTracker;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@KeepForSdk
@ShowFirstParty
@ThreadSafe
public class WakeLock
{
  private static ScheduledExecutorService zzn;
  private static volatile zza zzo = new zza();
  private final Object zza = this;
  private final PowerManager.WakeLock zzb;
  private WorkSource zzc;
  private final int zzd;
  private final String zze;
  private final String zzf;
  private final String zzg;
  private final Context zzh;
  private boolean zzi = true;
  private final Map<String, Integer[]> zzj = new HashMap();
  private final Set<Future<?>> zzk = Collections.synchronizedSet(new HashSet());
  private int zzl;
  private AtomicInteger zzm = new AtomicInteger(0);

  @KeepForSdk
  public WakeLock(Context paramContext, int paramInt, String paramString)
  {
  }

  private WakeLock(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this(paramContext, paramInt, paramString1, null, paramString3, null);
  }

  @SuppressLint({"UnwrappedWakeLock"})
  private WakeLock(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Preconditions.checkNotNull(paramContext, "WakeLock: context must not be null");
    Preconditions.checkNotEmpty(paramString1, "WakeLock: wakeLockName must not be empty");
    this.zzd = paramInt;
    this.zzf = null;
    this.zzg = null;
    this.zzh = paramContext.getApplicationContext();
    String str1;
    String str3;
    if (!"com.google.android.gms".equals(paramContext.getPackageName()))
    {
      str1 = String.valueOf("*gcore*:");
      String str2 = String.valueOf(paramString1);
      if (str2.length() != 0)
        str3 = str1.concat(str2);
    }
    while (true)
    {
      this.zze = str3;
      label136: this.zzb = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt, paramString1);
      WorkSource localWorkSource1;
      WorkSource localWorkSource2;
      if (WorkSourceUtil.hasWorkSourcePermission(paramContext))
      {
        if (Strings.isEmptyOrWhitespace(paramString3))
          paramString3 = paramContext.getPackageName();
        this.zzc = WorkSourceUtil.fromPackage(paramContext, paramString3);
        localWorkSource1 = this.zzc;
        if ((localWorkSource1 != null) && (WorkSourceUtil.hasWorkSourcePermission(this.zzh)))
        {
          if (this.zzc == null)
            break label278;
          this.zzc.add(localWorkSource1);
          localWorkSource2 = this.zzc;
        }
      }
      try
      {
        this.zzb.setWorkSource(localWorkSource2);
        if (zzn == null)
          zzn = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
        return;
        str3 = new String(str1);
        continue;
        this.zze = paramString1;
        break label136;
        label278: this.zzc = localWorkSource1;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        while (true)
          Log.wtf("WakeLock", localArrayIndexOutOfBoundsException.toString());
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        label289: break label289;
      }
    }
  }

  private final String zza(String paramString)
  {
    if (this.zzi)
    {
      if (!TextUtils.isEmpty(paramString))
        return paramString;
      return this.zzf;
    }
    return this.zzf;
  }

  private final List<String> zza()
  {
    return WorkSourceUtil.getNames(this.zzc);
  }

  private final void zza(int paramInt)
  {
    if (this.zzb.isHeld());
    try
    {
      this.zzb.release();
      this.zzb.isHeld();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (localRuntimeException.getClass().equals(RuntimeException.class))
        Log.e("WakeLock", String.valueOf(this.zze).concat(" was already released!"), localRuntimeException);
      throw localRuntimeException;
    }
  }

  @KeepForSdk
  public void acquire(long paramLong)
  {
    this.zzm.incrementAndGet();
    String str = zza(null);
    while (true)
    {
      int i;
      synchronized (this.zza)
      {
        if (((!this.zzj.isEmpty()) || (this.zzl > 0)) && (!this.zzb.isHeld()))
        {
          this.zzj.clear();
          this.zzl = 0;
        }
        Integer[] arrayOfInteger1;
        if (this.zzi)
        {
          arrayOfInteger1 = (Integer[])this.zzj.get(str);
          if (arrayOfInteger1 == null)
          {
            Map localMap = this.zzj;
            Integer[] arrayOfInteger2 = new Integer[1];
            arrayOfInteger2[0] = Integer.valueOf(1);
            localMap.put(str, arrayOfInteger2);
            i = 1;
            break label262;
          }
        }
        else
        {
          if ((!this.zzi) && (this.zzl == 0))
          {
            WakeLockTracker.getInstance().registerEvent(this.zzh, StatsUtils.getEventKey(this.zzb, str), 7, this.zze, str, null, this.zzd, zza(), paramLong);
            this.zzl = (1 + this.zzl);
          }
          this.zzb.acquire();
          if (paramLong > 0L)
            zzn.schedule(new zzb(this), paramLong, TimeUnit.MILLISECONDS);
          return;
        }
        arrayOfInteger1[0] = Integer.valueOf(1 + arrayOfInteger1[0].intValue());
        i = 0;
      }
      label262: if (i != 0);
    }
  }

  @KeepForSdk
  public boolean isHeld()
  {
    return this.zzb.isHeld();
  }

  @KeepForSdk
  public void release()
  {
    if (this.zzm.decrementAndGet() < 0)
      Log.e("WakeLock", String.valueOf(this.zze).concat(" release without a matched acquire!"));
    String str = zza(null);
    while (true)
    {
      int i;
      synchronized (this.zza)
      {
        Integer[] arrayOfInteger;
        if (this.zzi)
        {
          arrayOfInteger = (Integer[])this.zzj.get(str);
          if (arrayOfInteger == null)
          {
            i = 0;
            break label197;
          }
        }
        else
        {
          if ((!this.zzi) && (this.zzl == 1))
          {
            WakeLockTracker.getInstance().registerEvent(this.zzh, StatsUtils.getEventKey(this.zzb, str), 8, this.zze, str, null, this.zzd, zza());
            this.zzl = (-1 + this.zzl);
          }
          zza(0);
          return;
        }
        if (arrayOfInteger[0].intValue() == 1)
        {
          this.zzj.remove(str);
          i = 1;
        }
        else
        {
          arrayOfInteger[0] = Integer.valueOf(-1 + arrayOfInteger[0].intValue());
          i = 0;
        }
      }
      label197: if (i != 0);
    }
  }

  @KeepForSdk
  public void setReferenceCounted(boolean paramBoolean)
  {
    this.zzb.setReferenceCounted(paramBoolean);
    this.zzi = paramBoolean;
  }

  public static abstract interface zza
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.stats.WakeLock
 * JD-Core Version:    0.6.2
 */