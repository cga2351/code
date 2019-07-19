package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaci;
import com.google.android.gms.internal.ads.zzacq;
import com.google.android.gms.internal.ads.zzact;
import com.google.android.gms.internal.ads.zzalk;
import com.google.android.gms.internal.ads.zzall;
import com.google.android.gms.internal.ads.zzalp;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzawm;
import com.google.android.gms.internal.ads.zzaxa;
import com.google.android.gms.internal.ads.zzbaj;
import com.google.android.gms.internal.ads.zzbap;
import com.google.android.gms.internal.ads.zzbas;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzyr;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzare
@ParametersAreNonnullByDefault
public final class zzd
{
  private long zzbqz = 0L;
  private Context zzlj;

  @VisibleForTesting
  private final void zza(Context paramContext, zzbaj paramzzbaj, boolean paramBoolean, zzawm paramzzawm, String paramString1, String paramString2, Runnable paramRunnable)
  {
    if (zzk.zzln().elapsedRealtime() - this.zzbqz < 5000L)
      zzaxa.zzep("Not retrying to fetch app settings");
    while (true)
    {
      return;
      this.zzbqz = zzk.zzln().elapsedRealtime();
      int j;
      if (paramzzawm == null)
        j = 1;
      while (j != 0)
      {
        if (paramContext != null)
          break label140;
        zzaxa.zzep("Context not provided to fetch application settings");
        return;
        long l1 = paramzzawm.zzuq();
        long l2 = zzk.zzln().currentTimeMillis() - l1;
        zzaci localzzaci = zzact.zzcsz;
        if (l2 > ((Long)zzyr.zzpe().zzd(localzzaci)).longValue());
        for (int i = 1; ; i = 0)
        {
          if ((i == 0) && (paramzzawm.zzur()))
            break label134;
          j = 1;
          break;
        }
        label134: j = 0;
      }
    }
    label140: if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      zzaxa.zzep("App settings could not be fetched. Required parameters missing");
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    zzalk localzzalk;
    if (localContext != null)
    {
      this.zzlj = localContext;
      localzzalk = zzk.zzlt().zzb(this.zzlj, paramzzbaj).zza("google.afma.config.fetchAppSettings", zzalp.zzddk, zzalp.zzddk);
    }
    while (true)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        if (TextUtils.isEmpty(paramString1))
          break label316;
        localJSONObject.put("app_id", paramString1);
        localJSONObject.put("is_init", paramBoolean);
        localJSONObject.put("pn", paramContext.getPackageName());
        zzbbi localzzbbi1 = localzzalk.zzi(localJSONObject);
        zzbbi localzzbbi2 = zzbas.zza(localzzbbi1, zze.zzbra, zzbbn.zzeah);
        if (paramRunnable != null)
          localzzbbi1.zza(paramRunnable, zzbbn.zzeah);
        zzbap.zza(localzzbbi2, "ConfigLoader.maybeFetchNewAppSettings");
        return;
      }
      catch (Exception localException)
      {
        zzaxa.zzc("Error requesting application settings", localException);
        return;
      }
      localContext = paramContext;
      break;
      label316: if (!TextUtils.isEmpty(paramString2))
        localJSONObject.put("ad_unit_id", paramString2);
    }
  }

  public final void zza(Context paramContext, zzbaj paramzzbaj, String paramString, zzawm paramzzawm)
  {
    if (paramzzawm != null);
    for (String str = paramzzawm.zzut(); ; str = null)
    {
      zza(paramContext, paramzzbaj, false, paramzzawm, str, paramString, null);
      return;
    }
  }

  public final void zza(Context paramContext, zzbaj paramzzbaj, String paramString, Runnable paramRunnable)
  {
    zza(paramContext, paramzzbaj, true, null, paramString, null, paramRunnable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.zzd
 * JD-Core Version:    0.6.2
 */