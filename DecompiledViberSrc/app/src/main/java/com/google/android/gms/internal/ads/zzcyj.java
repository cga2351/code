package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.ads.internal.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzcyj
{
  private final zzbaj zzbrd;
  private final zzawn zzbrx;
  private final Map<String, zzcyl> zzglr = new HashMap();
  private final zzdh zzgls;
  private final Context zzys;

  public zzcyj(Context paramContext, zzbaj paramzzbaj, zzawn paramzzawn)
  {
    this.zzys = paramContext;
    this.zzbrd = paramzzbaj;
    this.zzbrx = paramzzawn;
    this.zzgls = new zzdh(new zzg(paramContext, paramzzbaj));
  }

  private final zzcyl zzamt()
  {
    return new zzcyl(this.zzys, this.zzbrx.zzvc(), this.zzbrx.zzve(), this.zzgls, null);
  }

  private final zzcyl zzfx(String paramString)
  {
    zzasr localzzasr = zzasr.zzv(this.zzys);
    try
    {
      localzzasr.setAppPackageName(paramString);
      zzaxd localzzaxd = new zzaxd();
      localzzaxd.zza(this.zzys, paramString, false);
      zzaxg localzzaxg = new zzaxg(this.zzbrx.zzvc(), localzzaxd);
      return new zzcyl(localzzasr, localzzaxg, new zzawv(zzazu.zzwz(), localzzaxg), new zzdh(new zzg(this.zzys, this.zzbrd)), null);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return zzamt();
  }

  public final zzcyl zzfw(String paramString)
  {
    if (paramString == null)
      return zzamt();
    if (this.zzglr.containsKey(paramString))
      return (zzcyl)this.zzglr.get(paramString);
    zzcyl localzzcyl = zzfx(paramString);
    this.zzglr.put(paramString, localzzcyl);
    return localzzcyl;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcyj
 * JD-Core Version:    0.6.2
 */