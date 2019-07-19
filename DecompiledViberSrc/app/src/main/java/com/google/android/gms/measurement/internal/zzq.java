package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzq extends zzcr
{
  private Boolean zzagw;
  private zzs zzagx = zzr.zzagy;
  private Boolean zzyk;

  zzq(zzbw paramzzbw)
  {
    super(paramzzbw);
    zzai.zza(paramzzbw);
  }

  static String zzhy()
  {
    return (String)zzai.zzaiu.get();
  }

  public static long zzib()
  {
    return ((Long)zzai.zzajx.get()).longValue();
  }

  public static long zzic()
  {
    return ((Long)zzai.zzaix.get()).longValue();
  }

  public static boolean zzie()
  {
    return ((Boolean)zzai.zzait.get()).booleanValue();
  }

  static boolean zzig()
  {
    return ((Boolean)zzai.zzakt.get()).booleanValue();
  }

  public final long zza(String paramString, zzai.zza<Long> paramzza)
  {
    if (paramString == null)
      return ((Long)paramzza.get()).longValue();
    String str = this.zzagx.zzf(paramString, paramzza.getKey());
    if (TextUtils.isEmpty(str))
      return ((Long)paramzza.get()).longValue();
    try
    {
      long l = ((Long)paramzza.get(Long.valueOf(Long.parseLong(str)))).longValue();
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return ((Long)paramzza.get()).longValue();
  }

  final void zza(zzs paramzzs)
  {
    this.zzagx = paramzzs;
  }

  public final boolean zza(zzai.zza<Boolean> paramzza)
  {
    return zzd(null, paramzza);
  }

  public final int zzaq(String paramString)
  {
    return zzb(paramString, zzai.zzaji);
  }

  @VisibleForTesting
  final Boolean zzar(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    ApplicationInfo localApplicationInfo;
    try
    {
      if (getContext().getPackageManager() == null)
      {
        zzgt().zzjg().zzby("Failed to load metadata: PackageManager is null");
        return null;
      }
      localApplicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
      if (localApplicationInfo == null)
      {
        zzgt().zzjg().zzby("Failed to load metadata: ApplicationInfo is null");
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      zzgt().zzjg().zzg("Failed to load metadata: Package name not found", localNameNotFoundException);
      return null;
    }
    if (localApplicationInfo.metaData == null)
    {
      zzgt().zzjg().zzby("Failed to load metadata: Metadata bundle is null");
      return null;
    }
    boolean bool = localApplicationInfo.metaData.containsKey(paramString);
    Object localObject = null;
    if (bool)
    {
      Boolean localBoolean = Boolean.valueOf(localApplicationInfo.metaData.getBoolean(paramString));
      localObject = localBoolean;
    }
    return localObject;
  }

  public final boolean zzas(String paramString)
  {
    return "1".equals(this.zzagx.zzf(paramString, "gaia_collection_enabled"));
  }

  public final boolean zzat(String paramString)
  {
    return "1".equals(this.zzagx.zzf(paramString, "measurement.event_sampling_enabled"));
  }

  final boolean zzau(String paramString)
  {
    return zzd(paramString, zzai.zzakh);
  }

  final boolean zzav(String paramString)
  {
    return zzd(paramString, zzai.zzakj);
  }

  final boolean zzaw(String paramString)
  {
    return zzd(paramString, zzai.zzakk);
  }

  final boolean zzax(String paramString)
  {
    return zzd(paramString, zzai.zzakb);
  }

  final String zzay(String paramString)
  {
    zzai.zza localzza = zzai.zzakc;
    if (paramString == null)
      return (String)localzza.get();
    return (String)localzza.get(this.zzagx.zzf(paramString, localzza.getKey()));
  }

  final boolean zzaz(String paramString)
  {
    return zzd(paramString, zzai.zzakl);
  }

  public final int zzb(String paramString, zzai.zza<Integer> paramzza)
  {
    if (paramString == null)
      return ((Integer)paramzza.get()).intValue();
    String str = this.zzagx.zzf(paramString, paramzza.getKey());
    if (TextUtils.isEmpty(str))
      return ((Integer)paramzza.get()).intValue();
    try
    {
      int i = ((Integer)paramzza.get(Integer.valueOf(Integer.parseInt(str)))).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return ((Integer)paramzza.get()).intValue();
  }

  final boolean zzba(String paramString)
  {
    return zzd(paramString, zzai.zzakm);
  }

  final boolean zzbb(String paramString)
  {
    return zzd(paramString, zzai.zzako);
  }

  final boolean zzbc(String paramString)
  {
    return zzd(paramString, zzai.zzakp);
  }

  final boolean zzbd(String paramString)
  {
    return zzd(paramString, zzai.zzakq);
  }

  final boolean zzbe(String paramString)
  {
    return zzd(paramString, zzai.zzaks);
  }

  final boolean zzbf(String paramString)
  {
    return zzd(paramString, zzai.zzakr);
  }

  final boolean zzbg(String paramString)
  {
    return zzd(paramString, zzai.zzaku);
  }

  final boolean zzbh(String paramString)
  {
    return zzd(paramString, zzai.zzakv);
  }

  final boolean zzbi(String paramString)
  {
    return zzd(paramString, zzai.zzakw);
  }

  final boolean zzbj(String paramString)
  {
    return zzd(paramString, zzai.zzakx);
  }

  final boolean zzbk(String paramString)
  {
    return zzd(paramString, zzai.zzalb);
  }

  public final double zzc(String paramString, zzai.zza<Double> paramzza)
  {
    if (paramString == null)
      return ((Double)paramzza.get()).doubleValue();
    String str = this.zzagx.zzf(paramString, paramzza.getKey());
    if (TextUtils.isEmpty(str))
      return ((Double)paramzza.get()).doubleValue();
    try
    {
      double d = ((Double)paramzza.get(Double.valueOf(Double.parseDouble(str)))).doubleValue();
      return d;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return ((Double)paramzza.get()).doubleValue();
  }

  public final boolean zzd(String paramString, zzai.zza<Boolean> paramzza)
  {
    if (paramString == null)
      return ((Boolean)paramzza.get()).booleanValue();
    String str = this.zzagx.zzf(paramString, paramzza.getKey());
    if (TextUtils.isEmpty(str))
      return ((Boolean)paramzza.get()).booleanValue();
    return ((Boolean)paramzza.get(Boolean.valueOf(Boolean.parseBoolean(str)))).booleanValue();
  }

  public final boolean zzdw()
  {
    if (this.zzyk == null);
    try
    {
      if (this.zzyk == null)
      {
        ApplicationInfo localApplicationInfo = getContext().getApplicationInfo();
        String str1 = ProcessUtils.getMyProcessName();
        if (localApplicationInfo != null)
        {
          String str2 = localApplicationInfo.processName;
          if ((str2 == null) || (!str2.equals(str1)))
            break label101;
        }
      }
      label101: for (boolean bool = true; ; bool = false)
      {
        this.zzyk = Boolean.valueOf(bool);
        if (this.zzyk == null)
        {
          this.zzyk = Boolean.TRUE;
          zzgt().zzjg().zzby("My process not in the list of running processes");
        }
        return this.zzyk.booleanValue();
      }
    }
    finally
    {
    }
  }

  public final boolean zze(String paramString, zzai.zza<Boolean> paramzza)
  {
    return zzd(paramString, paramzza);
  }

  public final long zzhh()
  {
    zzgw();
    return 14711L;
  }

  public final boolean zzhz()
  {
    zzgw();
    Boolean localBoolean = zzar("firebase_analytics_collection_deactivated");
    return (localBoolean != null) && (localBoolean.booleanValue());
  }

  public final Boolean zzia()
  {
    zzgw();
    return zzar("firebase_analytics_collection_enabled");
  }

  public final String zzid()
  {
    try
    {
      String str = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { "debug.firebase.analytics.app", "" });
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      zzgt().zzjg().zzg("Could not find SystemProperties class", localClassNotFoundException);
      return "";
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
        zzgt().zzjg().zzg("Could not find SystemProperties.get() method", localNoSuchMethodException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        zzgt().zzjg().zzg("Could not access SystemProperties.get()", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        zzgt().zzjg().zzg("SystemProperties.get() threw an exception", localInvocationTargetException);
    }
  }

  final boolean zzif()
  {
    if (this.zzagw == null)
    {
      this.zzagw = zzar("app_measurement_lite");
      if (this.zzagw == null)
        this.zzagw = Boolean.valueOf(false);
    }
    boolean bool1;
    if (!this.zzagw.booleanValue())
    {
      boolean bool2 = this.zzada.zzkr();
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

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzq
 * JD-Core Version:    0.6.2
 */