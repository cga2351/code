package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzayv
{
  private static zzv zzdxj;
  private static final Object zzdxk = new Object();

  @Deprecated
  private static final zzayz<Void> zzdxl = new zzayw();

  public zzayv(Context paramContext)
  {
    if (paramContext.getApplicationContext() == null);
    while (true)
    {
      zzbd(paramContext);
      return;
      paramContext = paramContext.getApplicationContext();
    }
  }

  @VisibleForTesting
  private static zzv zzbd(Context paramContext)
  {
    synchronized (zzdxk)
    {
      if (zzdxj == null)
      {
        zzact.initialize(paramContext);
        zzaci localzzaci = zzact.zzctw;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        {
          localzzv2 = zzaym.zzbc(paramContext);
          zzdxj = localzzv2;
        }
      }
      else
      {
        zzv localzzv1 = zzdxj;
        return localzzv1;
      }
      zzak localzzak = new zzak(new zzat());
      zzv localzzv2 = new zzv(new zzan(new File(paramContext.getCacheDir(), "volley")), localzzak);
      localzzv2.start();
    }
  }

  public static zzbbi<zzp> zzeg(String paramString)
  {
    zzbbs localzzbbs = new zzbbs();
    zzdxj.zze(new zzazb(paramString, localzzbbs));
    return localzzbbs;
  }

  public final zzbbi<String> zza(int paramInt, String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    zzaza localzzaza = new zzaza(null);
    zzayx localzzayx = new zzayx(this, paramString, localzzaza);
    zzazy localzzazy = new zzazy(null);
    zzayy localzzayy = new zzayy(this, paramInt, paramString, localzzaza, localzzayx, paramArrayOfByte, paramMap, localzzazy);
    if (zzazy.isEnabled());
    try
    {
      localzzazy.zza(paramString, "GET", localzzayy.getHeaders(), localzzayy.zzg());
      zzdxj.zze(localzzayy);
      return localzzaza;
    }
    catch (zza localzza)
    {
      while (true)
        zzaxa.zzep(localzza.getMessage());
    }
  }

  public final zzbbi<String> zzc(String paramString, Map<String, String> paramMap)
  {
    return zza(0, paramString, paramMap, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzayv
 * JD-Core Version:    0.6.2
 */